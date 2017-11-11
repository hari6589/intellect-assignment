package com.service;

import java.util.HashMap;
import java.util.Map;

import com.pojo.User;
import com.response.ResponseObject;
import com.util.ValidationUtility;

public class UserService {

	ResponseObject response = new ResponseObject();
	static HashMap<Integer, User> userMap = getMap();

	public UserService() {
		if (userMap == null) {
			userMap = new HashMap<Integer, User>();
		}
	}

	public ResponseObject addUser(User user) {
		response = new ResponseObject();
		if (ValidationUtility.validateUserEmail(user)) {
			response.setValErrors("Email address should not be empty/null");
			response.setResMsg("Failed to add new User!");
		} else if (validateUser(user)) {
			response.setValErrors("User with the Email address is already exist & active");
			response.setResMsg("Failed to add new User!");
		} else if (ValidationUtility.validateUserBirthDate(user)) {
			response.setValErrors("Invlid BirthDate. User Birth date should be less than current time");
			response.setResMsg("Failed to add new User!");
		} else {
			user.setId(getMaxId() + 1);
			userMap.put(user.getId(), user);
			response.setUserId(user.getId());
			response.setResMsg("User added Successfully");
		}
		return response;
	}

	public ResponseObject updateUser(User user) {
		response = new ResponseObject();
		User updateUser = userMap.get(user.getId());

		if (updateUser == null) {
			response.setValErrors("User not found");
			response.setResMsg("No user found with id : " + user.getId());
			return response;
		} else if (ValidationUtility.validateUserBirthDate(user)) {
			response.setValErrors("Invlid BirthDate. User Birth date should be less than current time");
			response.setResMsg("Failed to update User!");
		} else {
			updateUser.setPinCode(user.getPinCode());
			updateUser.setBirthDate(user.getBirthDate());
			userMap.put(user.getId(), updateUser);
			response.setUserId(user.getId());
			response.setResMsg("User updated Successfully");
		}
		return response;
	}

	public ResponseObject deleteUser(int id) {
		response = new ResponseObject();
		userMap.get(id).setActive(false);
		System.out.println("Deleting user : " + userMap.get(id));
		response.setResMsg("User deleted Successfully");
		return response;
	}

	public ResponseObject getUsers() {
		response = new ResponseObject();
		response.setPayload(userMap.toString());
		return response;
	}

	public static HashMap<Integer, User> getMap() {
		return userMap;
	}

	public static int getMaxId() {
		int max = 0;
		for (int id : userMap.keySet()) {
			if (max <= id)
				max = id;
		}
		return max;
	}

	public static boolean validateUser(User user) {
		System.out.println("Validating : " + user.toString());
		for (Map.Entry<Integer, User> entry : userMap.entrySet()) {
			User u = entry.getValue();
			if (u.email.equalsIgnoreCase(user.email) && u.isActive == true) {
				return true;
			}
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
		return false;
	}
}
