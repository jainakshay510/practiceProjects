package multithreadingexample;

public class BasicThreadProgram {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		int n = 8; // Number of threads 
        for (int i=0; i<n; i++) 
        { 
            Thread object = new Thread(new MyCustomThread("Akshhay+Thread")); 
            object.start(); 
        } 
        
        ProducerConsumer producerConsumer=new ProducerConsumer();
        ProducerConsumerUsingWaitNotify producerConsumerUsingWaitNotify=new ProducerConsumerUsingWaitNotify();
        Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					//producerConsumer.produce();
					producerConsumerUsingWaitNotify.producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
        
        Thread t2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					//producerConsumer.consume();
					producerConsumerUsingWaitNotify.consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
		
	}

}


class MyCustomThread implements Runnable{

	private String threadName;
	
	public MyCustomThread(String threaName) {
		this.threadName=threaName;
	}
	
	
	@Override
	public void run() {

		try {
			System.out.println("In thread "+threadName+Thread.currentThread().getId());
		}
		catch(Exception e) {
			System.out.println("Exception"+e.getMessage());
		}
			
	}
	
	
	
	
}
