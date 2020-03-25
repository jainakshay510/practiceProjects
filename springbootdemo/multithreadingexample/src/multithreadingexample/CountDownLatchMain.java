package multithreadingexample;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchMain {
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
		 CountDownLatch countLatch=new CountDownLatch(3);
		 
		 ExecutorService executor=Executors.newFixedThreadPool(4);
		 
		 for(int i=0;i<13;i++) {
			 executor.submit(new Processor(countLatch));
		 }
		
		 countLatch.await();
		
		 
		 System.out.println("Completed");
		 executor.shutdown();
	}

}

class Processor implements Callable<Void>{

	private CountDownLatch latch;
	
	public Processor(CountDownLatch latch) {
		this.latch=latch;
	}
	
	@Override
	public Void call() throws Exception {
		System.out.println("Started");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		latch.countDown();
		return null;
	}
	
}
