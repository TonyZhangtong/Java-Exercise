import java.io.*;

public class copyFile {

	public static void main(String[] args) {
		int i;
		FileInputStream fin = null;
		FileOutputStream fout = null;
		
		if (args.length != 2) {
			System.out.println("Usage: copyFile from to ");
		    return;
		} else {
			System.out.println("Usage: copyFile from" + args[0] +" to " + args[1]);

		}
		try {
			fin = new FileInputStream(args[0]);
			fout = new FileOutputStream(args[1]);
			do {
				i = fin.read();
				if (i != -1) fout.write(i);
			} while(i != -1);
		} catch (IOException e){
			System.out.println("I/O Error: " + e);
		} finally {
			try {
				if (fin != null) fin.close();
			} catch (IOException e2) {
				System.out.println("Error Closing input file");
			}
			try {
				if (fout != null) fout.close();
			} catch (IOException e3) {
				System.out.println("Error closing output file");
			}
		}
	}

}
