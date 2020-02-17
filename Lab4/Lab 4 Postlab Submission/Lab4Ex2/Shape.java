
abstract class Shape implements Comparable<Shape> {
	protected Point origin;
	protected Text name;
	abstract protected Double area();
	abstract protected Double perimeter();
	abstract protected Double volume();
	
	protected Shape(Double x_origin, Double y_origin, String name, Colour colour){
		
		origin = new Point(x_origin,y_origin, colour);
		this.name = new Text(name);
	}


	protected Point  getOrigin()   {
		return origin;
	}
	
	protected String  getName()   {
		return name.getText();
	}
	 
	
	protected  Double distance(   Shape  other){
		return origin.distance(other.origin);
	}
	
	protected Double  distance(Shape a, Shape  b){
		return Point.distance(a.origin, b.origin);
	}
	
	
	protected void  move(Double dx, Double dy){
		origin.setx(origin.getx()+dx);
		origin.sety(origin.gety()+dy);
	}
	
	@Override
	public String toString(){
		String s = "\nShape name: " + name + "\nOrigin: " + origin;
		return s;
	}
	
	public int compareTo(Shape shape) {
		if (this.getName().compareTo(shape.getName()) != 0) {
			return this.getName().compareTo(shape.getName());
		}
		else if (this.getOrigin().compareTo(shape.getOrigin()) != 0) {
			// Note that this part is untested as the test cases in this assignment do not have examples with identical names.
			// Futher levels of depth are not required, but were implemented for this assignment.
			return this.getOrigin().compareTo(shape.getOrigin());
		}
		else {
			// Could continue to compare size of circle, rectangle, etc., but this was not done as it is not required for the test cases/assignment spec.
			return 0;
		}
			
	}
	

}

