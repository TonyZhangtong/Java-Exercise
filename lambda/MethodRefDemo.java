package org.totalbeginner;
interface StringFunc {
	String func(String n);
}
class MyStringOps {
	static String strReverse (String str) {
		String result = "";
		for (int i = str.length()-1; i >= 0; i--) 
			result += str.charAt(i);
		return result;
	}
}
public class MethodRefDemo {
	static String stringOp(StringFunc sf, String s) {
		return sf.func(s);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inStr = "lambda add power to java";
		String outStr;
		outStr = stringOp(MyStringOps::strReverse, inStr);
		System.out.println("Original string: " + inStr);
		System.out.println("String reversed: " + outStr);

	}

}
