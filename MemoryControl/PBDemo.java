package org.totalbeginner;

public class PBDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ProcessBuilder proc = new ProcessBuilder("notepad.exe", "testfile");
			proc.start();
		} catch (Exception e) {
			System.out.println("Error executing notepad.");
		}
	}

}
