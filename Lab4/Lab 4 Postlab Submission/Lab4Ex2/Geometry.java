
import java.util.Iterator;
import java.util.TreeSet;


/**
 * Main Class for the project, that creates all the shapes and everything else.
 * 
 * @author P. Link
 * @version 1.0.1
 * @since Feb. 14, 2020
 */
public class Geometry{
	private TreeSet <Shape> shapes;
	
	/**
	 * Creates a new Geometry, with no elements.
	 */
	Geometry() {
		shapes = new TreeSet<Shape>();
	}
	

	/**
	 * Shows information about all shapes stored in 'shapes' TreeSet. Prints out the result.
	 */
	private void showAll() {
        Iterator <Shape> it = shapes.iterator();
		
        while (it.hasNext()) {
        	System.out.println(it.next());
        }
		
	}

	/**
	 * Adds a shape to the list of shapes in the Geometry.
	 * 
	 * @param shape The shape to be added to the list of shapes.
	 */
	private void add(Shape shape) {
		// TODO Make this method work
		shapes.add(shape);
	}
	
	/**
	 * Calculates and displays the area, perimeter, and volume of the shape on the screen.
	 * 
	 * This method, in the way it is designed, would work nicely as a static method (however, this is not allowed in this course).
	 * 
	 * @param next The shape to calculate/display info for.
	 */
	private void calculator(Shape next) {
		System.out.printf("The area, perimeter, and volume of %s are: %.2f, %.2f, %.2f.\n", next.getName(), next.area(), next.perimeter(), next.volume());
	}
	
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(3.0, 4.0, 5.0, 6.0, "R1", new Colour("Black"));
        Circle c1 = new Circle (13.0, 14.0, 15.0, "C1",new Colour ("Green"));
        System.out.println(r1);
        System.out.println(c1);
        
		Rectangle r2 = new Rectangle(23.0, 24.0, 25.0, 26.0, "R2", new Colour("Black"));
        Circle c2 = new Circle (33.0, 34.0, 35.0, "C2", new Colour("Yellow"));
        System.out.println(r2);
        System.out.println(c2);
        
		Prism p1 = new Prism(43.0, 44.0, 45.0, 46.0, 47.0, "P1", new Colour("White"));
        Prism p2 = new Prism (53.0, 54.0, 55.0, 56.0, 57.0, "P2", new Colour("Gray"));
        System.out.println(p1);
        System.out.println(p2);
        
        
        //      SECTION 2: THE FOLLOWING CODE SEGMENT MUST BE UNCOMMENTED ONLY
        //      FOR EXERCISE 2
        
         Geometry demo = new Geometry();
         System.out.println("\nAdding Rectangle, Circle, and Prism objects to the list... ");
         demo.add(c1);
         demo.add(c2);
         demo.add(p1);
         demo.add(p2);
         demo.add(r1);
         demo.add(r2);
         
         System.out.println("\nShowing information about objects added to the list:");
         demo.showAll();
         
         System.out.println("\nShowing area, perimeter, and volume of objects in the list:");
         
         Iterator <Shape> it = demo.shapes.iterator();
         while(it.hasNext()){
        	demo.calculator(it.next());
         }
         
         

	}


}
