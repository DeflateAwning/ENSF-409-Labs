
public interface Resizable {
	public static double LIMIT = 1.0;
	
	/**
	 * Method shrink is supposed to reduce the size of measurable elements of any shape, 
	 * such as width, length, radius, ... by  a  factor  of  n.  
	 * 
	 * For  example,  if  the rectangle’s width is W and its length is L this method should change them to W/n, and L/n. 
	 * 
	 * This method is supposed to throw a SizeFactorException if the  value  of  n  (i.e.  the divisor)  is  less  than 
	 * LIMIT(e.g.  1.0) which is a variable declared in the Resizeable interface.
	 */
	public void shrink(double n) throws SizeFactorException;
	
	/**
	 * Method enlarge is supposed to enlarge the size of the measurable elements of a shape, by the factor of n. 
	 * 
	 * For example, the Rectangle’s width W and length L should  be  changed  to  W*n,  and  L*n.  
	 * 
	 * This  method is  also  supposed  to  throw  a SizeFactorException,  if  the  value  of  n  (i.e.  the multiplier)  is  less  than LIMIT(e.g. 1.0).
	 * 
	 * @param n
	 * @throws SizeFactorException Thrown when n is less than LIMIT.
	 */
	public void enlarge(double n) throws SizeFactorException;

}
