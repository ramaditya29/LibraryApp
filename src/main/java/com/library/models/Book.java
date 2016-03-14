package com.library.models;
/*
 * Bean Class for the book. This can be used while we are creating a datastore using Arraylist.
*/
public class Book {
	int id;
	String bookName;
	String authors;
	String checkedOutBy;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public String getCheckedOutBy() {
		return checkedOutBy;
	}
	public void setCheckedOutBy(String checkedOutBy) {
		this.checkedOutBy = checkedOutBy;
	}
	
	
}
