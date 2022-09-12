package com.learn.api.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CustomerDto extends BaseDto implements Serializable{

	private static final long serialVersionUID = 4601336650843263015L;

	private String name;
	private String email;
	private String address;
	private String phoneNumber;
	private String notes;
}
