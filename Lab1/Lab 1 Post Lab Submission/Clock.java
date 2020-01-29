
public class Clock {
	private int day, hour, minute, second;

	// Getter Methods
	public int getDay() {
		return day;
	}
	public int getHour() {
		return hour;
	}
	public int getMinute() {
		return minute;
	}
	public int getSecond() {
		return second;
	}
	
	// Setter Methods
	public void setDay(int day) {
		this.day = day;
	}
	public void setHour(int hour) {
		if (hour >= 0 && hour <= 23)
			this.hour = hour;
	}
	public void setMinute(int minute) {
		if (minute >= 0 && minute <= 59)
			this.minute = minute;
	}
	public void setSecond(int second) {
		if (second >= 0 && second <= 59)
			this.second = second;
	}
	
	// Constructors
	public Clock(int day, int hour, int minute, int second) {
		// Take in each of the arguments
		setDay(day);
		setHour(hour);
		setMinute(minute);
		setSecond(second);
	}
	public Clock() {
		// Default to 0 if no arguments are passed
		this(0, 0, 0, 0); // call other constructor
	}
	
	// Other Methods
	public void increment(int second) {
		// Increment by second seconds
		this.second += second;
		
		this.minute += this.second/60;
		this.second %= 60;
		
		this.hour += this.minute/60;
		this.minute %= 60;
		
		this.day += this.hour/24;
		this.hour %= 24;
	}
	public int calculateTotalSeconds() {
		// Returns the total number of seconds
		return second + minute*60 + hour*60*60 + day*60*60*24;
	}
	
	

	public static void main(String[] args) {
		/****** Test 1 **********/
		System.out.println("STARTING TEST 1");
		// Create elapsed time with the default values of zeros for day, hour, minute and second.
		Clock t1 = new Clock(); // Default constructor
		
		// sets hour to 23
		t1.setHour(23);
		// sets day to 1
		t1.setDay(1);
		// sets minute to 59
		t1.setMinute(59);
		// sets day to 16
		t1.setSecond(16);
		
		// prints: 1:23:59:16
		System.out.println(t1.getDay() + ":" + t1.getHour() +":" + t1.getMinute() + ":" + t1.getSecond());
		
		// increments time t1 by 44 seconds:
		t1.increment(44);
		
		// prints: 2:0:0:0
		System.out.println(t1.getDay() + ":" + t1.getHour() +":" +t1.getMinute() + ":" + t1.getSecond());
		// prints the total elapsed time in seconds: 172,800
		System.out.printf("The elapsed time in seconds is: %d\n", t1.calculateTotalSeconds());

		
		/********* Test 2 ************/
		System.out.println("STARTING TEST 2");
		 //Elapsed time is 3 days, 1 hour, 4 mins and 5 secs
		Clock t2 = new Clock(3, 1, 4, 5);
		
		// prints: 3:1:4:5
		System.out.println(t2.getDay() + ":" + t2.getHour() +":" + t2.getMinute() + ":" + t2.getSecond());

		// increments time t2 by 143 seconds:
		t2.increment(143);
		
		// prints: 3:1:6:28
		System.out.println(t2.getDay() + ":" + t2.getHour() +":" +t2.getMinute() + ":" + t2.getSecond());
		// prints the total elapsed time in seconds: 263188
		System.out.printf("The elapsed time in seconds is: %d", t2.calculateTotalSeconds());
		

	}

}

/* PROGRAM OUTPUT:

STARTING TEST 1
1:23:59:16
2:0:0:0
The elapsed time in seconds is: 172800
STARTING TEST 2
3:1:4:5
3:1:6:28
The elapsed time in seconds is: 263188
*/
