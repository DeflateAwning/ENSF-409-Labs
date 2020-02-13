import java.io.*;

/**
 * This serves as the front end of the system. This is the main entry point of the entire system.
 */
public class RegistrationApp {
	
	public static void main (String [] args) {
		// Create the catalogue, and print the empty catalogue
		CourseCatalogue cat = new CourseCatalogue ();
		System.out.println(cat);
		
		// Create some students and CourseOfferings, add them
		Student st = new Student ("Sara", 1);
		Student st2 = new Student ("Sam", 2);
		Course myCourse = cat.searchCat("ENGG", 233);
		if (myCourse != null) {
			cat.createCourseOffering(myCourse, 1, 100);
			cat.createCourseOffering(myCourse, 2, 200);
		}
		System.out.println(myCourse.getCourseOfferingAt(0));
		
		// Register a student in the course, print the registration
		Registration reg = new Registration ();
		reg.completeRegistration(st, myCourse.getCourseOfferingAt(0));
		System.out.println(reg);
		
		// Create user input dependencies
		BufferedReader stdin;
		stdin = new BufferedReader(new InputStreamReader(System.in));
		int inputChoice = 0;
		
		// Get user input, handle it
		while (inputChoice != 6) {
			// Print the input options (using a multi-line string might be more effective, unsure of option in Java)
			System.out.println("Select an option: ");
			System.out.println("\t1. Search Catalogue Courses");
			System.out.println("\t2. Add Course to Student Courses");
			System.out.println("\t3. Remove Course from Student Courses");
			System.out.println("\t4. View All Courses in Catalogue");
			System.out.println("\t5. View all Courses Taken by Student");
			System.out.println("\t6. Quit");
			System.out.print("Select Option: ");
			
			// Read the input choice
			try {
				inputChoice = Integer.parseInt(stdin.readLine());
			} catch (Exception e) {
				System.err.println("Error reading user input.");
			}
			
			// Valid input
			switch (inputChoice) {
			case 1: // Search Catalogue Courses
				
				break;
				
			case 2: // Add Course to Student Courses
				
				break;
				
			case 3: // Remove Course from Student Courses
				
				break;
				
			case 4: // View all Courses in Catalogue
				cat.printCourseCatalogue();
				break;
				
			case 5: // View all Courses Taken by Student
				
				break;
				
			case 6: // Quit
				break;
				
			default:
				System.err.println("Invalid input choice. Please pick a number from the list.");
				break;
			}
			
		}
		
		System.out.println("Quitting.");
		
	}
	

}
