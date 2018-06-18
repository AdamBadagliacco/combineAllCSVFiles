package appianlogstocsv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

/**
 * A simple program that can take all CSV files from a given directory and combine them into one collected CSV file
 * 
 * @Date 6/18/2018
 * @author ADAB
 */
public class GetAllCSV {
    
    static List<String> filenames = new LinkedList<String>();//List to contain the names of all CSV files
    
    public static void main(String args[]) throws FileNotFoundException{ 
        
        final File folder = new File("C:\\Users\\Your\\File\\Path\\"); //File path to collect all CSV files from
        listFilesForFolder(folder); //Puts all the file names containing CSV into the filenames array
        
        PrintStream out = new PrintStream(new FileOutputStream("output.csv"));
            System.setOut(out); //Sets teh printout to a file as opposed to the console
        
        for(int i = 0; i < filenames.size(); i++){
            System.out.println(filenames.get(i) + " :"); //Has the hame print out before the logs in a CSV, (Can be commented out if names should be excluded)
            LogsToCSV.getCSVToPrint(filenames.get(i));
        }
    }
    
    public static void listFilesForFolder(final File folder) {//Puts all CSV file names into our list filenames
    for (final File fileEntry : folder.listFiles()) {
        if (fileEntry.isDirectory()) {
            listFilesForFolder(fileEntry);
        } else {
            if(fileEntry.getName().contains(".csv"))
                filenames.add(fileEntry.getName());
        }
    }
}
}
