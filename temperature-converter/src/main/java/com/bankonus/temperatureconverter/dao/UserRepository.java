package com.bankonus.temperatureconverter.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankonus.temperatureconverter.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByUsername(String username);
}
