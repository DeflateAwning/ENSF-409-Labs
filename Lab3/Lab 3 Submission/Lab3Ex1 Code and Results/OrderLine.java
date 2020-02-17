
/**
 * Represents a single order line inside an order.
 * 
 * @author P. Link
 * @version 1.0.0
 * @since Feb. 12, 2020
 *
 */
public class OrderLine {

	/**
	 * Represents the item that this OrderLine is representing.
	 */
	private Item item;
	
	/**
	 * Represents the quantity of this item that should be remaining after ordering.
	 */
	private int orderQuantity;
	

	/**
	 * Creates a new OrderLine, using an item as the base starting point, and considering an order quantity.
	 * 
	 * @param item The item to create the OrderLine for
	 * @param orderQuantity The total quantity to have after ordering
	 */
	public OrderLine(Item item, int orderQuantity) {
		// Set the item
		setItem(item);
		
		// Set the order quantity
		this.orderQuantity = orderQuantity;
	}
	
	/**
	 * Sets the item this OrderLine represents.
	 * 
	 * @param item The Item this OrderLine represents
	 */
	public void setItem(Item item) {
		this.item = item;
	}
	
	/**
	 * Converts this Order Line to a string, representing itself in the order.
	 * 
	 * @return The string representation of an Order Line.
	 */
	@Override
	public String toString() {
		String out = "";
		out += "Item Description:\t\t" + item.getName() + "\n";
		out += "Amount Ordered:\t\t\t" + (orderQuantity - item.getQuantity()) + " units\n";
		out += "Supplier:\t\t\t" + item.getSupplier().getName() + "\n";
		
		return out;
	}
	
	

}
