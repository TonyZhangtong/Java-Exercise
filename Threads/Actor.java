package com.imooc.concurrent;


public class Actor extends Thread {
	
	public void run(){
		System.out.println(Thread.currentThread().getName()+" is a actor");
		int count = 0;
		boolean keepRunning = true;
		while(keepRunning) {
			System.out.println(Thread.currentThread().getName()+" come to stage"+(++count));
			if(count == 100) {
				keepRunning = false;
			}
			if(count % 10 == 0) {
				try{
					Thread.sleep(1000);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		System.out.println(getName()+" finishes his show!");
	}
	public static void main(String[] args){
		Thread actor = new Actor();
		actor.setName("Mr.Thread");
		
		actor.start();
		Thread actressThread = new Thread(new Actress(),"Ms.Runnable");
		actressThread.start();
	}

}
class Actress implements Runnable {
	@Override
	public void run(){
		System.out.println(Thread.currentThread().getName()+"is a actor");
		int count = 0;
		boolean keepRunning = true;
		while(keepRunning) {
			System.out.println(Thread.currentThread().getName()+"come to stage"+(++count));
			if(count == 100) {
				keepRunning = false;
			}
			if(count % 10 == 0) {
				try{
					Thread.sleep(1000);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
