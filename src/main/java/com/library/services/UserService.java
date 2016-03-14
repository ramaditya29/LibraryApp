package com.library.services;

import java.util.ArrayList;




import org.json.JSONObject;

import com.library.models.Book;
import com.library.models.User;

public class UserService {
	
	ArrayList<User> users = new ArrayList<User>();
	ArrayList<Book> books = new ArrayList<Book>();
	public String createUser(String firstname, String lastname, String middlename, String age, String gender, long phone, int zip) { 
		User user = new User();
		if(!firstname.equals("") && !lastname.equals("") && !age.equals("") && !gender.equals(""))
		{
			if(findUser(firstname, lastname, Integer.parseInt(age))){
				user.setId((int )(Math.random() * 1000 + 1));
				user.setFirstname(firstname);
				user.setLastname(lastname);
				user.setMiddlename(middlename);
				user.setAge(Integer.parseInt(age));
				user.setGender(gender);
				user.setPhone(phone);
				user.setZip(zip);
				users.add(user);
				return "User Added Successfully";
			}
			else
				return "User already exist";
		}
		else
			return "Some fields are missing";
	}
	
	public String getAllUsers(){
		JSONObject object = new JSONObject();
		if(users.size() == 0){
			object.put("results", "No user records found");
		}
		else
			object.put("results", users);
		return object.toString();
	}
	
	public String updateUser(int userId, String property, String newVal){
		String message = "";
		if(findUserByID(userId)){
			for(int index =0; index < users.size(); index++ ){
				if(users.get(index).getId() == userId){
					if(property.equals("age")){
						users.get(index).setAge(Integer.parseInt(newVal));
						message = "Updated Successfully";
					}
					else if(property.equals("zip")){
						users.get(index).setZip(Integer.parseInt(newVal));
						message = "Updated Successfully";
					}
					else if(property.equals("phone")){
						users.get(index).setPhone(Long.parseLong(newVal));
						message = "Updated Successfully";
					}
					else if(property.equals("firstname")){
						users.get(index).setFirstname(newVal);
						message = "Updated Successfully";
					}
					else if(property.equals("lastname")){
						users.get(index).setLastname(newVal);
						message = "Updated Successfully";
					}
				}
					
			}
			return message;
		}
		else
			return "UserID doesn't Exist";
	}
	
	public boolean findUserByID(int userId){
		for(int index =0; index < users.size(); index++ ){
			if(users.get(index).getId() == userId)
				return true;
		}
		return false;
	}
	
	public boolean findUser(String firstName, String lastName,  int age){
		for(int index = 0; index < users.size(); index++){
			if(users.get(index).getFirstname().equals(firstName) && users.get(index).getLastname().equals(lastName) && users.get(index).getAge() == age){
				return false;
			}
		}
		return true;
	}
	
	
	
}
