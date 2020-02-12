
/**
 * The Shop is the main backend controller for the entire shop.
 * It contains access to the Inventory and SupplierList "databases".
 * 
 * @author P. Link
 * @version 1.0.0
 * @since Feb. 12, 2020
 */
public class Shop {
	
	/**
	 * The Inventory, which holds all the items.
	 */
	private Inventory inventory;
	
	/**
	 * The Supplier List, which keeps track of all shop Suppliers.
	 */
	private SupplierList supplierList;
	
	/**
	 * Sets the Inventory.
	 * 
	 * @param inventory The new inventory object to set as the shop's inventory
	 */
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	/**
	 * Sets the SupplierList.
	 * 
	 * @param inventory The new inventory object to set as the shop's inventory
	 */
	public void setSupplierList(SupplierList supplierList) {
		this.supplierList = supplierList;
	}

}