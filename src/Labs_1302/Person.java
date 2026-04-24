package Labs_1302;

/**
 * File: Person.java
 * Class: CSCI 1302
 * Author: 
 * Created on: Apr 24, 2026
 * Last Modified: Apr 24, 2026
 * Description: Represents a person with age, name, address, zip code, and
 *              salary. Implements Comparable to order by salary descending,
 *              and Serializable to support object-based binary I/O.
 */

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

public class Person implements Comparable<Person>, Serializable {

	// --- Data members ---
	private int    age;
	private String name;
	private String address;
	private int    zipCode;
	private double salary;

	public Person() {
		age     = 0;
		name    = "";
		address = "";
		zipCode = 0;
		salary  = 0.0;
	}

	public Person(int age, String name, String address, int zipCode, double salary) {
		this.age     = age;
		this.name    = name;
		this.address = address;
		this.zipCode = zipCode;
		this.salary  = salary;
	}


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	
	@Override
	public String toString() {
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
		return "Age: "      + age     + "\n" +
			   "Name: "     + name    + "\n" +
			   "Address: "  + address + "\n" +
			   "Zip Code: " + zipCode + "\n" +
			   "Salary: "   + currencyFormat.format(salary);
	}

	/**
	 * Compares persons by salary in descending order (highest salary first).
	 */
	@Override
	public int compareTo(Person other) {
		return Double.compare(other.salary, this.salary);
	}
}
