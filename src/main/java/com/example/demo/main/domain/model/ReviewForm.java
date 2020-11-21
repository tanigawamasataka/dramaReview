package com.example.demo.main.domain.model;


import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Data
public class ReviewForm {

	private int dramaId;

	@NotBlank
	private String reviewTitle;

	@NotBlank
	private String reviewText;

	private int evaluation ;

}
