package com.project.sportstore.repository;


import com.project.sportstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<User, Long> {
	User findByUserName(String userName);
}
