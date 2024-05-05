package com.project.sportstore.service;

import java.util.List;

import com.project.sportstore.model.User;
import com.project.sportstore.repository.Repository;
import com.project.sportstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIpml implements UserService {
	@Autowired
	private Repository userRepository;
	@Autowired
	private UserRepository repository;
	@Override
	public User findByUserName(String userName) {
		
		return userRepository.findByUserName(userName);
	}
	@Override
	public Boolean create(User user) {
		try {
			this.userRepository.save(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public User create1(User user) {
		// TODO Auto-generated method stub
		return this.create1(user);
	}
	@Override
	public void updateUserById(Long userId, String newUsername, String newEmail, String newPhone,
			String newAddress) {
		this.repository.updateUserById(userId, newUsername, newEmail, newPhone, newAddress);
		
	}
	@Override
	public List<User> getALL() {
		
		return this.userRepository.findAll();
	}
	
}
