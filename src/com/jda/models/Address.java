package com.jda.models;

public class Address {
	String address;
	String city;
	String state;
	String zip;

	Address(String address, String city, String state, String zip) {
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(address).append("\n");
		builder.append(city).append(", ").append(state).append(", ").append(zip).append("\n");
		return builder.toString();
	}
}
