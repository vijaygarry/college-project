import java.sql.*;
import java.io.*;
import java.util.*;

class CSVtoDB
{
    public static void main(String[] args) throws FileNotFoundException {
        String fileName1 = "C:/Users/Percy/Desktop/JavaPrograms/Accounts.csv";
        //FileReader fr = new FileReader(fileName1);
        BufferedReader br = new BufferedReader(new FileReader(fileName1));
        String line;
        Connection con;
        PreparedStatement pst;

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spiderdb?user=root&password=IronMan3000&useSSL=False");
            while((line=br.readLine())!=null)
            {
                String[] value = line.split(",");
                String sql = "insert into account2 values('"+value[0]+"','"+value[1]+"','"+value[2]+"','"+value[3]+"')";
                
                pst = con.prepareStatement(sql);
                pst.executeUpdate();
            }
            br.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        
    }
}