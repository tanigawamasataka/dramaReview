package com.example.demo.main.domain.model;

import lombok.Data;

@Data
public class Review {

	private int id;
	private String reviewTitle;
	private String reviewText;
	private int evaluation;
	private String userName;
    private int dramaId;

}