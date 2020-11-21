package com.example.demo.main.domain.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EditForm {

	private int dramaId;

	private String dramaImage;

	@NotBlank
	private String dramaName;

	@NotBlank
	private String dramaStory;

	@NotBlank
	private String leadActor;

	@NotNull
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date releaseDate;
}
