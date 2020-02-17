package com.homespace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homespace.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);

}
