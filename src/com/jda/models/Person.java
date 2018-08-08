package com.jda.models;

import com.jda.interfaces.PersonInterface;

import java.util.Comparator;

public
class Person implements PersonInterface {
	public static Comparator<Person>
			CompareByZip =
			Comparator.comparing((Person person) -> person.address.getZip())
					.thenComparing(person -> person.address.getAddress());
	public static Comparator<Person>
			CompareByName =
			Comparator.comparing((Person person) -> person.fname)
					.thenComparing(person -> person.sname)
					.thenComparing(person -> person.phone);
	private String fname;
	private String sname;
	private Address address;
	private String phone;

	Person(String firstName,
	       String lastName,
	       String addressLine,
	       String city,
	       String state,
	       String zip,
	       String phoneNumber) {
		fname = firstName;
		sname = lastName;
		address = new Address(addressLine, city, state, zip);
		phone = phoneNumber;
	}

	@Override
	public
	String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(fname).append(" ").append(sname).append("\n");
		builder.append("Phone : ").append(phone).append("\n");
		builder.append(address);
		return builder.toString();
	}

	@Override
	public
	String getFirstName() {
		return fname;
	}

	@Override
	public
	String getPhone() {
		return phone;
	}

	public
	void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public
	String getLastName() {
		return sname;
	}

	@Override
	public
	String getAddress() {
		return address.getAddress();
	}

	public
	void setAddress(String address) {
		this.address.setAddress(address);
	}

	@Override
	public
	String getCity() {
		return address.getCity();
	}

	public
	void setCity(String city) {
		address.setCity(city);
	}

	@Override
	public
	String getState() {
		return address.getState();
	}

	public
	void setState(String state) {
		address.setState(state);
	}

	@Override
	public
	String getZip() {
		return address.getZip();
	}

	public
	void setZip(String zip) {
		address.setZip(zip);
	}
}
