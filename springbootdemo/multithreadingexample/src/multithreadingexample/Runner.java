package multithreadingexample;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
	
	private ReentrantLock lock=new ReentrantLock();
	
	private Condition cond=lock.newCondition();
	
	private int count=0;
	
	public void increment() {
		for(int i=0;i<10000;i++) 
			count++;
	}
	
	public void firstThread() throws InterruptedException {
		lock.lock();
		System.out.println("Waiting");
		cond.await();
		System.out.println("Released");
		try {
		increment();
		}
		finally {
		lock.unlock();
		}
	}
	
	public void secondThread() {
		lock.lock();
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Press the return key");
		scanner.nextLine();
		cond.signal();
		try {
		increment();
		}
		finally {
		lock.unlock();
		}
	}
	
	public void finished() {
		System.out.println("Count is : "+count);
	}

}
