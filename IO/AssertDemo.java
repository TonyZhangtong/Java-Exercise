public class AssertDemo {
	static int val = 3;
	static int getnum() {
		return val--;
	}
	public static void main(String[] args) {
		int n = 0;
		for (int i = 0; i < 10; i++) {
			n = getnum();
			assert n > 0;
			System.out.println("n is " + n);
		}

	}

}