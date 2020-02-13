import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Front end interface for the user to interact with.
 * 
 * @author P. Link
 * @version 1.0.0
 * @since Feb. 12, 2020
 */
public class FrontEnd {
	
	/**
	 * The shop for the entire project.
	 */
	private Shop shop;
	
	/**
	 * The input scanner for the project.
	 */
	private Scanner scan;
	
	/**
	 * Constructor for the Front End
	 */
	public FrontEnd() {
		FileManager fileM = new FileManager();
		ArrayList<Supplier> suppliers = fileM.readSuppliers();
		ArrayList<Item> items = fileM.readItems();
		shop = new Shop(new Inventory(items), new SupplierList(suppliers));
		scan = new Scanner(System.in);
	}
	
	/**
	 * Prints the menu choices for the main superloop. Prompts for input. Does not read input.
	 */
	public void printMenuChoices() {
		// Print the input options (using a multi-line string might be more effective, unsure of option in Java)
		System.out.println("Select an option: ");
		System.out.println("\t1. List All Tools");
		System.out.println("\t2. Search for tool by Tool Name");
		System.out.println("\t3. Search for tool by Tool ID");
		System.out.println("\t4. Check Item Quantity");
		System.out.println("\t5. Decrease Item Quantity");
		System.out.println("\t6. Quit");
		System.out.print("Select Option: ");
		
	}
	
	/**
	 * Provides a main superloop for the menu.
	 */
	public void menu() {
		while (true) {
			// Print the menu choices to the user, prompt for input
			printMenuChoices();
			
			// Read a choice
			int choice = scan.nextInt();
			scan.nextLine();
			

			// Consider the user's input with all different choices
			switch (choice) {
			case 1: // List All Tools
				
				break;
				
			case 2: // Search for tool by Tool Name
				
				break;
				
			case 3: // Search for tool by Tool ID
				
				break;
				
			case 4: // Check Item Quantity
				break;
				
			case 5: // Decrease Item Quantity
				
				break;
				
			case 6: // Quit
				break;
				
			default:
				System.err.println("Invalid input choice. Please pick a number from the list.");
				break;
			}
		}
	}

	/**
	 * Main method for the entire project. The project begins here.
	 * 
	 * @param args Command Line Arguments
	 */
	public static void main(String[] args) {

	}

}
