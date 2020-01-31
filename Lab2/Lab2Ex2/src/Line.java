
class Line {

	Point start, end;
	private static int classID = 0;
	private int objID;

	/*
	 * Default constructor, makes a line from two points, where each point is the end of the line.
	 */
	public Line(Point a, Point b) {
		start = a;
		end = b; 
		objID = ++ classID;
	}
	
   
	public double distance(){
	    return Point.distance(start, end);
    }
    
    public String toString()
    {
    	// Intended Format:
        // Line 1: starts at (20, 30), and ends at (50, 100)
        
    	String s = "Line " + objID + ": starts at " + start.toString() + " and ends at " + end.toString();
    	return s;
    }
}
