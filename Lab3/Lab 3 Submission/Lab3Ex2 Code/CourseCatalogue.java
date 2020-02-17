import java.util.ArrayList;

public class CourseCatalogue {
	
	private ArrayList <Course> courseList;
	
	public CourseCatalogue () {
		loadFromDataBase ();
	}
	
	private void loadFromDataBase() {
		DBManager db = new DBManager();
		setCourseList(db.readFromDataBase());
		db.addSomeStudents(this); // add some students and registrations
		
	}
	public void createCourseOffering (Course c, int secNum, int secCap) {
		if (c!= null) {
			CourseOffering theOffering = new CourseOffering (secNum, secCap);
			c.addOffering(theOffering);
		}
	}
	public Course searchCat (String courseName, int courseNum) {
		for (Course c : courseList) {
			if (courseName.equals(c.getCourseName()) &&
					courseNum == c.getCourseNum()) {
				return c;
			}	
		}
		displayCourseNotFoundError();
		return null;
	}
	//Typically, methods that are called from other methods of the class
	//are private and are not exposed for use by other classes.
	//These methods are refereed to as helper methods or utility methods
	private void displayCourseNotFoundError() {
		System.err.println("Course was not found!");
		
	}
	public ArrayList <Course> getCourseList() {
		return courseList;
	}


	public void setCourseList(ArrayList <Course> courseList) {
		this.courseList = courseList;
	}
	@Override
	public String toString () {
		String st = "All courses in the catalogue: \n";
		for (Course c : courseList) {
			st += c;  //This line invokes the toString() method of Course
			st += "\n";
		}
		return st;
	}
	
	/**
	 * Prints out the Course Catalogue. Called from main menu.
	 */
	public void printCourseCatalogue() {
		System.out.println("Full Course Catalogue:");
		System.out.println(this.toString());
		System.out.println("END COURSE CATALOGUE");
	}
	
	/**
	 * Filters courses by student being enrolled
	 */
	public String getCoursesByStudent(String studentName) {
		String out = "";
		
		
		for (Course course : courseList) {
			Student stud;
			
			for (CourseOffering off : course.getCourseOfferingList()) {
				for (Registration reg : off.getCourseRegistrationList()) {
					stud = reg.getTheStudent();
					
					if (stud != null) {
						stud = reg.getTheStudent();
						
						if (stud.getStudentName().contentEquals(studentName)) {
							// This student is a student being filtered for
							out += reg.toString();
							out += "\n";
						}
					}
				}
			}
			
			
		}
		
		return out;
	}
	
	/**
	 * Adds student to course
	 */
	public void addStudentToCourse(String studentName, String courseName, int courseNum) {
		Course course = searchCat(courseName, courseNum);
		Student stud = new Student(studentName, (int)(Math.random() * 100));
		Registration reg = new Registration();
		reg.setTheStudent(stud);
		reg.setTheOffering(course.getCourseOfferingAt(0));
		
		course.getCourseOfferingAt(0).addRegistration(reg);
	}
	
	/**
	 * Removes student from course
	 */
	public void removeStudentFromCourse(String studentName, String courseName, int courseNum) {

		Course course = searchCat(courseName, courseNum);

		Registration reg = new Registration();
		
	}

}
