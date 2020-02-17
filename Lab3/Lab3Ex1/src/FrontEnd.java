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
		System.out.println("\t6. Print Today's Order");
		System.out.println("\t7. Quit");
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
				shop.listAllItems();
				break;
				
			case 2: // Search for tool by Tool Name
				searchItemByName();
				break;
				
			case 3: // Search for tool by Tool ID
				searchItemByID();
				break;
				
			case 4: // Check Item Quantity
				checkItemQuantity();
				break;
				
			case 5: // Decrease Item Quantity
				decreaseItem();
				break;
				
			case 6: // Print Today's Order
				printOrder();
				break;
				
			case 7: // Quit
				System.out.println("Quitting.");
				return;
				
			default:
				System.err.println("Invalid input choice. Please pick a number from the list.");
				break;
			}
		}
	}
	
	/**
	 * Prints the Generated Order.
	 */
	private void printOrder() {
		System.out.println(shop.getOrder());
	}
	
	/**
	 * Decreases the quantity of an item, simulating a sale. Gets the item name from a prompt.
	 */
	private void decreaseItem() {
		String itemName = promptItemName();
		if (shop.decreaseQuantity(itemName)) {
			System.out.println("Item Quantity decreased successfully.");
		}
		else {
			System.out.println("Item Quantity was already 0, cannot be decreased.");
		}
	}
	

	/**
	 * Checks the quantity of an item, simulating a sale. Gets the item name from a prompt.
	 */
	private void checkItemQuantity() {
		String itemName = promptItemName();
		System.out.println(shop.getQuantity(itemName));
	}
	
	/**
	 * Prompts for the name of an item.
	 */
	private String promptItemName() {
		System.out.print("Please enter the name of the item: ");
		
		return scan.nextLine();
	}
	
	/**
	 * Prompts for the ID number of an item.
	 */
	private int promptItemID() {
		System.out.print("Please enter the ID of the item: ");
		
		return scan.nextInt();
	}
	
	/**
	 * Searches for an item by ID, and prints its toString info. Prompts the user for the item's ID.
	 */
	private void searchItemByID() {
		System.out.println(shop.getItem(promptItemID()));
	}

	/**
	 * Searches for an item by name, and prints its toString info. Prompts the user for the item's name.
	 */
	private void searchItemByName() {
		System.out.println(shop.getItem(promptItemName()));
	}

	/**
	 * Main method for the entire project. The project begins here.
	 * 
	 * @param args Command Line Arguments
	 */
	public static void main(String[] args) {
		FrontEnd frontEnd = new FrontEnd();
		
		frontEnd.menu();

	}

}
