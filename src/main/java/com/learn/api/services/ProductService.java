package com.learn.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learn.api.dto.ProductDto;
import com.learn.api.entities.Product;
import com.learn.api.repositories.IProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private MapperService mapperService;

	@Autowired
	private IProductRepository productRepository;
	
	public List<ProductDto> getAll() {
		List<Product> products = productRepository.findAll();
		List<ProductDto> productDtos = new ArrayList<ProductDto>();
		for (Product product : products) {
			productDtos.add(mapperService.mapProductToDto(product));
		}
		return productDtos;
	}
	
	/**
	 * Get record product
	 * @param id
	 * @return
	 */
	public ProductDto getById(Long id) {
		Product product = productRepository.findById(id).get();
		if(product.getDelFlg() != null && product.getDelFlg().equals(true)) return null;
		return mapperService.mapProductToDto(product);
	}
	
	/**
	 * Get record product
	 * @param id
	 * @return
	 */
	@Transactional
	public ProductDto update(ProductDto productDto) {
		Product product = productRepository.findById(productDto.getId()).get();
		product.setName(productDto.getName());
		productRepository.save(product);
		return getById(productDto.getId());
	}
}