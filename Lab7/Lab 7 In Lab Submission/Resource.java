
/**
 * Contains a counter that should be incremented on every run of a thread.
 * 
 * @author Parker
 *
 */
public class Resource {

	volatile int counter; // note that the volatile may not be mandatory, as the update
							// method is synchronized
	
	// Added synchronized keyword, indicating it may be changed in another thread,
	// and to lock it when it's in use by another thread
	synchronized public int increment() {
		return counter++;
	}
	
}
