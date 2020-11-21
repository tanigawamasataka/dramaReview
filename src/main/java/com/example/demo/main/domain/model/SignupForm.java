package com.example.demo.main.domain.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SignupForm {

	@NotBlank
	@Email
	private String userId;

	@NotBlank
	@Length(min = 8, max = 10)
	@Pattern(regexp="^[a-zA-Z]+$")
    private String password;

	@NotBlank
	private String userName;

	@NotNull
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date birthday;

	private boolean gender;

	private boolean deleted;
}
