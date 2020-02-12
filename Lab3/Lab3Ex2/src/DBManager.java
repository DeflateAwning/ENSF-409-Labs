import java.util.ArrayList;

/**
 * This class is simulating a database for our program
 * @author P. Link
 *
 */
public class DBManager {
	
	ArrayList <Course> courseList;

	public DBManager () {
		courseList = new ArrayList<Course>();
	}

	public ArrayList readFromDataBase() {

		courseList.add(new Course ("ENGG", 233));
		courseList.add(new Course ("ENSF", 409));
		courseList.add(new Course ("PHYS", 259));
		return courseList;
	}

}
