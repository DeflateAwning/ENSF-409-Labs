import java.util.ArrayList;

/**
 * Forms a database of all individual Items.
 * 
 * @author P. Link
 * @version 1.0.0
 * @since Feb. 12, 2020
 */
public class Inventory {
	/**
	 * The items stored in the inventory
	 */
	private ArrayList<Item> items;
	
	
	/**
	 * Inventory constructor, loads in an ArrayList of Items to form the inventory of the shop.
	 * 
	 * @param items The ArrayList of Items to load into the inventory
	 */
	public Inventory(ArrayList<Item> items) {
		setItems(items);
		
	}

	/**
	 * Setter for the inventory's items
	 * 
	 * @param items The ArrayList of Items to load into the inventory
	 */
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	/**
	 * Getter for the inventory's items
	 * 
	 * @return items The ArrayList of Items in the inventory
	 */
	public ArrayList<Item> getItems() {
		return items;
	}
}
