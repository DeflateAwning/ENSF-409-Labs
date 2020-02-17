import java.util.ArrayList;

public class CourseOffering {
	
	private int secNum;
	
	/**
	 * Assume the secCap is the maximum number of students in the registration.
	 */
	private int secCap;
	private Course theCourse;
	//private ArrayList<Student> studentList;
	private ArrayList <Registration> offeringRegList;
	
	public CourseOffering (int secNum, int secCap) {
		this.setSecNum(secNum);
		this.setSecCap(secCap);
		offeringRegList = new ArrayList <Registration>();
	}
	public int getSecNum() {
		return secNum;
	}
	public void setSecNum(int secNum) {
		this.secNum = secNum;
	}
	public int getSecCap() {
		return secCap;
	}
	public void setSecCap(int secCap) {
		this.secCap = secCap;
	}
	public Course getTheCourse() {
		return theCourse;
	}
	public void setTheCourse(Course theCourse) {
		this.theCourse = theCourse;
	}
	@Override
	public String toString () {
		String st = "\n";
		st += getTheCourse().getCourseName() + " " + getTheCourse().getCourseNum() + "\n";
		st += "Section Num: " + getSecNum() + ", section cap: "+ getSecCap() +"\n";
		//We also want to print the names of all students in the section
		return st;
	}
	
	/**
	 * Adds a registration (linking of Student and CourseOffering) to the list of students enrolled in this CourseOffering.
	 * 
	 * @param registration
	 */
	public void addRegistration(Registration registration) {
		offeringRegList.add(registration);
		
	}
	
	public Registration getCourseRegistrationAt(int i) {
		if (i < 0 || i >= offeringRegList.size() )
			return null;
		else
			return offeringRegList.get(i);
	}
	
	public ArrayList<Registration> getCourseRegistrationList() {
		return offeringRegList;
	}
	
	

}
