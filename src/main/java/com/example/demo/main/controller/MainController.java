package com.example.demo.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.main.domain.model.Drama;
import com.example.demo.main.domain.model.SiteSearch;
import com.example.demo.main.domain.model.SiteSearchForm;
import com.example.demo.main.domain.service.DramaInfoService;

@Controller
public class MainController {

	@Autowired
	DramaInfoService dramaInfoService;

	@GetMapping("/main")
	public String getMain(@ModelAttribute SiteSearchForm form, Model model) {

		//ドラマ情報一覧の生成
		List<Drama> dramaList = dramaInfoService.selectMany();
		//Modelにドラマリストを登録
		model.addAttribute("dramaList", dramaList);

		return "/main/main";
	}

	//ログアウト用メソッド
	@PostMapping("/logout")
	public String postLogout() {

		return "redirect:/login/login";
    }

	//サイト検索用メソッド
	@PostMapping("/main")
	public String postMain(@ModelAttribute SiteSearchForm form, BindingResult bindingResult, Model model) {

		SiteSearch search = new SiteSearch();

		search.setSiteSearch(form.getSiteSearch());

		System.out.println(search);

		//ドラマ情報一覧の生成
		List<Drama> dramaList = dramaInfoService.selectPlural(search);

		//Modelにドラマリストを登録
		model.addAttribute("dramaList", dramaList);

		return "/main/main";

	}

}

