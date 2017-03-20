import java.io.*;

public class showFile {

	public static void main(String[] args) {
		int i;
		FileInputStream fin;
		
		if (args.length != 1) {
			System.out.println("Usage: showFile filename");
			return;
		}
		
		try {
			fin = new FileInputStream(args[0]);
		} catch(FileNotFoundException e) {
			System.out.println("Cannot open file");
			return;
		}
		
		try {
			do {
				i = fin.read();
				if(i != -1) System.out.println((char) i);
			} while(i != -1 );
		} catch(IOException e) {
			System.out.println("Error Reading File");
		}
		
		try {
			fin.close();
		} catch(IOException e) {
			System.out.println("Error closing File");
		}
	}

}
