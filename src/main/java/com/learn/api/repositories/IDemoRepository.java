package com.learn.api.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.api.entities.Demo;

public interface IDemoRepository extends JpaRepository<Demo, Long>{
}
