package com.jda.factories;

import com.jda.interfaces.AddressBookInterface;
import com.jda.models.AddressBookDb;
import com.jda.models.AddressBookJson;
import com.jda.util.Constants;

public
class AddressBookFactory {

	private static AddressBookDb addressBookDb = null;
	private static AddressBookJson addressBookJson = null;

	public static
	AddressBookInterface getAddressBook(Constants.DataStorageType type) {
		switch (type) {
			case DB:
				if (addressBookDb == null) { addressBookDb = new AddressBookDb(); }
				return addressBookDb;
			case JSON:
				if (addressBookJson == null) { addressBookJson = new AddressBookJson(); }
				return addressBookJson;
		}
		return null;
	}
}
