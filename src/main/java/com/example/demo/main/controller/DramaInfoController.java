package com.example.demo.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.main.domain.model.Drama;
import com.example.demo.main.domain.model.Review;
import com.example.demo.main.domain.model.ReviewDeleteForm;
import com.example.demo.main.domain.service.DramaInfoService;
import com.example.demo.main.domain.service.ReviewService;

@Controller
public class DramaInfoController {

	@Autowired
	DramaInfoService dramaInfoService;

	@Autowired
	ReviewService reviewService;

	@GetMapping("/dramaInfo/dramaInfo/{dramaId}")
	public String getDramaInfo(Model model, @PathVariable("dramaId") int dramaId) {

		//ドラマ情報を一件取得
		Drama drama = dramaInfoService.selectOne(dramaId);

		model.addAttribute("drama", drama);

		//レビュー一覧の取得
		List<Review> reviewList = reviewService.selectMany(dramaId);

		model.addAttribute("reviewList", reviewList);

		return "/dramaInfo/dramaInfo";
	}

	@PostMapping("/dramaInfo/dramaInfo")
	public String postDramaInfo(@ModelAttribute ReviewDeleteForm form, Model model) {

		//レビュー1件削除処理
		boolean result = reviewService.deleteOne(form.getId());

		        //レビュー削除結果の判定
			    if(result == true) {
		            model.addAttribute("result", "削除成功");
				} else {
				    model.addAttribute("result", "削除失敗");
				}

		String encodedResult = String.valueOf (form.getDramaId());

		return "redirect:/dramaInfo/dramaInfo/" + encodedResult;

	}

}
