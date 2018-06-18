
package appianlogstocsv;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A simple program that can take all CSV files from a given directory and combine them into one collected CSV file
 * 
 * @Date 6/18/2018
 * @author Adam Badagliacco
 */
public class LogsToCSV {
    
    public static void getCSVToPrint(String csvName) throws FileNotFoundException { //Prints out all entries of the CSV file in the explicit parameter
        
        Scanner scanner = new Scanner(new File("C:\\Users\\Your\\File\\Path\\" + csvName));
        scanner.useDelimiter(",");
        while(scanner.hasNext()){
            System.out.print(scanner.next()+",");
        }
        scanner.close();
    }

    
}
