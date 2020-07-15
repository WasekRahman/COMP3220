import java.util.Scanner;

import com.opencsv.CSVReader;

import au.com.bytecode.opencsv.CSVWriter;

import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Delete {
	public static int readHeader(String fname) throws IOException
	{
		 CSVReader reader = new CSVReader(new FileReader(fname));
	      String[] header = reader.readNext();
	      return header.length;
	      
	}
	
	public static void deleteRow(String fname) throws IOException
	{
		System.out.println("Deleting row...");
	    Scanner sc = new Scanner(System.in);
		String filename = fname + ".csv";
		File tmpDir = new File(filename);
		boolean exists = tmpDir.exists();
		if(exists == false)
		{
			System.out.println("File does not exist.");
			return;
		}
		while(true)
		{
		CSVReader reader2 = new CSVReader(new FileReader(filename));
		List<String[]> allElements = reader2.readAll();
		System.out.println("Which row do you want to delete?");
		int header = readHeader(filename);
		int n = 0;
		for(String[] e: allElements)
		{
			System.out.print("Row-"+n + "  ");
			for(int i=0;i<header;i++)
			{
				System.out.print(e[i] + " ");
			}
			n++;
			System.out.print("\n");
		}
		int rowNumber = sc.nextInt();
		if(rowNumber>allElements.size())
		{
			return;
		}
		allElements.remove(rowNumber);
		FileWriter sw = new FileWriter(filename);
		CSVWriter writer = new CSVWriter(sw);
		writer.writeAll(allElements);
		writer.close();
		System.out.println("Do you want to delete another row?\n1. Yes\n2. No");
		int num = sc.nextInt();
		if(num == 2)
		{
			break;
		}
		}
	}

}
