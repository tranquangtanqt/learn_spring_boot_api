package com.learn.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.api.dto.CustomerDto;
import com.learn.api.entities.Customer;
import com.learn.api.repositories.ICustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private MapperService mapperService;
	
	@Autowired
	private ICustomerRepository customerRepository;

	public List<CustomerDto> getAll() {
		List<Customer> customers = customerRepository.findAll();
		List<CustomerDto> customerDtos = new ArrayList<CustomerDto>();
		for (Customer customer : customers) {
			customerDtos.add(mapperService.mapCustomerToDto(customer));
		}
		return customerDtos;
	}
}
