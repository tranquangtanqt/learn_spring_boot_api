package com.learn.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.api.entities.Product;

public interface IProductRepository extends JpaRepository<Product, Long> {
	List<Product> findAll();
}
