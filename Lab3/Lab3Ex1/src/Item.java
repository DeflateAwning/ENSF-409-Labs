
/**
 * Represents a single Item that exists in the shop.
 * 
 * @author P. Link
 * @version 1.0.0
 * @since Feb. 12, 2020
 */
public class Item {
	/**
	 * Whether this item has been ordered yet on this order.
	 */
	private boolean alreadyOrdered = false;
	
	/**
	 * Represents the ID of the Item
	 */
	private int id;
	
	/**
	 * Represents the name/description of the Item
	 */
	private String name;

	/**
	 * Represents the current quantity of the Item
	 */
	private int quantity;

	/**
	 * Represents the price of the Item
	 */
	private float price;

	/**
	 * Represents the Supplier of the Item
	 */
	private Supplier supplier;
	
	/**
	 * How many of this item to should be remaining after an order.
	 * 
	 * Note that different values were picked for these in the reference implementation video.
	 */
	private static final int ORDER_QUANTITY = 50;

	/**
	 * Minimum quantity before ordering more.
	 * 
	 * Note that different values were picked for these in the reference implementation video.
	 */
	private static final int MINIMUM_QUANTITY = 40;
	
	/**
	 * Creates a new item, with all properties of each item.
	 * 
	 * @param id The ID of the item
	 * @param name The name/description of the item
	 * @param quantity The current quantity of the item
	 * @param price The current price of the item
	 * @param supplierID The supplier ID of the item (linked to a supplier)
	 */
	public Item(int id, String name, int quantity, float price, Supplier supplier) {
		setAllInfo(id, name, quantity, price, supplier);
	}
	
	/**
	 * Sets all the info about a specific item.
	 * 
	 * @param id The ID of the item
	 * @param name The name/description of the item
	 * @param quantity The current quantity of the item
	 * @param price The current price of the item
	 * @param supplierID The supplier ID of the item (linked to a supplier)
	 */
	public void setAllInfo(int id, String name, int quantity, float price, Supplier supplier) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.supplier = supplier;
		
	}
	
	/**
	 * Gets the item's quantity.
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * Gets the item's ID.
	 * 
	 * @return The Item's ID.
	 */
	public int getID() {
		return id;
	}
	
	/**
	 * Gets the item's name.
	 * 
	 * @return The Item's name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the item's supplier.
	 * 
	 * @return The item's supplier.
	 */
	public Supplier getSupplier() {
		return supplier;
	}
	
	/**
	 * Generates an OrderLine for this item, if it is required. Otherwise, returns null.
	 * 
	 * @return The generated OrderLine, or null if an order is not required.
	 * @since Feb 16, 2020
	 */
	public OrderLine generateOrderLine() {
		// Check if it's time to order this item (i.e. we're below MINIMUM_QUANTITY)
		if (getQuantity() < MINIMUM_QUANTITY && !alreadyOrdered) {
			// Make an OrderLine to hold this line
			OrderLine orderLine = new OrderLine(this, ORDER_QUANTITY);
			
			alreadyOrdered = true;
			
			return orderLine;
		}
		else {
			return null;
		}
	}
	
	/**
	 * Decreases the quantity of this item. Will not decrease quantity below zero.
	 * 
	 * @return Whether the decrease succeeded (i.e. whether or not there were any left before this was called).
	 */
	public boolean decreaseItemQuantity() {
		if (quantity > 0) {
			quantity--;
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Converts all main elements of the item into a String representation.
	 * 
	 * @return String representation of the Item.
	 */
	@Override
	public String toString() {
		String out = "";
		
		out += "Item ID:" + id;
		out += ", Item Name: " + name;
		out += ", Item Quantity: " + quantity;
		out += ", Item Price: " + price;
		
		return out;
	}

}
