
//public class SimpleThread extends Thread {
public class SimpleThread implements Runnable {

	Resource resource;
	
	public void run() {
		for (int i = 0; i<10; i++){
			try {
			System.out.println(resource.increment());
			
			Thread.sleep(1); // increasing from 1 to 10 to cause the failure more often (for testing)
			
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
		SimpleThread t_ST = new SimpleThread(resource);
		SimpleThread s_ST = new SimpleThread(resource);
		

		Thread t = new Thread(t_ST);
		Thread s = new Thread(s_ST);
		
		t.start();
		s.start();
	}

}
