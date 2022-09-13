package com.learn.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.api.constants.UrlDefine;
import com.learn.api.dto.ApiResponse;
import com.learn.api.dto.ProductDto;
import com.learn.api.services.ProductService;

import io.swagger.v3.oas.annotations.Parameter;

@RestController
public class ProductControler {

	@Autowired
	private ProductService productService;
	
	@GetMapping(UrlDefine.PRODUCT_INFO)
	public ApiResponse<List<ProductDto>> getAll() {
		List<ProductDto> productDtos = null;
		try {
			productDtos = productService.getAll();
		} catch (Exception e) {
			return new ApiResponse<List<ProductDto>>(productDtos, HttpStatus.EXPECTATION_FAILED);
		}
		return new ApiResponse<List<ProductDto>>(productDtos, HttpStatus.OK);
	}
	
	/**
	 * Get PRODUCT_BY_ID
	 * @return
	 */
	@GetMapping(UrlDefine.PRODUCT_BY_ID)
	public ApiResponse<ProductDto> getById(@Parameter(description = "PRODUCT_BY_ID") @PathVariable(name="id") final Long id) {
		ProductDto productDto = new ProductDto();
		try {
			productDto = productService.getById(id);
		} catch (Exception e) {
			return new ApiResponse<ProductDto>(productDto, HttpStatus.EXPECTATION_FAILED);
		}
		return new ApiResponse<ProductDto>(productDto, HttpStatus.OK);
	}
	
	/**
	 * Update 1 record table PRODUCT
	 * @param todoDetailDto
	 * @return
	 */
	@PutMapping(UrlDefine.PRODUCT_INFO)
	public ApiResponse<ProductDto> create(@RequestBody ProductDto productDto) {
		ProductDto rs = new ProductDto();
		try {
			rs = productService.update(productDto);
			return new ApiResponse<ProductDto>(rs, HttpStatus.OK);
		} catch (Exception e) {
			return new ApiResponse<ProductDto>(rs, HttpStatus.EXPECTATION_FAILED);
		}
	}
}
