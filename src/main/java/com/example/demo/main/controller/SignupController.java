package com.example.demo.main.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.main.domain.model.SignupForm;
import com.example.demo.main.domain.model.User;
import com.example.demo.main.domain.service.UserService;

@Controller
public class SignupController {

	@Autowired
	private UserService userService;

	//ラジオボタン要変数
	private Map<String, String>radioGender;

	private Map<String, String>initRadioGender() {

		//ラジオボタンの実装
		Map<String, String> radio = new LinkedHashMap<>();

		//性別をMapに格納
		radio.put("男性", "true");
		radio.put("女性", "false");

		return radio;
	}

	@GetMapping("/login/signup")
	public String getSignup(@ModelAttribute SignupForm form, Model model) {
		//ラジオボタンの初期化ボタンの呼び出し
		radioGender = initRadioGender();

		//ラジオボタン用のMapをModelに登録
		model.addAttribute("radioGender", radioGender);

		//新規ユーザー登録ページに遷移
		return "/login/signup";
	}

	@PostMapping("/login/signup")
	public String postSignup(@ModelAttribute @Validated SignupForm form, BindingResult bindingResult, Model model) {

		//入力チェックに引っかかった場合、ユーザー登録画面に戻る
		if(bindingResult.hasErrors()) {
			return getSignup(form, model);
		}

		//insert用変数
		User user = new User();

		user.setUserId(form.getUserId());
		user.setPassword(form.getPassword());
		user.setUserName(form.getUserName());
		user.setBirthday(form.getBirthday());
		user.setGender(form.isGender());
		user.setRole("ROLE_GENERAL");

		//ユーザー登録処理
		boolean result = userService.insert(user);

		//ユーザー登録結果の判定
		if(result == true) {
			System.out.println("insert成功");
		} else {
			System.out.println("insert失敗");
		}

		//main.htmlにリダイレクト
		return "redirect:/main";
	}

}