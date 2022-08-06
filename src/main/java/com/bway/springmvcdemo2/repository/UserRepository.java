package com.bway.springmvcdemo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.springmvcdemo2.model.User;

public interface UserRepository extends JpaRepository<User,Integer>{

	
	User findByUsernameAndPassword(String un,String psw);
	
}
