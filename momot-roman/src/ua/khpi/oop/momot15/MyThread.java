package ua.khpi.oop.momot15;

import java.util.ArrayList;

public class MyThread implements Runnable{
	
	private ArrayList<Event> arr;
	Thread thread;
	private boolean isActive;
	private int count;
	
	void disable() {
		isActive = false;
	}
	
	MyThread(ArrayList<Event> arr, String name, int count){
		this.arr = arr;
		thread = new Thread(this, name);
		this.count = count;
		isActive = true;
	}
	
	@Override
	public void run() {
		long countTime = 0;
		long temp = 0;
		int i;
		
		for(i = 0; i < count; i++) {
			
			try {
				temp = countPeople();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//System.out.println(Thread.currentThread().getName() + ": " + temp);
			countTime += temp;
		}
		
		System.out.println("Time spent: " + countTime + " milliseconds\n");
		//System.out.println("Time result: " + (double)((countTime/3)/1000));
	}
	
	private long countPeople() throws InterruptedException {
		long count = 0;
		long begin = System.currentTimeMillis();
		Thread.currentThread().sleep(1000);
		
		for(Event i : arr) {
			if(isActive) {
				count += i.getDuration();
			}
			else {
				System.out.println(Thread.currentThread().getName() + " was stopped.");
				return -1;
			}
		}
		
		
		System.out.println(Thread.currentThread().getName() + ": " + count + " people");
		System.out.println(Thread.currentThread().getName() + " finished");
		
		return (System.currentTimeMillis() - begin);
	}
}
