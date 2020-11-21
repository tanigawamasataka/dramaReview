package com.example.demo.main.controller;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.main.domain.model.Review;
import com.example.demo.main.domain.model.ReviewForm;
import com.example.demo.main.domain.service.ReviewService;

@Controller
public class ReviewController {

            @Autowired
            private ReviewService reviewService;

	        //ラジオボタン要変数
			private Map<String, String>radioEvaluation;

			private Map<String, String>initRadioEvaluation() {

				//ラジオボタンの実装
				Map<String, String> radio = new LinkedHashMap<>();

				//評価をMapに格納
				radio.put("★", "20");
				radio.put("★★", "40");
				radio.put("★★★", "60");
				radio.put("★★★★", "80");
				radio.put("★★★★★", "100");

				return radio;
			}

    @RequestMapping(value = "/dramaInfo/review/{dramaId}", method = { RequestMethod.GET })
	public String getReview(@ModelAttribute ReviewForm form, Model model, @PathVariable("dramaId") int dramaId) {

		        //ラジオボタンの初期化ボタンの呼び出し
				radioEvaluation = initRadioEvaluation();

				//ラジオボタン用のMapをModelに登録
				model.addAttribute("radioEvaluation", radioEvaluation);
				model.addAttribute("dramaId", dramaId);

				//新規レビュー登録ページに遷移
				return "/dramaInfo/review";
			}

	@RequestMapping(value = "/dramaInfo/review", method = { RequestMethod.POST })
	public String postReview(@ModelAttribute @Validated ReviewForm form, BindingResult bindingResult, Model model, Principal principal) {

		//入力チェックに引っかかった場合、レビュー投稿画面に戻る
		if(bindingResult.hasErrors()) {

			return getReview(form, model, form.getDramaId());
		}

		Review review = new Review();

		review.setReviewTitle(form.getReviewTitle());
		review.setReviewText(form.getReviewText());
		review.setEvaluation(form.getEvaluation());
		review.setUserName(principal.getName());
		review.setDramaId(form.getDramaId());

		//レビュー投稿処理
		boolean result = reviewService.insert(review);

        //レビュー投稿結果の判定
		if(result == true) {
			System.out.println("insert成功");
		} else {
			System.out.println("insert失敗");
		}

		System.out.println(review);

		String	encodedResult = String.valueOf(form.getDramaId());
			return "redirect:/dramaInfo/dramaInfo/" + encodedResult;
	}
}
