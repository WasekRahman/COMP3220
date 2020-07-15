import com.opencsv.CSVReader;
import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Read {

    public static void readFile(String filename) throws IOException {
    	
    	System.out.println("Reading " + filename +"...");
    	String fname = filename;
		filename = "./" + filename +".csv";
		File tmpDir = new File(filename);
		boolean exists = tmpDir.exists();
		if(exists == false)
		{
			System.out.println("File does not exist.");
			return;
		}
		 String[] csvRow = null;
	        try {
	            CSVReader csvReader = new CSVReader(new FileReader(filename));

	            List<String[]> csvAllRows = csvReader.readAll();
	            for (Object object : csvAllRows) {
	                csvRow = (String[]) object;
	                System.out.println(csvRow[0] + " " + csvRow[1] + " " + csvRow[2]);
	            }
	            System.out.println("Do you want to view JSON format?\n1. Yes\n2. No");
	            Scanner sc = new Scanner(System.in);
	            int i = sc.nextInt();
	            if(i == 1)
	            {
	            	Server.startServer(fname);
	            }
	        } catch (Exception e) {
	            System.out.println("exception :" + e.getMessage());
	        }

	    }
 
}