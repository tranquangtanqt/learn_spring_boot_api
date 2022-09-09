package com.learn.api.services;

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
	 * Get record todo
	 * @param id
	 * @return
	 */
	public TodoDto getById(Long id) {
		Todo todo = todoRepository.findById(id).get();
		if(todo.getDelFlg().equals(true)) return null;
		return mapperService.mapTodoToDto(todo);
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
