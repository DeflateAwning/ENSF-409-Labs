
public class SimpleList {
	/*
	 * Provides a simple implementation of a single Linked List, for ENSF 409. Each element is an int.
	 * This SimpleList contains many of the features of the full-fledged ArrayList collection object provided in java.util.
	 * 
	 * This SimpleList is designed for the purpose of a simple class exercise for ENSF 409 and doesn't follow the law of Big-3 (causes
	 * problems if you try to copy objects of class SimpleList.
	 * 
	 * @author Parker Link
	 * @version 1.0
	 * @since January 28, 2020
	 */
	
	/*
	 * Provides a single Node element of the SimpleList.
	 * Each Node represents a single element within the SimpleList, containing both the element's value, and a pointer to the next Node/element.
	 */
	private class Node {
		/*
		 * The value of this item.
		 */
		public int item;
		
		/*
		 * Pointer to the next item.
		 */
		public Node next;
	}
	
	/*
	 * The Node of the first element in the SimpleList.
	 */
	private Node headM;
	
	/*
	 * The total size (number of elements) in the entire SimpleList.
	 */
	private int sizeM;
	
	/* 
	 * SimpleList Default Constructor: creates an empty SimpleList
	 */
	public SimpleList() {
		headM = null;
		sizeM = 0;
		
	}

	// Assume no destructor required because Java is a garbage collected language, as per https://stackoverflow.com/a/171957
	
	/*
	 * Gets the size of the list (the number of elements in the list).
	 * Note that this method was originally named "size()" in the C++ code, but was renamed to better fit encapsulation naming practices.
	 * @return The size of the list
	 */
	public int getSize() {
		return sizeM;		
	}
	
	/*
	 * Adds a node with an item to the END of the list, and increments sizeM
	 * @param item The int to add to the END of the list
	 */
	public void push_back(final int item) {
		Node new_node = new Node();
		
		// Perform check to see if the new Node was successfully created. This check may not work in Java, but is adapted from the C++ implementation.
		/*if (new_node == null) {
			System.out.println("No memory available to create a node.");
			System.exit(1);
		} */
		
		new_node.item = item;
		
		if (sizeM == 0) { // original C++ code: if (headM == 0) {
			new_node.next = headM;
			headM = new_node;
		}
		else {
			Node p = headM;
			while (p.next != null) {
				p = p.next;
			}
			p.next = new_node;
			new_node.next = null;
		}
		
		// increment size of SimpleList
		sizeM++;
		
	}
	
	/*
	 * Adds a node with an item to the BEGINNING of the list, and increments sizeM
	 * @param item The int to add to the BEGINNING of the list
	 */
	public void push_front(final int item) {
		Node new_node = new Node();
		new_node.item = item;
		new_node.next = headM;
		headM = new_node;
		sizeM++;
		
	}
	
	/*
	 * Removes the last node (int) in the list (NOT YET IMPLEMENTED).
	 * 
	 * Note that this method is not implemented in C++, so it is assumed that it does not need to be implemented here.
	 */
	public void remove() {
	}
	
	/*
	 * Gets the item at the nth position in the list as a return value.
	 * If n is less than 0 or greater than or equal to sizeM (found by getSize()), gives the error message "Illegal Access" and terminates the program.
	 * @param n The index of the item in the list to get
	 * @return The value of the nth item
	 */
	public int get(int n) {
		if (n < 0 || n >= sizeM) {
			System.out.println("\n Illegal Access. Program Terminates...");
			System.exit(1);
		}
		
		Node p = headM;
		for (int i = 0; i < n; i++) {
			// Seek to the correct item
			p = p.next;
		}
		
		return p.item;
		
	}
	
	/*
	 * Puts the value of v into the item at the nth position.
	 * Note that in the C++ definition, the variable n was 'i' in the header, but 'n' in the .cpp file.
	 * @param n The position to put the value into
	 * @param v The value to be put into the nth position
	 */
	public void set(int n, int v) {
		// Note that the following check and seek operation is the same as in get(), could be moved into its own method.
		if (n < 0 || n >= sizeM) {
			System.out.println("\n Illegal Access. Program Terminates...");
			System.exit(1);
		}
		
		Node p = headM;
		for (int i = 0; i < n; i++) {
			p = p.next;
		}
		
		p.item = v;
		
	}
	
