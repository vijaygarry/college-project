import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

 public class Readfile {

      public static void main(String[] args) {
		BufferedReader br = null;
	try {
             File file = new File("C:\\Users\\Nitesh\\Desktop\Java_practic\\test.txt");
	     br = new BufferedReader(new FileReader(file));
	     String line;
	     while ((line=br.readLine()) != null) 
              {
	        System.out.println(line);
			
	      }
	     } 
	catch(IOException e)
           {
		e.printStackTrace();
           } 
	finally {
	         try {
			br.close();
		     } 
                 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		     }
	        }
		
	}

}
