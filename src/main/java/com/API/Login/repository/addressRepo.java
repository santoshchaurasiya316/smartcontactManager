package com.API.Login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.API.Login.Entity.Address;

public interface addressRepo extends JpaRepository<Address, Integer>{

	Optional<Address> getUserByAddressId(int id);

}
