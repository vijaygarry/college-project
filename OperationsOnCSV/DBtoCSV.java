import java.util.*;
import java.sql.*;
import java.io.*;

class DBtoCSV
{
    public static void main(String[] args) 
    {
        String filename ="C:\\Users\\Percy\\Desktop\\JavaPrograms\\test.csv";
        Connection con;

        try
        {
            FileWriter fw = new FileWriter(filename);
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spiderdb?user=root&password=IronMan3000&useSSL=False");
            Statement smt = con.createStatement();
            String query = "Select * from account";
            ResultSet rs = smt.executeQuery(query);
            while(rs.next())
            {
                fw.append(rs.getString(1));
                fw.append(',');
                fw.append(rs.getString(2));
                fw.append(',');
                fw.append(rs.getString(3));
                fw.append(',');
                fw.append(rs.getString(4));
                fw.append('\n');
            }
            fw.flush();
            fw.close();
            con.close();
            System.out.println("CSV file is created successfully");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }    
    }
}