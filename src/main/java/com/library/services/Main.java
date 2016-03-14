package com.library.services;

import com.library.controllers.LibraryController;

public class Main {
	public static void main(String[] args) {
		/*UserService user = new UserService();
		
		String status = user.createUser("Aditya", "V", "Ram", 24, "M", 4088722112L, 94538);
		String status1 = user.createUser("Rajesh", "V", "", 24, "M", 4083722112L, 94538);
		System.out.println(status);
		String username = user.getAllUsers();
		System.out.println(username);*/
		new LibraryController(new UserService());
	}
}
