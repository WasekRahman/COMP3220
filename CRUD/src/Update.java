/*
 * 
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
import com.opencsv.CSVReader;
import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import au.com.bytecode.opencsv.CSVWriter;

// TODO: Auto-generated Javadoc
/**
 * The Class Update.
 */
public class Update {
	
	/**
	 * Adds the row.
	 *
	 * @param fname the fname
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void addRow(String fname) throws IOException {
		Scanner sc = new Scanner(System.in);
		 String fileName = fname + ".csv";
	      CSVWriter writer = new CSVWriter(new FileWriter(fileName, true));
	      CSVReader reader = new CSVReader(new FileReader(fileName));
	      String[] header = reader.readNext();
	      String[] record = new String[header.length];
	      for(int i=0;i<header.length;i++)
	      {
	    	  System.out.println("Please enter a value for " + header[i]);
	    	  record[i] = sc.nextLine();
	    	  
	      }

	      writer.writeNext(record);
	      writer.close();
	      System.out.println("Row added successfully");

	}

	 /**
 	 * Update file.
 	 *
 	 * @param filename the filename
 	 * @throws IOException Signals that an I/O exception has occurred.
 	 */
 	public static void updateFile(String filename) throws IOException {
		 System.out.println("Updating " + filename +"...");
		 Scanner sc = new Scanner(System.in);
	    	String fname = filename;
	    	int option;
			filename = "./" + filename +".csv";
			File tmpDir = new File(filename);
			boolean exists = tmpDir.exists();/*Checks if the given file exists or not*/
			if(exists == false)
			{
				System.out.println("File does not exist.");
				return;
			}
			while(true)
			{

				System.out.println("How many rows do you want to add?");
					option = sc.nextInt();
					for(int i =0;i<option;i++)
					{
						Update.addRow(fname);
					}
			}

	 }
}