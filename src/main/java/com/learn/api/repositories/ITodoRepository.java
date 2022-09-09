package com.learn.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.api.entities.Todo;

@Repository
public interface ITodoRepository extends JpaRepository<Todo, Long> {
}