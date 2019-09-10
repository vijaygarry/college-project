import java.io.*;
import java.sql.*;
import java.util.Properties;

class NewAccount
{
    public static void main(String[] args) 
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        Connection con;
        PreparedStatement pst;
        int no,choice;
        String nm,typ,str;
        double bal;

        try
        {
            Properties props = new Properties();
			
			String dbSettingsPropertyFile = "C:\\Users\\dell\\Desktop\\New folder\\JDBCSettings.properties";
			
			FileReader fReader = new FileReader(dbSettingsPropertyFile);
			
            props.load(fReader);
            
            String dbDriverClass = props.getProperty("db.driver.class");
			
			String dbConnUrl = props.getProperty("db.conn.url");
			
			String dbUserName = props.getProperty("db.username");
			
			String dbPassword = props.getProperty("db.password");
			
            System.out.println("1.Select Statement");
            System.out.println("2.Insert Statement");
            System.out.println("3.Update Statement");
            System.out.println("4.Delete Statement");
            System.out.print("Choose any one: ");
            choice = Integer.parseInt(br.readLine());

            Class.forName(dbDriverClass);

            con = DriverManager.getConnection(dbConnUrl, dbUserName, dbPassword);

            switch(choice)
            {
                case 1:
                    Statement smt = con.createStatement();
                    String q = "Select * from account";
                    ResultSet rs = smt.executeQuery(q);
                    if(rs.next())
                    {
                        do{
                            System.out.println(rs.getString(1)+"|"+rs.getString(2)+"|"+rs.getString(3)+"|"+rs.getString(4));
                        }while(rs.next());
                    }
                    else
                    {
                        System.out.print("Record not found...");
                    }
                    System.out.println("Data Displayed Successfully");
                    break;
                
                case 2:
                    System.out.print("Enter Account Number: ");
                    no = Integer.parseInt(br.readLine());
                    System.out.print("Enter Name: ");
                    nm = br.readLine();
                    System.out.print("Enter Type: ");
                    typ = br.readLine();
                    System.out.print("Enter Balance: ");
                    bal = Integer.parseInt(br.readLine());
                    pst = con.prepareStatement("insert into account values(?,?,?,?);");

                    pst.setInt(1, no);
                    pst.setString(2, nm);
                    pst.setString(3, typ);
                    pst.setDouble(4, bal);

                    pst.executeUpdate();

                    System.out.println("Account opened Successfully");
                    break;

                case 3:
                    System.out.print("Enter Account Number on which you want data to get updated: ");
                    no = Integer.parseInt(br.readLine());
                    System.out.print("Enter which parameter you want updation on: ");
                    str = br.readLine();

                    if(str.equals("name"))
                    {
                        System.out.print("Enter Name: ");
                        nm = br.readLine();
                        pst = con.prepareStatement("update account set accnm=? where accno=?;");
                        pst.setString(1, nm);
                        pst.setInt(2, no);
                        int cnt = pst.executeUpdate();
                        if(cnt>0)
                        {
                            System.out.println("Name Updated Successfully");
                        }
                        else
                        {
                            System.out.println("Error Occurs");
                        }
                    }
                    else if(str.equals("Type"))
                    {
                        System.out.print("Enter Type: ");
                        typ = br.readLine();
                        pst = con.prepareStatement("update account set acctyp=? where accno=?;");
                        pst.setString(1, typ);
                        pst.setInt(2, no);
                        int cnt = pst.executeUpdate();
                        if(cnt>0)
                        {
                            System.out.println("Name Updated Successfully");
                        }
                        else
                        {
                            System.out.println("Error Occurs");
                        }
                    }
                    else
                    {
                        System.out.print("Enter Balance: ");
                        bal = Integer.parseInt(br.readLine());
                        pst = con.prepareStatement("update account set balance=? where accno=?;");
                        pst.setDouble(1, bal);
                        pst.setInt(2, no);
                        int cnt = pst.executeUpdate();
                        if(cnt>0)
                        {
                            System.out.println("balance Updated Successfully");
                        }
                        else
                        {
                            System.out.println("Error Occurs");
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number to be deleted: ");
                    no = Integer.parseInt(br.readLine());
                    pst = con.prepareStatement("delete from account where accno=?;");
                    pst.setInt(1, no);
                    pst.executeUpdate();
                    System.out.println("Account deleted Successfully");
                    break;

                default:
                    System.out.println("Invalid Input");
                    break;
            }
            
            

            con.close();
        }

        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}