// Polygon.java

import java.util.*;

class Polygon {
	private final LinkedHashSet <Line> polygon;
	private int objID;
	private static int classID;
	Iterator <Line> it;

	public Polygon(LinkedHashSet<Line> polygon) {
		 this.polygon = new LinkedHashSet<Line>();
		 for(Line l: polygon)
			 this.polygon.add (l);
		 objID = ++ classID;
		 it = this.polygon.iterator();
	}
	
	public Iterator <Line> getLine() {
		it = polygon.iterator();
		return it;
	}
	
	public static int classID(){
		return classID;
	}
	
    
	public String toString() {
        // Intended Format:
        // The lines in polygon 1 are:
        //   Line 1: starts at (20, 30), and ends at (50, 100)
        //	 Line x: etc.

		Iterator<Line> it = getLine();
    	
	    String s = "The lines in polygon " + objID + " are:";
	    
		while(it.hasNext()) {
			s += "\n\t" + it.next().toString();
			
		}
	
		return s;	
    }
}


