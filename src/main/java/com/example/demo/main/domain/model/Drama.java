package com.example.demo.main.domain.model;

import java.util.Date;

import lombok.Data;

@Data
public class Drama {

	private int dramaId;
	private String dramaImage;
	private String dramaName;
	private String dramaStory;
	private String leadActor;
	private Date releaseDate;
	private int reviewAvg;
}
