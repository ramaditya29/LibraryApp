package com.library.services;

import java.util.ArrayList;
import org.json.JSONObject;

import com.library.models.Book;
import com.library.models.User;

public class BookService {
	
	//Initialization of Books Datastore	
	ArrayList<Book> booksInventory = new ArrayList<Book>();
	
	UserService userService = new UserService();
	
	//This method will add the book and requires two parameters bookName and authors
	public String addBook(String bookName, String authors){
		Book books = new Book();
		books.setId((int)(Math.random() * 1000000 + 1)); 
		books.setBookName(bookName);
		books.setAuthors(authors);
		books.setCheckedOutBy("");
		booksInventory.add(books);
		return "Book Created";
	}


	//Returns all the books in the datastore in json format	
	public String getAllBooks(){
		JSONObject object = new JSONObject();
		if(booksInventory.size() == 0){
			object.put("books", "No Books found in the Inventory");
		}
		else{
			object.put("books", booksInventory);
		}
		return object.toString();
	}
	
	//Returns a particular book in the datastore in json format
	public String findBookByName(String bookName){
		ArrayList<Book> bookSearchResults = new ArrayList<Book>();
		JSONObject object = new JSONObject();
		for(int index = 0; index < booksInventory.size(); index++){
			if(booksInventory.get(index).getBookName().equals(bookName)){
				bookSearchResults.add(booksInventory.get(index));
			}
		}
		if(bookSearchResults.size() == 0)
			object.put("searchResults", "No Such book found with name:" + bookName);
		else	
			object.put("searchResults", bookSearchResults);
		return object.toString();
	}
	
	//When a user requests a book this method can be used.
	public String checkOutBook(int userId, int bookId){
		System.out.println(userId );
		System.out.println(userService.findUserByID(userId));
		if(!userService.findUserByID(userId)){
			if(findBookById(bookId)){
				for(int index = 0; index < booksInventory.size(); index++){
					if(booksInventory.get(index).getId() == bookId && booksInventory.get(index).getCheckedOutBy().equals("")){
						booksInventory.get(index).setCheckedOutBy(userId + "");
						return "Book was successfully checkout to userId:" + userId;
					}
				}
				return "Unable to check the book because it was already checked out";
			}
			else
				return "Book with:" + bookId + " doesn't found in the inventory";
		}
		else
			return "User Doesn't exist";
	}
	
	
	public boolean findBookById(int bookId){
		for(int index =0; index < booksInventory.size(); index++ ){
			if(booksInventory.get(index).getId() == bookId)
				return true;
		}
		return false;
	}
	
	
}
