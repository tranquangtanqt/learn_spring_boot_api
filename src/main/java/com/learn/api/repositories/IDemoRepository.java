package com.learn.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.api.entities.Demo;

@Repository
public interface IDemoRepository extends JpaRepository<Demo, Long> {
}
