import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Update {
	public static void addRow(String fname) {

	}

	 public static void updateFile(String filename) throws IOException {
		 System.out.println("Updating " + filename +"...");
		 Scanner sc = new Scanner(System.in);
	    	String fname = filename;
	    	int option;
			filename = "./" + filename +".csv";
			File tmpDir = new File(filename);
			boolean exists = tmpDir.exists();
			if(exists == false)
			{
				System.out.println("File does not exist.");
				return;
			}
			while(true)
			{

				System.out.println("What do you want to do?\n"
						+"1. Add a row\n"
						+ "2. Update a row\n");
					option = sc.nextInt();
			}
			if(option ==1 )
			{
				Update.addRow(fname);
			}

	 }
}
