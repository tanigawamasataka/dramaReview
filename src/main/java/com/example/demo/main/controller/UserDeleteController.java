package com.example.demo.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.main.domain.model.User;
import com.example.demo.main.domain.model.UserSearch;
import com.example.demo.main.domain.model.UserSearchForm;
import com.example.demo.main.domain.service.UserService;

@Controller
public class UserDeleteController {

	@Autowired
	UserService userService;

	@GetMapping("/admin/userDelete")
	public String getUserDelete(@ModelAttribute UserSearchForm form, Model model) {

		//ユーザー情報一覧の生成
		List<User> userList = userService.selectMany();
		//Modelにユーザーリストを登録
		model.addAttribute("userList", userList);

		return "/admin/userDelete";
	}

	//ユーザー検索用メソッド
	@PostMapping("/admin/userDelete2")
	public String postUserSearch(@ModelAttribute UserSearchForm form, BindingResult bindingResult, Model model) {

		//入力チェックに引っかかった場合、ユーザー削除画面に戻る
		if(bindingResult.hasErrors()) {

			return getUserDelete(form, model);
		}

		UserSearch search = new UserSearch();

	    search.setUserSearch(form.getUserSearch());

	    //ユーザー情報を検索合致分、一件取得
	    List<User> userList = userService.selectPlural(search);

	    //Modelにユーザーリストを登録
	  	model.addAttribute("userList", userList);

		return "/admin/userDelete";
	}

	@PostMapping("/admin/userDelete")
	public String postUserDelete(User user) {

		//ユーザー情報を1件論理削除
	    userService.deleteOne(user);

		return "redirect:/admin/userDelete";

	}

}