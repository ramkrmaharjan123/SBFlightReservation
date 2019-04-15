package com.kcing.location.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kcing.location.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
