import java.util.Scanner;

/**
 * Main Entry Point of the entire system
 * 
 * @author Parker
 *
 */
public class FrontEnd {

	// Create the catalogue
	private CourseCatalogue cat;
	private Scanner scan;
	

	public FrontEnd() {
		cat = new CourseCatalogue();
		
		// Add the Input Scanner
		scan = new Scanner(System.in);
	}
	

	private void printOptions() {

		// Print the input options (using a multi-line string might be more effective, unsure of option in Java)
		System.out.println("\nSelect an option: ");
		System.out.println("\t1. Search Catalogue Courses");
		System.out.println("\t2. Add Course to Student Courses");
		System.out.println("\t3. Remove Course from Student Courses");
		System.out.println("\t4. View All Courses in Catalogue");
		System.out.println("\t5. View all Courses Taken by Student");
		System.out.println("\t6. Quit");
		System.out.print("Select Option: ");
		
	}

	
	/**
	 * Main Superloop for the Project
	 */
	private void menu() {
		
		
		// Get user input, handle it
		while (true) {
			// Print out the menu
			printOptions();
			
			// Read a choice
			int inputChoice = scan.nextInt();
			scan.nextLine();
		
			// Valid input
			switch (inputChoice) {
			case 1: // Search Catalogue Courses
				searchCat();
				break;
				
			case 2: // Add Course to Student Courses
				addStudentToCourse();
				break;
				
			case 3: // Remove Course from Student Courses
				removeStudentFromCourse();
				break;
				
			case 4: // View all Courses in Catalogue
				cat.printCourseCatalogue();
				break;
				
			case 5: // View all Courses Taken by Student
				viewCoursesByStudent();
				break;
				
			case 6: // Quit
				System.out.println("Quitting.");
				return;
				
			default:
				System.err.println("Invalid input choice. Please pick a number from the list.");
				break;
			}
			
		}
		
	}
	
	private void searchCat() {
		String courseName = promptCourseName();
		int courseNum = promptCourseNum();
		
		System.out.println(cat.searchCat(courseName, courseNum));
		
	}
	

	private void removeStudentFromCourse() {
		String name = promptStudentName();
		String courseName = promptCourseName();
		int courseNum = promptCourseNum();
		
		cat.removeStudentFromCourse(name, courseName, courseNum);
	}
	
	private void addStudentToCourse() {
		String name = promptStudentName();
		String courseName = promptCourseName();
		int courseNum = promptCourseNum();
		
		cat.addStudentToCourse(name, courseName, courseNum);
	}
	
	private void viewCoursesByStudent() {
		String name = promptStudentName();
		
		System.out.println(cat.getCoursesByStudent(name));
	}

	/**
	 * Prompts for student name.
	 */
	private String promptStudentName() {
		System.out.print("Please enter the name of the student: ");
		
		return scan.nextLine().trim();
	}
	
	private String promptCourseName() {
		System.out.print("Please enter the name of the course (without the number): ");
		
		return scan.nextLine().trim();
	}
	private int promptCourseNum() {
		System.out.print("Please enter the course number: ");
		
		return scan.nextInt();
	}

	public static void main(String[] args) {
		FrontEnd frontEnd = new FrontEnd();
		
		frontEnd.menu();
		

	}

}
