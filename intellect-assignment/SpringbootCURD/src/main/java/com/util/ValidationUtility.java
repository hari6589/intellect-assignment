package com.util;

import java.util.Date;

import com.pojo.User;

public class ValidationUtility {

	public static boolean validateUserEmail(User user) {
		if (user.getEmail() == null || user.getEmail().equals(""))
			return true;
		return false;
	}

	public static boolean validateUserBirthDate(User user) {
		if (user.getBirthDate().after(new Date()))
			return true;
		return false;
	}
}
