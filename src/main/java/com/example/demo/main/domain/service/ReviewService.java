package com.example.demo.main.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.main.domain.model.Review;
import com.example.demo.main.domain.repository.ReviewDao;

@Service
public class ReviewService {

	@Autowired
	ReviewDao dao;

	  //insertメソッド
	  public boolean insert(Review review) {

		//1件insert
		int rowNumber = dao.insertOne(review);

		//判定用変数
		boolean result = false;

		if(rowNumber > 0) {
			result = true;
		}

		return result;
	  }

	//全件取得用メソッド
    public List<Review> selectMany(int dramaId) {

    	return dao.selectMany(dramaId);
    }

    //1件削除メソッド
    public boolean deleteOne(int reviewId) {

    	//1件削除
    	int rowNumber = dao.deleteOne(reviewId);

    	//判定用変数
        boolean result = false;

        if(rowNumber > 0) {
        	//delete成功
        	result = true;
        }
        return result;
    }
}

