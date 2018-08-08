package com.jda.models;

import com.jda.interfaces.AddressBookInterface;
import com.jda.interfaces.FileSystemInterface;

import java.io.File;

public
class FileSystemDb implements FileSystemInterface {
	@Override
	public
	AddressBookJson readFile(File file) {
		return null;
	}

	@Override
	public
	void saveFile(AddressBookInterface addressBook, File file) {

	}

	@Override
	public
	File fetchFile(String addressBookName) {
		return null;
	}
}
