package org.totalbeginner;

class NewThread extends Thread {
	boolean suspendFlag;
	NewThread(String threadname, ThreadGroup tgob) {
		super(tgob, threadname);
		System.out.println("New thread: " + this);
		suspendFlag = false;
		start();
	}
	public void run() {
		try {
			for (int i = 5; i> 0; i--) {
				System.out.println(getName() + ": " + i);
				Thread.sleep(1000);
				synchronized(this) {
					while (suspendFlag) {
						wait();
					}
				}
			}
		} catch (Exception e) {
				System.out.println("Exception in " + getName());
		  }
		System.out.println(getName() + " exiting.");
		
	}
	
	synchronized void mysuspend() {
		suspendFlag = true;
	}
	
	synchronized void myresume() {
		suspendFlag = false;
		notify();
	}
}

public class ThreadGroupDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadGroup groupA = new ThreadGroup("Group A");
		ThreadGroup groupB = new ThreadGroup("Group B");
		
		NewThread ob1 = new NewThread("One", groupA);
		NewThread ob2 = new NewThread("Two", groupA);
		NewThread ob3 = new NewThread("Three", groupB);
		NewThread ob4 = new NewThread("Four", groupB);
		
		System.out.println("\nHere is output from list():");
		
		groupA.list();
		groupB.list();
		System.out.println();
		
		System.out.println("Suspending Group A");
		Thread tga[] = new Thread[groupA.activeCount()];
		groupA.enumerate(tga);
		for (int i = 0; i< tga.length; i++) {
			((NewThread)tga[i]).mysuspend();
		}
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			System.out.println("Main thread interrupted.");
		}
		
		System.out.println("Resuming group A");
		for (int i = 0;i <tga.length; i++) {
			((NewThread)tga[i]).myresume();
		}
		
		try {
			System.out.println("Waiting for threads to finsih.");
			ob1.join();
			ob2.join();
			ob3.join();
			ob4.join();
		} catch (Exception e) {
			System.out.println("Exception in Main thread");
		}
		
		System.out.println("Main thread exiting.");
	}

}
