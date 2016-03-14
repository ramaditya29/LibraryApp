package com.library.controllers;

import static spark.Spark.*;
import spark.Request;
import spark.Response;
import spark.Route;

import com.library.services.UserService;
public class LibraryController {
	
	public LibraryController(final UserService userService){
		get("/users", new Route() {
		      public Object handle(Request request, Response response) {
		        // process request
		        return userService.getAllUsers();
		      }
		 });
		post("/createUser", new Route() {
		      public Object handle(Request request, Response response) {
		        // process request
		        return userService.createUser(request.queryParams("firstname"), request.queryParams("lastname"), request.queryParams("middlename"), Integer.parseInt(request.queryParams("age")), request.queryParams("gender"), Long.parseLong(request.queryParams("phone")), Integer.parseInt(request.queryParams("zip")));
		      }
		 });
	}
}
