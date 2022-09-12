package com.learn.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.api.entities.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
	List<Customer> findAll();
}
