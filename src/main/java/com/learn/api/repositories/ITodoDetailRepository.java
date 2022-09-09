package com.learn.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.api.entities.TodoDetail;

@Repository
public interface ITodoDetailRepository extends JpaRepository<TodoDetail, Long> {
	List<TodoDetail> findByOrderBySortOrderAsc();
	List<TodoDetail> findByTodoId(Long id);
}
