import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Represents a single entire order of all depleted items.
 * 
 * @author P. Link
 * @version 1.0.0
 * @since Feb. 12, 2020
 *
 */
public class Order {
	
	/**
	 * List of all order lines present in this order
	 */
	private ArrayList<OrderLine> orderLines;
	
	/**
	 * The ID of the order (presumed to be random).
	 */
	private int orderID;

	/**
	 * Creates a new blank order with no Order Lines.
	 */
	public Order() {
		// Create an empty order
		orderLines = new ArrayList<OrderLine> ();
		
		// Set a random orderID
		// Source: https://mkyong.com/java/java-generate-random-integers-in-a-range/, part 2
		orderID = (int)(Math.random() * 100000 + 10000);
	}

	/**
	 * Adds an order line to the list of order lines.
	 * 
	 * @param orderLine The OrderLine to add
	 */
	public void addOrderLine(OrderLine orderLine) {
		orderLines.add(orderLine);
	}
	
	/**
	 * Generates a String representation of the order, including all its order lines.
	 */
	@Override
	public String toString() {
		String out = "";
		String SECTION_DIVIDER = "**********************************************************************";
		
		// Add header!
		out += SECTION_DIVIDER + "\n";
		out += "ORDER ID: \t\t\t" + orderID + "\n";
		
		// Source: https://www.javatpoint.com/java-get-current-date
		out += "Date Ordered: \t\t\t" + DateTimeFormatter.ofPattern("MMM dd, yyyy").format(LocalDateTime.now()) + "\n";
		out += "\n";
		
		// Add Body (each order)
		for (int i = 0; i < orderLines.size(); i++) {
			out += orderLines.get(i);
			out += "\n";
		}
		
		out += SECTION_DIVIDER + "\n";
		
		return out;
	}

}
