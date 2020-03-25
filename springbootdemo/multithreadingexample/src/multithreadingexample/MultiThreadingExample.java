package multithreadingexample;

public class MultiThreadingExample {

	public static void main(String[] args) {
		  
		
		PrintOddEvenUsingThreads px=new PrintOddEvenUsingThreads();
		
		px.odd=true;
		
		Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {

				px.printOdd();
				
			}
		});
		
		Thread t2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				px.printEven();
				
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}

class PrintOddEvenUsingThreads{
	
	protected boolean odd;
	protected int count=1;
	protected int max=20;
	
	public void printOdd() {
		
		synchronized (this) {
			
			while(count<max) {
				System.out.println("checking odd loop");
				while(!odd) {
					
					try {
						System.out.println("odd waiting");
						wait();
						System.out.println("notified odd");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				System.out.println("Odd Thread "+count);
				count++;
				odd=false;
				notify();
			}
			
		}
		
		
	}
	
	
	public void printEven() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		synchronized (this) {
			
			while(count<max) {
				System.out.println("checking even loop");
				while(odd) {
					try {
						System.out.println("Even waiting: " + count);
						wait();
						System.out.println("Notified even:" + count);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("EvenThread "+count);
				count++;
				odd=true;
				notify();
			}
			
		}
		
	}
	
	
}
