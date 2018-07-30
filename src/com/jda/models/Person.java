package com.jda.models;

public class Person {
	String fname;
	String sname;
	Address address;
	long phone;

	Person(String firstName, String lastName, String addressline, String addressLine2, String city, String state,
	       String zip, long phoneNumber) {
		fname = firstName;
		sname = lastName;
		address = new Address(addressline, city, state, zip);
		phone = phoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

}
