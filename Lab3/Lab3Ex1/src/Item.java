
/**
 * Represents a single Item that exists in the shop.
 * 
 * @author P. Link
 * @version 1.0.0
 * @since Feb. 12, 2020
 */
public class Item {
	
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
	 * Decreases the quantity of this item.
	 */
	public void decreaseItemQuantity() {
		quantity--;
	}

}
