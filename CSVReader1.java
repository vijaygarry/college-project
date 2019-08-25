//Java program to read all CSV file//

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader1 
{

    public static void main(String[] args)
  {

        String csvFile = "college.csv";  //attach CSV file name as college.csv
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
     {

            while ((line = br.readLine()) != null)  
        {

                // use comma as separator
                String[] record = line.split(cvsSplitBy);
               //Print Complete Record Side by Side
                for(int i = 0; i < record.length; ++i) 
             {

              //use array[i]
            System.out.print(record[i] + " " );
              }

                System.out.println(record [0] );

            }

        }
            catch (IOException amsk) 
         {
            amsk.printStackTrace();
        }

    }

}





















//program write by Sejal Khangare