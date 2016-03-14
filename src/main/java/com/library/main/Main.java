package com.library.main;

import com.library.controller.LibraryController;
import com.library.services.BookService;
import com.library.services.UserService;



public class Main {
    public static void main(String[] args) {
    	new LibraryController(new UserService(), new BookService());
    }
}