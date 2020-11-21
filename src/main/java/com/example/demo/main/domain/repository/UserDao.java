package com.example.demo.main.domain.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.example.demo.main.domain.model.User;
import com.example.demo.main.domain.model.UserSearch;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate jdbc;

	@Autowired
	PasswordEncoder passwordEncoder;


	//Userテーブルにデータを1件insert
	public int insertOne(User user) throws DataAccessException {

		//パスワード暗号化
		String password = passwordEncoder.encode(user.getPassword());

		//ユーザーテーブルに1件登録
		String sql = "INSERT INTO user("
				+ "user_id,"
				+ "password,"
				+ "user_name,"
				+ "birthday,"
				+ "gender,"
				+ "role,"
				+ "deleted)"
				+"VALUES(?,?,?,?,?,?,?)";

		//1件挿入
		int rowNumber = jdbc.update(sql,
				user.getUserId(),
				password,
				user.getUserName(),
				user.getBirthday(),
				user.isGender(),
				user.getRole(),
				user.isDeleted());

		return rowNumber;
	}

	    //userテーブルの全データを取得
		public List<User> selectMany() throws DataAccessException {

			//全件取得
			List<Map<String, Object>>getList = jdbc.queryForList("SELECT * FROM user");

			//結果返却用のList
			List<User>userList = new ArrayList<>();

			//取得データ文loop
			for(Map<String, Object>map:getList) {

		    User user = new User();

		    //取得したデータをセット
		    user.setId((Integer)map.get("id"));
			user.setUserId((String)map.get("user_id"));
			user.setPassword((String)map.get("password"));
			user.setUserName((String)map.get("user_name"));
			user.setBirthday((Date)map.get("birthday"));
			user.setGender((Boolean)map.get("gender"));
			user.setDeleted((Boolean)map.get("deleted"));

			//Listに追加
			userList.add(user);

			}

			return userList;
		}

	//ユーザー検索に合致するuserテーブルのデータを取得
	public List<User> selectPlural(UserSearch search) throws DataAccessException {

		//1件取得
		List<Map<String, Object>>getList = jdbc.queryForList("SELECT * FROM user WHERE user_name = ?", search.getUserSearch());

		//結果返却用の変数
		List<User>userList = new ArrayList<>();

		//取得データ文loop
		for(Map<String, Object>map:getList) {

		User user = new User();

		//取得したデータをセット
		user.setId((Integer)map.get("id"));
	    user.setUserId((String)map.get("user_id"));
	    user.setPassword((String)map.get("password"));
		user.setUserName((String)map.get("user_name"));
		user.setBirthday((Date)map.get("birthday"));
		user.setGender((Boolean)map.get("gender"));
		user.setDeleted((Boolean)map.get("deleted"));


		//Listに追加
		userList.add(user);

		}

		return userList;
	}

	//ユーザー検索に合致するUserテーブルを1件論理削除
	public int deleteOne(User user) throws DataAccessException {

		//1件削除
		int rowNumber = jdbc.update("UPDATE user "
				+ "SET "
				+ "deleted = true "
				+ "WHERE id = ?"
				,user.getId());

		return rowNumber;
	}

}

