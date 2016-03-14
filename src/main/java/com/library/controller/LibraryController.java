package com.library.controller;

import static spark.Spark.*;
import spark.Request;
import spark.Response;
import spark.Route;

import com.library.services.BookService;
import com.library.services.UserService;
public class LibraryController {
	
	public LibraryController(final UserService userService, final BookService bookService){
		get("/users", new Route() {
		      public Object handle(Request request, Response response) {
		        // process request
		    	response.type("application/json");
		        return userService.getAllUsers();
		      }
		 });
		post("/createUser", new Route() {
		      public Object handle(Request request, Response response) {
		        // process request
		        return userService.createUser(request.queryParams("firstname"), request.queryParams("lastname"), request.queryParams("middlename"), request.queryParams("age"), request.queryParams("gender"), Long.parseLong(request.queryParams("phone")), Integer.parseInt(request.queryParams("zip")));
		      }
		});
		post("/updateUser/:userId", new Route(){

			@Override
			public Object handle(Request request, Response response) throws Exception {
				// TODO Auto-generated method stub
				return userService.updateUser(Integer.parseInt(request.params("userId")), request.queryParams("property"), request.queryParams("newVal"));
			}
			
		});
	
		post("/addBook" , new Route(){

			@Override
			public Object handle(Request request, Response response) throws Exception {
				// TODO Auto-generated method stub
				return bookService.addBook(request.queryParams("bookname"), request.queryParams("author"));
			}
			
		});
		
		get("/getAllBooks", new Route(){

			@Override
			public Object handle(Request request, Response response) throws Exception {
				// TODO Auto-generated method stub
				response.type("application/json");
				return bookService.getAllBooks();
			}
			
		});
		
		get("/findBookByName", new Route(){

			@Override
			public Object handle(Request request, Response response) throws Exception {
				// TODO Auto-generated method stub
				response.type("application/json");
				return bookService.findBookByName(request.queryParams("book"));
			}
			
		});
		
		get("/checkOutBook", new Route(){

			@Override
			public Object handle(Request request, Response response) throws Exception {
				// TODO Auto-generated method stub
				
				return bookService.checkOutBook(Integer.parseInt(request.queryParams("userid")), Integer.parseInt(request.queryParams("bookid")));
			}
			
		});
	}
}
