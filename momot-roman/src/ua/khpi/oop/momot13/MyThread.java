package ua.khpi.oop.momot13;

public class MyThread implements Runnable{
	
	private boolean isActive;
	
	void disable() {
		isActive = false;
	}
	
	Thread thread;
	private MyContainer<Event> arr;
	
	MyThread(MyContainer<Event> arr, String name){
		this.arr = arr;
		isActive = true;
		thread = new Thread(this, name);
	}
	
	@Override
	public void run() {
		long count = 0;
		
		for(Event i : arr) {
			if(isActive) {
				count += i.getDuration();
			}
			else {
				break;
			}
		}
		
		System.out.println(Thread.currentThread().getName() + ": " + count);
		System.out.println(Thread.currentThread().getName() + " finished");
	}

}
