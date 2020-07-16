import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import com.opencsv.CSVWriter;

// TODO: Auto-generated Javadoc
/**
 * The Class Create.
 */
public class Create {

	/**
	 * Creates the file.
	 *
	 * @param filePath the file path
	 */
	public static void createFile(String filePath) 
	{ 
		Scanner sc = new Scanner(System.in);
		System.out.println("Creating " + filePath +"...");
		filePath = "./" + filePath +".csv";
		File tmpDir = new File(filePath);
		boolean exists = tmpDir.exists();/*Checks if the given file exists or not*/
		if(exists == true)
		{
			System.out.println("File exists already. Do you want to overwrite it?\n1. Yes\n2. No");
			int option = sc.nextInt();
			if(option==1)
			{
				System.out.println("Overwriting..");
			}
			if(option==2)
			{
				return;
			}
			
			
		}
		
		// first create file object for file placed at location 
		// specified by filepath 
		File file = new File(filePath); 
		try { 
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 
			CSVWriter writer = new CSVWriter(outputfile); 

			// adding header to csv 
			System.out.println("How many headers do you want to create?");
			int num = sc.nextInt();
			String[] header = new String[num];
			header[0] = sc.nextLine();
			for(int i=0;i<num;i++)
			{
				String data = sc.nextLine();
				header[i] = data;
			}
			
			writer.writeNext(header);
			System.out.println("SUccessfully written!");
			// closing writer connection 
			writer.close(); 
		} 
		catch (IOException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		} 
	} 
}
