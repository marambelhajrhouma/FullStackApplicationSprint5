package com.maram.demo.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maram.demo.entities.User;

public interface UserRepository  extends JpaRepository<User, Long>{
	
	User findByUsername(String username);
	Optional<User> findByEmail(String email); //pour vérifier que l'email n'existe pas dans bd

}
