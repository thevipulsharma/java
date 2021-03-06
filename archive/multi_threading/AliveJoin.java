package multi_threading;

import java.lang.InterruptedException;

class BNewThread implements Runnable{
	String name;
	Thread t;
	
	BNewThread(String name){
		this.name = name;
		t = new Thread(this, name);
		System.out.println("Creating thread: " + t);
		t.start();
	}
	
	public void run() {
		try {
			for(int i=5; i>0; i--) {
				System.out.println(name + ": " + i);
				Thread.sleep(500);
			}
		}catch(InterruptedException e) {
			System.out.println(name + " Interrupted!");
		}
		
		System.out.println("Exiting " + name);
	}
}


public class AliveJoin {
	public static void main(String[] args) {
		BNewThread one = new BNewThread("One");
		BNewThread two = new BNewThread("Two");
		BNewThread three = new BNewThread("Three");
		
		System.out.println("Thread One is Alive? : " + one.t.isAlive());
		System.out.println("Thread Two is Alive? : " + two.t.isAlive());
		System.out.println("Thread three is Alive? : " + three.t.isAlive());
		
		try {
			//wait for threads to finish
			one.t.join();
			two.t.join();
			three.t.join();
		}catch(InterruptedException e) {
			System.out.println("Main Thread Interrupted");
		}
		
		System.out.println("Thread One is Alive? : " + one.t.isAlive());
		System.out.println("Thread Two is Alive? : " + two.t.isAlive());
		System.out.println("Thread three is Alive? : " + three.t.isAlive());
		
		System.out.println("Exiting Main Thread!");
	}
}
