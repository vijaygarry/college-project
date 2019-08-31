import java.io.FileReader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.util.Properties;

public class TryConfig
{
	public static void main(String[] args)
	{
		try
		{
			Properties obj = new Properties();
			
			String dbSettingsPropertyFile = "C:\\Eclipse-Workspace\\ConfigurationFile\\config.properties";
			
			FileReader fReader = new FileReader(dbSettingsPropertyFile);
			
			obj.load(fReader);
			
			String dbDriverClass = obj.getProperty("db.driver.class");
			
			String dbConnUrl = obj.getProperty("db.conn.url");
			
			String dbUserName = obj.getProperty("db.username");
			
			String dbPassword = obj.getProperty("db.password");
			
			System.out.println(dbDriverClass);
			
			System.out.println(dbConnUrl);
			
			System.out.println(dbUserName);
			
			System.out.println(dbPassword);
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}