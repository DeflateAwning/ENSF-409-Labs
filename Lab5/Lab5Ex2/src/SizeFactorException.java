
public class SizeFactorException extends Exception {

	
	/**
	 * This variable was added by Eclipse IDE to avoid a warning.
	 */
	private static final long serialVersionUID = 1L;

	public SizeFactorException() {
		super("Size Factor provided was not valid. Ensure the size factor is less than Resizable.LIMIT.");
	}

}
