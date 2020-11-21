package com.example.demo.main.domain.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.main.domain.model.Review;

@Repository
public class ReviewDao {

	@Autowired
	JdbcTemplate jdbc;

	//Reviewテーブルにデータを1件insert
	public int insertOne(Review review) throws DataAccessException {

		//1件登録
	    int rowNumber = jdbc.update("INSERT INTO drama_review(review_title, "
					+ "review_text,"
					+ "evaluation,"
					+ "user_name,"
					+ "drama_id)"
					+ "VALUES(?,?,?,?,?)"
					,review.getReviewTitle()
					,review.getReviewText()
					,review.getEvaluation()
	                ,review.getUserName()
	                ,review.getDramaId());

				return rowNumber;
	}

	//Reviewテーブルの全データを取得
	public List<Review> selectMany(int dramaId) throws DataAccessException {

		//全件取得
		List<Map<String, Object>>getList = jdbc.queryForList("SELECT * FROM drama_review "
				+ "JOIN user "
				+ "ON drama_review.user_name = user.user_name "
				+ "JOIN drama_info "
				+ "ON drama_review.drama_id = drama_info.id "
				+ "WHERE drama_info.id = ? ORDER BY id DESC ", dramaId);

		//結果返却用のList
		List<Review>reviewList = new ArrayList<>();

		//取得データ文loop
		for(Map<String, Object>map:getList) {

		Review review = new Review();

	    //取得したデータをセット
		review.setId((int)map.get("id"));
		review.setReviewTitle((String)map.get("review_title"));
		review.setReviewText((String)map.get("review_text"));
		review.setEvaluation((Integer)map.get("evaluation"));
		review.setUserName((String)map.get("user_name"));
		review.setDramaId((Integer)map.get("drama_id"));

		//Listに追加
		reviewList.add(review);

		}

		return reviewList;
	}

	//Reviewテーブルを1件削除
	public int deleteOne(int reviewId) throws DataAccessException {

		//1件削除
		int rowNumber = jdbc.update("DELETE FROM drama_review WHERE id = ?", reviewId);

		return rowNumber;
	}
}