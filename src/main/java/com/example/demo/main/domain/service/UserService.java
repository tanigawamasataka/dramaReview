package com.example.demo.main.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.main.domain.model.User;
import com.example.demo.main.domain.model.UserSearch;
import com.example.demo.main.domain.repository.UserDao;

@Service
public class UserService {

	@Autowired
	UserDao dao;

   	//insertメソッド
	 public boolean insert(User user) {

		//1件insert
		int rowNumber = dao.insertOne(user);

		//判定用変数
		boolean result = false;

		if(rowNumber > 0) {
			result = true;
		}

		return result;
	  }

	 //ユーザー情報全件取得用メソッド
	 public List<User>selectMany() {

		 return dao.selectMany();
	 }

	 //ユーザー検索合致分、取得用メソッド
	 public List<User> selectPlural(UserSearch search) {

		 return dao.selectPlural(search);
	 }

	//ユーザー情報1件論理削除メソッド
	public boolean deleteOne(User user) {

		 //1件update
  		int rowNumber = dao.deleteOne(user);

  		//判定用変数
  		boolean result = false;

  		if(rowNumber > 0) {
  			result = true;
  		}

  		return result;
    }
}
