package com.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pojo.User;
import com.response.ResponseObject;
import com.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	UserService userService = new UserService();

	@RequestMapping(value = "/add", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseObject addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseObject updateUser(@RequestBody User user) {
		System.out.println("Updating data...");
		return userService.updateUser(user);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseObject deleteUser(@PathVariable("id") int id) {
		System.out.println("deleting...");
		return userService.deleteUser(id);

	}

	@RequestMapping(value = "/view", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseObject getUsers() {
		return userService.getUsers();
	}
}
