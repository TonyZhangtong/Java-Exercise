package org.totalbeginner;

public class pgkTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Package pgks[];
		pgks = Package.getPackages();
		for (int i = 0; i < pgks.length; i++) {
			System.out.println(
					pgks[i].getName() + " " +
					pgks[i].getImplementationTitle() + " " +
					pgks[i].getImplementationVendor()+ " " +
					pgks[i].getImplementationVersion());
		}

	}

}
