package com.example.demo.main.domain.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.main.domain.model.Drama;
import com.example.demo.main.domain.model.SiteSearch;

@Repository
public class DramaInfoDao {

	@Autowired
	JdbcTemplate jdbc;

	//drama_infoテーブルにデータを1件insert
	public int insertOne(Drama drama) throws DataAccessException {

		//1件登録
		int rowNumber = jdbc.update("INSERT INTO drama_info(drama_image, "
				+ "drama_name,"
				+ "drama_story,"
				+ "lead_actor,"
				+ "release_date)"
				+ "VALUES(?,?,?,?,?)"
				,drama.getDramaImage()
				,drama.getDramaName()
				,drama.getDramaStory()
				,drama.getLeadActor()
				,drama.getReleaseDate());

		return rowNumber;
	}

	//drama_infoテーブルのデータを1件取得
	public Drama selectOne(int id) throws DataAccessException {

		Map<String, Object> map = jdbc.queryForMap("SELECT drama_info.id, drama_info.drama_image, drama_info.drama_name, drama_info.drama_story, drama_info.lead_actor, drama_info.release_date, "
				+ " AVG(evaluation) FROM drama_info "
				+ " LEFT JOIN drama_review "
				+ " ON drama_info.id = drama_review.drama_id "
				+ " GROUP BY drama_info.id "
				+ " HAVING drama_info.id = ? ", id);

		//結果返却用の変数
		Drama drama = new Drama();

		//取得したデータを結果返却用の変数にセットしていく
		drama.setDramaId((Integer)map.get("id"));
		drama.setDramaImage((String)map.get("drama_image"));
		drama.setDramaName((String)map.get("drama_name"));
		drama.setDramaStory((String)map.get("drama_story"));
		drama.setLeadActor((String)map.get("lead_actor"));
		drama.setReleaseDate((Date)map.get("release_date"));
		if(null == map.get("AVG(evaluation)")) {
			drama.setReviewAvg(0);
		}else {
			drama.setReviewAvg((Integer)map.get("AVG(evaluation)"));
		}

		return drama;
	}

	//drama_infoテーブルの全データを取得
	public List<Drama> selectMany() throws DataAccessException {

		//全件取得
		List<Map<String, Object>>getList = jdbc.queryForList("SELECT drama_info.id, drama_info.drama_image, drama_info.drama_name, drama_info.drama_story, drama_info.lead_actor, drama_info.release_date, "
				+ " AVG(evaluation) FROM drama_info "
				+ " LEFT JOIN drama_review "
				+ " ON drama_info.id = drama_review.drama_id "
				+ " GROUP BY drama_info.id "
				+ " ORDER BY id DESC ");

		//結果返却用のList
		List<Drama>dramaList = new ArrayList<>();

		//取得データ文loop
		for(Map<String, Object>map:getList) {

		Drama drama = new Drama();

	    //取得したデータをセット
		drama.setDramaId((Integer)map.get("id"));
		drama.setDramaImage((String)map.get("drama_image"));
		drama.setDramaName((String)map.get("drama_name"));
		drama.setDramaStory((String)map.get("drama_story"));
		drama.setLeadActor((String)map.get("lead_actor"));
		drama.setReleaseDate((Date)map.get("release_date"));
		if(null == map.get("AVG(evaluation)")) {
			drama.setReviewAvg(0);
		}else {
			drama.setReviewAvg((Integer)map.get("AVG(evaluation)"));
		}

		//Listに追加
		dramaList.add(drama);

		}

		return dramaList;
	}

	    //drama_infoテーブルを1件更新
		public int updateOne(Drama drama) throws DataAccessException {


			//1件更新
			int rowNumber = jdbc.update("UPDATE drama_info "
					+ "SET "
					+ "drama_image = ?,"
					+ "drama_name = ?,"
					+ "drama_story = ?,"
					+ "lead_actor = ?,"
					+ "release_date = ? "
					+ "WHERE id = ?"
					,drama.getDramaImage()
					,drama.getDramaName()
					,drama.getDramaStory()
					,drama.getLeadActor()
					,drama.getReleaseDate()
					,drama.getDramaId());

			return rowNumber;
		}

	//drama_infoテーブルを1件削除
	public int deleteOne(int id) throws DataAccessException {

		//1件削除
		int rowNumber = jdbc.update("DELETE FROM drama_info WHERE id = ?", id);

		    return rowNumber;
	    }

	//サイト検索に合致するdrama_infoテーブルの複数データを取得
    public List<Drama> selectPlural(SiteSearch search) throws DataAccessException {

		//全件取得
		List<Map<String, Object>>getList = jdbc.queryForList("SELECT drama_info.id, drama_info.drama_image, drama_info.drama_name, drama_info.drama_story, drama_info.lead_actor, drama_info.release_date, "
				+ "AVG(evaluation) FROM drama_info "
				+ "LEFT JOIN drama_review "
				+ "ON drama_info.id = drama_review.drama_id "
				+ "WHERE "
				+ "drama_name=? "
				+ "OR "
				+ "lead_actor=? "
				+ "ORDER BY id DESC "
				,search.getSiteSearch()
				,search.getSiteSearch());

			//結果返却用のList
			List<Drama>dramaList = new ArrayList<>();

			//取得データ文loop
			for(Map<String, Object>map:getList) {

			Drama drama = new Drama();

		    //取得したデータをセット
			drama.setDramaId((Integer)map.get("id"));
			drama.setDramaImage((String)map.get("drama_image"));
			drama.setDramaName((String)map.get("drama_name"));
			drama.setDramaStory((String)map.get("drama_story"));
			drama.setLeadActor((String)map.get("lead_actor"));
			drama.setReleaseDate((Date)map.get("release_date"));
			if(null == map.get("AVG(evaluation)")) {
				drama.setReviewAvg(0);
			}else {
				drama.setReviewAvg((Integer)map.get("AVG(evaluation)"));
			}

			//Listに追加
			dramaList.add(drama);

			}

			return dramaList;
	}
}