package com.learn.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learn.api.dto.TodoDetailDto;
import com.learn.api.dto.TodoDto;
import com.learn.api.entities.TodoDetail;
import com.learn.api.repositories.ITodoDetailRepository;
import com.learn.api.repositories.ITodoRepository;

@Service
public class TodoDetailService {

	@Autowired
	private ITodoDetailRepository todoDetailRepository;
	
	@Autowired
	private TodoService todoService;

	@Autowired
	private MapperService mapperService;

	public List<TodoDetailDto> getAll() {
		List<TodoDetail> todoDetails = todoDetailRepository.findByOrderBySortOrderAsc();
		List<TodoDetailDto> todoDetailDtos = new ArrayList<TodoDetailDto>();
		for (TodoDetail detail : todoDetails) {
			todoDetailDtos.add(mapperService.mapTodoDetailToDto(detail));
		}
		return todoDetailDtos;
	}

	/**
	 * Create 1 record table todo_detail
	 * 
	 * @param todoDetailDto
	 * @return
	 */
	@Transactional
	public TodoDto create(TodoDetailDto todoDetailDto) {
		
		TodoDetail todoDetail = new TodoDetail();
		todoDetail.setName(todoDetailDto.getName());
		List<TodoDetail> list = todoDetailRepository.findByTodoId(todoDetailDto.getTodo().getId());
		Long orderNumber = Long.valueOf(list.size() + 1);
		todoDetail.setSortOrder(orderNumber);
		
		todoDetail.setTodo(todoDetailDto.getTodo());
		todoDetailRepository.save(todoDetail);
		
		TodoDto todoDto = todoService.getById(todoDetailDto.getTodo().getId());
		return todoDto;
	}

	/**
	 * Update 1 record table todo_detail
	 * 
	 * @param id
	 * @param todoDetailDto
	 */
	@Transactional
	public void update(long id, TodoDetailDto todoDetailDto) {
		TodoDetail todoDetail = todoDetailRepository.findById(id).get();
		todoDetail.setName(todoDetailDto.getName());
//		todoDetail.setSortOrder(todoDetailDto.getSortOrder());
		todoDetailRepository.save(todoDetail);
	}
	
	/**
	 * delete 1 record table todo_detail
	 * 
	 * @param id
	 * @param todoDetailDto
	 */
	@Transactional
	public TodoDto delete(Long id) {
		TodoDetail todoDetail = todoDetailRepository.findById(id).get();
		todoDetail.setDelFlg(true);
		todoDetailRepository.save(todoDetail);
		
		TodoDto todoDto = todoService.getById(todoDetail.getTodo().getId());
		return todoDto;
	}
}
