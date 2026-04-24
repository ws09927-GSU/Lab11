package Labs_1302;

/**
 * File: Lab11Prob03.java
 * Class: CSCI 1302
 * Author: 
 * Created on: Apr 24, 2026
 * Last Modified: Apr 24, 2026
 * Description: Extends Lab11Prob02 by additionally writing the sorted Person
 *              objects (serialized) to people-salary-sorted-objects.dat using
 *              ObjectOutputStream.
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class Lab11Prob03 {

	public static void main(String[] args) {

		// ArrayList to hold all Person records read from file
		ArrayList<Person> people = new ArrayList<>();

		// --- Read all records from person.dat ---
		try (DataInputStream dis = new DataInputStream(
				new BufferedInputStream(new FileInputStream("src/person.dat")))) {

			while (true) {
				try {
					// Read each field in the order stored in the binary file
					int    age     = dis.readInt();
					String name    = dis.readUTF();
					String address = dis.readUTF();
					int    zipCode = dis.readInt();
					double salary  = dis.readDouble();

					// Create a Person instance and add it to the list
					people.add(new Person(age, name, address, zipCode, salary));

				} catch (EOFException eof) {
					// End of file – stop reading
					break;
				}
			}

		} catch (IOException e) {
			System.out.println("Error reading input file: " + e.getMessage());
		}

		// Sort the ArrayList by salary descending (via Person's compareTo)
		Collections.sort(people);

		// Print sorted list to console
		System.out.println("People sorted by salary (descending):");
		System.out.println("--------------------------------------");
		for (Person p : people) {
			System.out.println(p);
			System.out.println();
		}

		// --- Write sorted Person data (as Strings) to people-salary-sorted.dat ---
		try (DataOutputStream dos = new DataOutputStream(
				new BufferedOutputStream(
						new FileOutputStream("src/people-salary-sorted.dat")))) {

			// Write each person's toString() as a UTF-8 string
			for (Person p : people) {
				dos.writeUTF(p.toString());
			}

			System.out.println("Sorted data written to src/people-salary-sorted.dat");

		} catch (IOException e) {
			System.out.println("Error writing sorted strings file: " + e.getMessage());
		}

		// --- Write serialized Person objects to people-salary-sorted-objects.dat ---
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream("src/people-salary-sorted-objects.dat")))) {

			// Serialize each Person object to the file
			for (Person p : people) {
				oos.writeObject(p);
			}

			System.out.println("Serialized objects written to src/people-salary-sorted-objects.dat");

		} catch (IOException e) {
			System.out.println("Error writing serialized objects file: " + e.getMessage());
		}
	}
}
