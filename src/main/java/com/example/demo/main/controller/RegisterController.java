package com.example.demo.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.main.domain.model.Drama;
import com.example.demo.main.domain.model.DramaForm;
import com.example.demo.main.domain.service.DramaInfoService;

@Controller
public class RegisterController {

	@Autowired
	private DramaInfoService dramaInfoService;

	@GetMapping("/admin/register")
	public String getRegister(@ModelAttribute DramaForm form, Model model) {

		return "/admin/register";
	}

	@PostMapping("/admin/register")
	public String postRegister(@ModelAttribute @Validated DramaForm form, BindingResult bindingResult, Model model) {

		//入力チェックに引っかかった場合、ドラマ情報新規登録画面に戻る
		if(bindingResult.hasErrors()) {

			return getRegister(form, model);
		}

		System.out.println(form);

		//insert用変数
		Drama drama = new Drama();

		drama.setDramaImage(form.getDramaImage());
		drama.setDramaName(form.getDramaName());
		drama.setDramaStory(form.getDramaStory());
		drama.setLeadActor(form.getLeadActor());
		drama.setReleaseDate(form.getReleaseDate());

		//ドラマ情報登録処理
		boolean result = dramaInfoService.insert(drama);

		//ドラマ情報登録結果の判定
		if(result == true) {
			System.out.println("insert成功");
		} else {
			System.out.println("insert失敗");
		}

		return "redirect:/main";

	}
}