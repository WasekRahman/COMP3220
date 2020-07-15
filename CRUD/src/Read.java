import com.opencsv.CSVReader;
import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Read {

    public static void readFile(String filename) throws IOException {
    	
    	System.out.println("Reading " + filename +"...");
		filename = "./" + filename +".csv";
		File tmpDir = new File(filename);
		boolean exists = tmpDir.exists();
		if(exists == false)
		{
			System.out.println("File does not exist.");
			return;
		}
		 String[] csvRow = null;
		 ArrayList< HashMap < String,String> > data =  new ArrayList<>();
	        try {
	            CSVReader csvReader = new CSVReader(new FileReader(filename));

	            List<String[]> csvAllRows = csvReader.readAll();
	            for (Object object : csvAllRows) {
	                csvRow = (String[]) object;
	                //data.add(csvRow[0] + " " + csvRow[1] + " " + csvRow[2]);
	                System.out.println(csvRow[0] + " " + csvRow[1] + " " + csvRow[2]);
	            }
	        } catch (Exception e) {
	            System.out.println("exception :" + e.getMessage());
	        }

	    }
 
}