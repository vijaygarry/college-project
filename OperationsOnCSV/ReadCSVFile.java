import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.*;
  
   public class ReadCSVFile {

      public static void main(String[] args) {
	
         String filename = "C:\\Users\\Nitesh\\Desktop\\Java_practice\\csvTest2.csv" ;
	 Scanner inputStream = null;
	 try
         {
         File file = new File(filename);
         inputStream = new Scanner(file);
	 // inputStream.next();                     //TODO: ignore first line
	 while (inputStream.hasNext()) 
           {
		String data = inputStream.next();
		//String[] values = data.split(",");
		//System.out.println(values[2]);    // TODO: for particular column
		System.out.println(data);
	   }
	
            inputStream.close();
	 } 
	 catch(FileNotFoundException e)
           {
		e.printStackTrace();
	   } 
	 finally {
		inputStream.close();
	  }

	}
			
   }

