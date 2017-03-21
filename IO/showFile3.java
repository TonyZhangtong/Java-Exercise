import java.io.*;
public class showFile3 {

	public static void main(String[] args) {
		int i;
		if (args.length != 1) {
			System.out.println("Usage: showFile filename");
			return;
		}
		try (FileInputStream fin = new FileInputStream(args[0])) {
			do {
				i = fin.read();
				if (i != -1) System.out.println((char) i);
			} while(i != -1);
			
		} catch  (FileNotFoundException e){
			System.out.println("File not found.");
		} catch (IOException e) {
			System.out.println("An i/o error occurred");
		}
	}

}
