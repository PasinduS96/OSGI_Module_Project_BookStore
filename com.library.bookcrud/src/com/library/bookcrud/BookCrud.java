package com.library.bookcrud;

import java.io.IOException;

public interface BookCrud {
	public void addBooks();
	public void deleteBooks();
	public void readBook();
	public void searchBook() throws IOException ;
	public void updateBook() throws IOException;
}
