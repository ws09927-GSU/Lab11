package Labs_1302;

/**
 * File: Lab11Prob01.java
 * Class: CSCI 1302
 * Author: 
 * Created on: Apr 24, 2026
 * Last Modified: Apr 24, 2026
 * Description: Reads binary person data from person.dat, prints it to the
 *              console, and writes an exact copy to people-copy.dat.
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Lab11Prob01 {

	public static void main(String[] args) {

		// Open input and output binary streams
		try (DataInputStream input = new DataInputStream(
					new BufferedInputStream(new FileInputStream("src/people.dat")));
			 DataOutputStream output = new DataOutputStream(
					new BufferedOutputStream(new FileOutputStream("src/people-copy.dat")))) {

			// Read records until end-of-file is reached
			while (true) {
				try {
					// Read each field in the order written to the file
					int age          = input.readInt();
					String name      = input.readUTF();
					String address   = input.readUTF();
					int zipCode      = input.readInt();
					double salary    = input.readDouble();

					// Print record to console
					System.out.println("Age: "      + age);
					System.out.println("Name: "     + name);
					System.out.println("Address: "  + address);
					System.out.println("Zip Code: " + zipCode);
					System.out.println("Salary: "   + salary);
					System.out.println();

					// Write exact copy of each field to output file
					output.writeInt(age);
					output.writeUTF(name);
					output.writeUTF(address);
					output.writeInt(zipCode);
					output.writeDouble(salary);

				} catch (EOFException eof) {
					// End of file reached – exit the loop normally
					break;
				}
			}

			System.out.println("Copy written to src/people-copy.dat");

		} catch (IOException e) {
			System.out.println("I/O error: " + e.getMessage());
		}
	}
}
