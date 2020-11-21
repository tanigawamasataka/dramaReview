package com.example.demo.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.main.domain.model.Drama;
import com.example.demo.main.domain.model.EditForm;
import com.example.demo.main.domain.service.DramaInfoService;

@Controller
public class EditController {

	@Autowired
	private DramaInfoService dramaInfoService;

	@GetMapping("/admin/edit/{dramaId}")
	public String getEdit(@ModelAttribute EditForm form, Model model, @PathVariable("dramaId") int id) {

			Drama drama = dramaInfoService.selectOne(id);


			//Dramaクラスをフォームクラスに変換
			form.setDramaId(drama.getDramaId());
			form.setDramaImage(drama.getDramaImage());
			form.setDramaName(drama.getDramaName());
			form.setDramaStory(drama.getDramaStory());
			form.setLeadActor(drama.getLeadActor());
			form.setReleaseDate(drama.getReleaseDate());

			model.addAttribute("editForm", form);


		return "/admin/edit";
	}

	@PostMapping(value ="/admin/edit", params ="update")
	public String postEditUpdate(@ModelAttribute @Validated EditForm form, BindingResult bindingResult, Model model) {

		//update用変数
		Drama drama = new Drama();


		//フォームクラスをDramaクラスに変換
		drama.setDramaId(form.getDramaId());
		drama.setDramaImage(form.getDramaImage());
		drama.setDramaName(form.getDramaName());
		drama.setDramaStory(form.getDramaStory());
		drama.setLeadActor(form.getLeadActor());
		drama.setReleaseDate(form.getReleaseDate());

		//ドラマ情報更新処理
		boolean result = dramaInfoService.updateOne(drama);

		//ドラマ情報更新結果の判定
		if(result == true) {
            model.addAttribute("result", "更新成功");
		} else {
		    model.addAttribute("result", "更新失敗");
		}

		return "redirect:/main";

    	}

	@PostMapping(value ="/admin/edit", params ="delete")
	public String postEditdelete(@ModelAttribute @Validated EditForm form, BindingResult bindingResult, Model model) {

		//ドラマ情報削除処理
		boolean result = dramaInfoService.deleteOne(form.getDramaId());

		//ドラマ情報削除結果の判定
		if(result == true) {
            model.addAttribute("result", "削除成功");
		} else {
		    model.addAttribute("result", "削除失敗");
		}

		return "redirect:/main";

    	}
	}