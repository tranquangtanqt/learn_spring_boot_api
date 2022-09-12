package com.learn.api.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.api.dto.CustomerDto;
import com.learn.api.dto.DemoDto;
import com.learn.api.dto.ProductDto;
import com.learn.api.dto.TodoDetailDto;
import com.learn.api.dto.TodoDto;
import com.learn.api.entities.Customer;
import com.learn.api.entities.Demo;
import com.learn.api.entities.Product;
import com.learn.api.entities.Todo;
import com.learn.api.entities.TodoDetail;

@Service
public class MapperService {

	@Autowired
	private ModelMapper mapper;
	
	public DemoDto mapDemoToDto(Demo demo) {
		return mapper.map(demo, DemoDto.class);
	}
	
	public TodoDto mapTodoToDto(Todo todo) {
		return mapper.map(todo, TodoDto.class);
	}
	
	public TodoDetailDto mapTodoDetailToDto(TodoDetail todoDetail) {
		return mapper.map(todoDetail, TodoDetailDto.class);
	}
	
	public CustomerDto mapCustomerToDto(Customer customer) {
		return mapper.map(customer, CustomerDto.class);
	}
	
	public ProductDto mapProductToDto(Product product) {
		return mapper.map(product, ProductDto.class);
	}
}
