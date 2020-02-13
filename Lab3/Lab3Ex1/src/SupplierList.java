import java.util.ArrayList;

/**
 * Forms a database of all Suppliers.
 * 
 * @author P. Link
 * @version 1.0.0
 * @since Feb. 12, 2020
 */
public class SupplierList {
	/**
	 * The suppliers stored in the SupplierList
	 */
	private ArrayList<Supplier> suppliers;
	
	
	/**
	 * SupplierList constructor, loads in an ArrayList of Suppliers to form the record of item suppliers.
	 * 
	 * @param items The ArrayList of Items to load into the inventory
	 */
	public SupplierList(ArrayList<Supplier> suppliers) {
		setSuppliers(suppliers);
		
	}

	/**
	 * Setter for the supplier list's suppliers
	 * 
	 * @param items The ArrayList of Supplier to load into the SupplierList
	 */
	public void setSuppliers(ArrayList<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	/**
	 * Getter for the supplier list's suppliers
	 * 
	 * @return items The ArrayList of Suppliers in the SupplierList
	 */
	public ArrayList<Supplier> getSuppliers() {
		return suppliers;
	}
}
