package multithreadingexample;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class ProducerConsumerUsingWaitNotify {
	
	
	private Object lock=new Object();
	
	private LinkedList<Integer> list=new LinkedList<>();
	private int LIMIT=10;
	private int value=0;
	public void producer() throws InterruptedException {
		
		while(true) {
			synchronized (lock) {
				while(list.size()==LIMIT) {
					lock.wait();
				}
				
				list.add(value++);
				lock.notify();
				
			}
		}
	}
	
	public void consumer() throws InterruptedException {
		
		
		
		
		while(true) {
			synchronized (lock) {
				while(list.isEmpty()) {
					lock.wait();
				}
				System.out.println("list size : "+list.size());
				int value=list.removeFirst();
				System.out.println("consumed value : "+value+" lis size : " +list.size());
				lock.notify();
				
			}
			
			Thread.sleep(new Random().nextInt(1000));
		}
		
	}

}
