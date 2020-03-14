
//public class SimpleThread extends Thread {
public class SimpleThread implements Runnable {

	Resource resource;
	
	public void run() {
		for (int i = 0; i<10; i++){
			try {
			System.out.println(resource.increment());
			
			Thread.sleep(10); // increased from 1 to 10 to cause the failure more often (for testing)
			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	SimpleThread(Resource resource) {
		this.resource = resource;
	}

	public static void main(String args[]) {
		Resource resource = new Resource();
		Thread t = new SimpleThread(resource);
		Thread s = new SimpleThread(resource);
		
		t.start();
		s.start();
	}

}
