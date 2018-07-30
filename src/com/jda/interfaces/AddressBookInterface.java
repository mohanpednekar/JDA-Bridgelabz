package com.jda.interfaces;

import java.io.File;
import java.util.ArrayList;

public interface AddressBookInterface {
	int getNumberOfPersons();

	void addPerson(String firstName, String lastName, String address, String city, String state, String zip,
	               String phone);

	String getFullNameOfPerson(int index);

	ArrayList<String> getOtherPersonInformation(int index);

	void updatePerson(int index, String address, String city, String state, String zip, String phone);

	void removePerson(int index);

	void sortByName();

	void sortByZip();

	void printAll();

	File getFile();

	void setFile(File file);

	String getTitle();

	boolean getChangedSinceLastSave();

	void setChangedSinceLastSave(boolean changedSinceLastSave);
}
