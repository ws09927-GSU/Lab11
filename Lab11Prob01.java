import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * File: Lab11Prob01.java
 * Class: CSCI 1302
 * @author Wesley Soto, Kalis Sandlin, Charles Cooper
 * Created: APR 24 2026
 * Modified: APR 24 2026
 * Description: Binary I/O input files read from class
 * GitHub link: https://github.com/ws09927-GSU/hello-world
 */



public class Lab11Prob01 {
	public static void main(String[] args) {
		
		try (DataInputStream fileinput = new DataInputStream(new FileInputStream("src/people.dat"));
				DataOutputStream fileOutput = new DataOutputStream(new FileOutputStream("people-copy.dat"))) {
			
			while (true) {
				fileOutput.writeInt(fileinput.readInt());
				fileOutput.writeUTF(fileinput.readUTF());
				fileOutput.writeUTF(fileinput.readUTF());
				fileOutput.writeInt(fileinput.readInt());
				fileOutput.writeDouble(fileinput.readDouble());
			}
			
			
			
		} catch (IOException e) {
			System.out.println("File Processed");
			//e.printStackTrace();
		}
		
	}
}
