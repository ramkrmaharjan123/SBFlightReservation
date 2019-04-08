package com.kcing.location.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kcing.location.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
