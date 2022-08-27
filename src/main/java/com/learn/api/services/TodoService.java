package com.learn.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learn.api.dto.TodoDto;
import com.learn.api.entities.Todo;
import com.learn.api.repositories.ITodoRepository;

@Service
public class TodoService {
	
	@Autowired
	private ITodoRepository todoRepository;
	
	@Autowired
	private MapperService mapperService;
	
	/**
	 * Get all data from table home_links
	 * @return
	 */
	public List<TodoDto> getAll(){
		List<Todo> todos = todoRepository.findByOrderBySortOrderAsc();
		
		List<TodoDto> todoDtos = new ArrayList<TodoDto>();
		for (Todo todo : todos) {
			todoDtos.add(mapperService.mapTodoToDto(todo));
		}
		
		return todoDtos;
	}
	
	/**
	 * Create 1 record table todo
	 * 
	 * @param todoDto
	 * @return
	 */
	@Transactional
	public TodoDto create(TodoDto todoDto) {
		Todo todo = new Todo();
		todo.setName(todoDto.getName());
		todo.setSortOrder(Long.valueOf(2));
		todoRepository.save(todo);

		todoDto.setId(todo.getId());
		return todoDto;
	}
}
