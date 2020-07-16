import java.io.*; 
import java.util.*; 
import com.opencsv.CSVWriter; 

// TODO: Auto-generated Javadoc
/**
 * The Class CRUD.
 */
public class CRUD {
	
	/** The option. */
	static int option;
	
	/**
	 * Menu.
	 */
	public static void menu()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("What do you want to do?\n"
				+"1. Create a new data file\n"
				+ "2. Read an existing data file\n"
				+"3. Update an existing data file\n"
				+"4. Delete an existing data file\n"
				+"5. Exit");
		
		option = sc.nextInt();
		
	}
	
	/**
	 * Exit.
	 */
	public static void exit()
	{
		System.out.println("Exiting program..");
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException 
	{ 
		Scanner sc = new Scanner(System.in);
		while(true){
			menu();
			if(option == 1)
			{
				System.out.println("Enter filename to create: ");
				String filename = sc.nextLine();
				Create.createFile(filename);
			}
			if(option == 2)
			{
				System.out.println("Enter filename to read: ");
				String filename = sc.nextLine();
				Read.readFile(filename);
			}
			if(option == 3)
			{
				System.out.println("Enter filename to update: ");
				String filename = sc.nextLine();
				Update.updateFile(filename);
			}
			if(option==4)
			{
				System.out.println("Enter filename to delete a row: ");
				String filename = sc.nextLine();
				Delete.deleteRow(filename);
				
			}
			if(option == 5)
			{
				exit();
				break;
			}
		}
	} 

} 
