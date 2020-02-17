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
	 * The current order.
	 */
	private Order order;
	
	
	/**
	 * Inventory constructor, loads in an ArrayList of Items to form the inventory of the shop.
	 * 
	 * @param items The ArrayList of Items to load into the inventory
	 */
	public Inventory(ArrayList<Item> items) {
		setItems(items);
		
		// Init an empty order
		order = new Order();
		
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
	 * Manages an item by decreasing its quantity and seeing if an order must be placed.
	 * Note that this implementation is better than the implementation in the video, as it employs better coherence (not requiring a decreaseItem function here).
	 * 
	 * @param name The name of the item to manage/decrease
	 * @return The item being managed
	 */
	public Item manageItem(String name) {
		Item item = searchForItem(name);
		
		if (item != null) {
			// If the decrease is successful, place an order
			if (decreaseQuantity(name)) {
				placeOrder(item);
			}
		}
		
		return item;
	}
	
	/**
	 * Decreases an item quantity, by name.
	 * 
	 * @param name The name of the item to decrease the quantity of
	 * @return Whether the decrease was successful (i.e. whether the quantity was !=0 before).
	 */
	public boolean decreaseQuantity(String name) {
		Item item = searchForItem(name);
		
		if (item != null) {
			return item.decreaseItemQuantity();
		}
		
		return false;
	}
	
	/**
	 * Places an order by generating an order line for a file, and adding the orderline if it's not null. Ignores if null.
	 */
	public void placeOrder(Item item) {
		OrderLine orderLine = item.generateOrderLine();
		
		if (orderLine != null) {
			order.addOrderLine(orderLine);
		}
	}
	
	

	/**
	 * Gets the item quantity, by name.
	 */
	public int getQuantity(String name) {
		return searchForItem(name).getQuantity();
	}

	/**
	 * Gets an item by its ID (or name).
	 * 
	 * @param id The item's ID.
	 * @return The Item object.
	 */
	public Item searchForItem(int id) {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getID() == id) {
				return items.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Gets an item by its name (or ID).
	 * 
	 * @param name The item's name.
	 * @return The Item object.
	 */
	public Item searchForItem(String name) {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getName().equals(name)) {
				return items.get(i);
			}
			
			// Debugging for when name matches weren't working
			//System.out.println("Search Name: '" + name + "', cur name in loop: '" + items.get(i).getName() + "'");
		}
		return null;
	}
	
	/**
	 * Gets the current order.
	 * 
	 * @return The current order.
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * Getter for the inventory's items
	 * 
	 * @return items The ArrayList of Items in the inventory
	 */
	public ArrayList<Item> getItems() {
		return items;
	}	

	/**
	 * Lists all the items in this inventory.
	 * 
	 * @return String representation of all items in the inventory.
	 */
	public String listAllItems() {
		String out = "";
		
		for (int i = 0; i < items.size(); i++) {
			out += items.get(i);
			out += "\n";
		}
		
		return out;
	}

}