	/*
	 * Inserts a node with a copy of theItem at the nth position, and increments sizeM if the operation is successful
	 * If n == sizeM, calls push_back
	 * If n == 0, calls push_front
	 * If n < 0 or n > sizeM, returns and does nothing.
	 * @param theItem The item value to be inserted
	 * @param n The position to insert the value at
	 */
	public void insert(final int theItem, int n) {
		// Check basic cases
		if(n < 0 || n > sizeM)
	        return;
	    else if(n == 0)
	        push_front(theItem);
	    else if(n == sizeM) 
	        push_back(theItem);
		
	    else {
	    	Node new_node = new Node();
	    	
	    	// Perform check to see if the new Node was successfully created. This check may not work in Java, but is adapted from the C++ implementation.
			/*if (new_node == null) {
				System.out.println("No memory available to create a node.");
				return;
			} */
			
			new_node.item = theItem;
			
			Node before = headM;
			Node after = headM.next;
			int i = 1;
			while (i < n) {
				before = after;
				after = after.next;
				i++;
			}
			
			new_node.next = after;
			before.next = new_node;
			sizeM++;
	    	
	    }
		
	}
	
	/*
	 * Removes the node at the position n, if the list is not empty. Does nothing if n < 0 or n > sizeM-1.
	 * @param n The position of the Node to remove
	 */
	public void remove(int n) {
		if (sizeM == 0 || n < 0 || n >= sizeM) // changed first condition (headM == 0) to consider sizeM instead
	        return;
		
		Node be_deleted, before;
		
		if (n == 0) {
			be_deleted = headM;
			headM = headM.next;
		}
		else {
			before = headM;
			be_deleted = before.next;
			
			int i = 1;
			while (i < n) {
				before = be_deleted;
				be_deleted = before.next;
				i++;
			}
			
			before.next = be_deleted.next;
		}
		
		be_deleted = null; // C++ equivalent of 'delete'
		sizeM--;
	}
	
	/*
	 * Deallocates all nodes, and sets headM and size to zero
	 */
	public void clear() {
		Node p = headM;
		
		while (p != null) { // assumed correct conversion from C++
			headM = headM.next;
			p = null; // C++ equivalent of 'delete'
			p = headM;
		}
		
		headM = null; // assumed correct conversion from C++
		sizeM = 0;
		
	}
	
	/*
	 * Provides a String representation of the SimpleList.
	 * Used within the print function required for the assignment.
	 * @return String representation of the list
	 */
	@Override
	public String toString() {
		String out = "";
		for (int i = 0; i < this.getSize(); i++) {
			out += Integer.toString(this.get(i));
			out += " ";
		}
		return out;
	}
	
	/*
	 * Prints out a String representation of the SimpleList.
	 * Uses the toString() method defined.
	 */
	public void print() {
		System.out.print(this.toString());
	}
	
	/*
	 * Tests the SimpleList behaviour with examples.
	 * @param args Command line arguments not required.
	 */
	public static void main(String[] args) {
		SimpleList list = new SimpleList();
	    
	    System.out.print("\nList just after creation -- is empty.");
	    
	    list.push_front(50);
	    System.out.print("\nAfter calling push_front. list must have: 50\n");
	    list.print(); // assume that this slightly different conversion is correct, as it uses a more OOP-based approach
	    
	    list.push_back(440);
	    
	    list.set(0,770);
	    System.out.print("\nAfter calling push_back and set function list must have: 770  440\n");
	    list.print();
	    
	    list.push_back(330);
	    list.push_back(220);
	    list.push_back(110);
	    
	    System.out.print("\nAfter three more calls to push_back, list must have: 770, 440, 330, 220, 110\n");
	    list.print();
	    
	    list.remove(0);
	    list.remove(2);
	    System.out.print("\nAfter removing two nodes. list must have: 440, 330, 110\n");
	    list.print();
	    list.insert(40, 3); //insert node with the value of 40 at the 4th position
	    list.insert(20, -1); // do nothing
	    list.insert(30, 30000); // do nothing
	    list.insert(10, 0); //insert node with the value of 10 at the 1st position
	    list.insert(33, 2); // insert node with the value 33 at the 3rd position
	    
	    System.out.print("\nTwo  more nodes inserted, must have: 10, 440, 33, 330, 110, 40\n");
	    list.print();
	    
	    list.remove(0);
	    list.remove(1);
	    list.remove(2);
	    list.remove(3);
	    list.remove(4);
	    list.remove(5);
	    System.out.print("\nAfter 6 removes, list must have: 440, 330, 40: \n");
	    list.print();
	    
	    list.clear();
	    System.out.print("\nAfter call to clear, list must be empty:\n");
	    list.print();
	    
	    list.push_back(331);
	    list.push_back(221);
	    list.push_back(111);
	    
	    System.out.print("\nAfter three calls to push_back, list must have: 331, 221, 111\n");
	    list.print();
	    
	    //return 0;

	}

}
