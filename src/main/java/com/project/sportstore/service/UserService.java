package com.project.sportstore.service;

import java.util.List;

import com.project.sportstore.model.User;

public interface UserService {
	List<User> getALL();
	User findByUserName(String userName);
	Boolean create(User user);
	User create1(User user);
	void updateUserById(Long userId,String newUsername,  String newEmail, String newPhone, String newAddress);
}
