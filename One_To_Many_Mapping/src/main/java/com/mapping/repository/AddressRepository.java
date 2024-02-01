package com.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mapping.entity.Address;

public interface AddressRepository extends JpaRepository<Address,Integer> {

}
