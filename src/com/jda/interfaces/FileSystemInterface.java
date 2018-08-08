package com.jda.interfaces;

import com.jda.models.AddressBookJson;

import java.io.File;

public
interface FileSystemInterface {
	AddressBookJson readFile(File file);

	void saveFile(AddressBookInterface addressBook, File file);

	File fetchFile(String addressBookName);
}
