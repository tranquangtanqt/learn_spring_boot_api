package com.learn.api.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DemoDto implements Serializable{

	private static final long serialVersionUID = 8118990856777789246L;
	
	private Long id;
	private String name;

}
