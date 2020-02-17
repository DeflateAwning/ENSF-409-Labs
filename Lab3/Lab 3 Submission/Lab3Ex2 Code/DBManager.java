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

	public ArrayList<Course> readFromDataBase() {

		courseList.add(new Course ("ENGG", 233));
		courseList.add(new Course ("ENSF", 409));
		courseList.add(new Course ("PHYS", 259));
		return courseList;
	}
	
	/**
	 * Adds some students and registers one in a course
	 * 
	 * @param cat Course Catalogue
	 */
	public void addSomeStudents(CourseCatalogue cat) {
		// Create some students and CourseOfferings, add them
		Student st = new Student ("Sara", 1);
		//Student st2 = new Student ("Sam", 2);
		Course myCourse = cat.searchCat("ENGG", 233);
		if (myCourse != null) {
			cat.createCourseOffering(myCourse, 1, 100);
			cat.createCourseOffering(myCourse, 2, 200);
		}
		// System.out.println(myCourse.getCourseOfferingAt(0));
		

		// Register a student in the course, print the registration
		Registration reg = new Registration ();
		reg.completeRegistration(st, myCourse.getCourseOfferingAt(0));
		//System.out.println(reg);
		
	}

}
