package org.totalbeginner;
interface StringFunc {
	String func(String n);
}

public class lambdasAsArgumentsDemo {
	static String stringOp(StringFunc sf, String s) { 
		return sf.func(s);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inStr = "lambdas add power to java";
		String outStr;
		System.out.println("Here is input string: " + inStr);
		outStr = stringOp((str) -> {
			            String result = "";
			            int i;
			            for (i = 0; i < str.length(); i++)
			            	if (str.charAt(i) != ' ')
			                   result += str.charAt(i);
			            return result;
		}, inStr);
		System.out.println("The string with spaces removed: " + outStr);
		StringFunc reverse = (str) -> { 
			String result = "";
			for (int i =str.length() - 1; i>= 0; i--) {
				result += str.charAt(i);
			}
			return result;
		};
		
		System.out.println("The string reversed: " + stringOp(reverse, inStr));
	}

}
