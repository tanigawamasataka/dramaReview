package com.example.demo.main.domain.model;

import java.util.Date;

import lombok.Data;

@Data
public class User {

	private int id;
	private String userId;
	private String password;
	private String userName;
	private Date birthday;
	private boolean gender;
	private String role;
	private boolean deleted;
}



