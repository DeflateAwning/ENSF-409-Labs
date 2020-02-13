import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * File management tools for use in reading and writing to files.
 * 
 * @author P. Link
 * @verion 1.0.0
 * @since Feb. 12, 2020
 */
public class FileManager {
	
	private String pathToItemsFile = "items.txt";
	private String pathToSuppliersFile = "suppliers.txt";
	
	/**
	 * Holds the list of suppliers, specifically for looking up the suppliers in readItems().
	 */
	ArrayList<Supplier> suppliers;
	
	/**
	 * Creates a new File Manager.
	 */
	FileManager() {
		
	}
	
	/**
	 * Reads in all the items in an items.txt file.
	 * Components of each line in the file: 0id; 1name; 2quantity; 3price; 4supplierID.
	 * Suppliers must already be generated for this method to function (design error, but present in the reference implementation video).
	 * 
	 * @return An ArrayList of Items, read from the file
	 */
	public ArrayList<Item> readItems() {
		ArrayList<Item> items = new ArrayList<Item>();
		
		try {
			FileReader fr = new FileReader(pathToItemsFile);
			BufferedReader br = new BufferedReader(fr);
			
			String line = "";
			
			// Read a line, continue looping as long as it's not null
			while ((line = br.readLine()) != null) {
				// Split each line by the semicolon delimiter
				String[] lineParts = line.split(";");
				
				// Read repeated information
				int supplierID = Integer.parseInt(lineParts[4]);
				
				// Find the supplier from the Supplier List
				Supplier thisSupplier = findSupplier(supplierID);
				if (thisSupplier != null) {
					// Valid Supplier Found, create an item
					Item thisItem = new Item(Integer.parseInt(lineParts[0]), lineParts[1], Integer.parseInt(lineParts[2]), Float.parseFloat(lineParts[3]), thisSupplier);
					
					// Add the newly created item to the item list
					items.add(thisItem);
					
					// Log this item in the supplier's list of items
					thisSupplier.getItemList().add(thisItem);
				}
				else {
					// Invalid supplier ID found in item list
					System.err.println("Invalid Supplier ID found in items.txt, in line: " + line + ". Skipping line.");
					
				}
			}
		}
		
		catch (Exception e) {
			System.err.println("Error loading the items.txt file:");
			System.err.println(e.getMessage());
		}
		
		return items;
		
	}
	
	/**
	 * Finds a Supplier object reference from a Supplier ID.
	 * Requires that readSuppliers() has already been run, populating the private global variable 'suppliers'.
	 * 
	 * @param supplierID The ID of the supplier to lookup
	 * @return Reference to the supplier object, or null if it is not found.
	 */
	public Supplier findSupplier(int supplierID) {
		// Loop through each supplier, consider each one's ID
		for (int supIndex = 0; supIndex < suppliers.size(); supIndex++) {
			if (suppliers.get(supIndex).getID() == supplierID) {
				return suppliers.get(supIndex);
			}
		}
		
		// Return null if none were found
		return null;
	}
	
	/**
	 * Reads in all the suppliers in a suppliers.txt file
	 * 
	 * @return An ArrayList of Suppliers, read from the file
	 */
	public ArrayList<Supplier> readSuppliers() {
		return null;
		
	}

}
