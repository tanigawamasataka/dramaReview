package com.example.demo.main.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.main.domain.model.Drama;
import com.example.demo.main.domain.model.SiteSearch;
import com.example.demo.main.domain.repository.DramaInfoDao;

@Service
public class DramaInfoService {

	@Autowired
	DramaInfoDao dao;

   	//insertメソッド
	  public boolean insert(Drama drama) {

		//1件insert
		int rowNumber = dao.insertOne(drama);

		//判定用変数
		boolean result = false;

		if(rowNumber > 0) {
			result = true;
		}

		return result;
	  }

	  //1件取得用メソッド
	  public Drama selectOne(int dramaId) {
		  return dao.selectOne(dramaId);
	  }

	  //全件取得用メソッド
      public List<Drama> selectMany() {
    	  return dao.selectMany();
      }

      //update用メソッド
      public boolean updateOne(Drama drama) {

    	 //1件update
  		int rowNumber = dao.updateOne(drama);

  		//判定用変数
  		boolean result = false;

  		if(rowNumber > 0) {
  			result = true;
  		}

  		return result;
      }

      //delete用メソッド
      public boolean deleteOne(int dramaId) {

    	  //1件削除
    	  int rowNumber = dao.deleteOne(dramaId);

    	  //判定用変数
    	  boolean result = false;

    	  if(rowNumber > 0) {

    		  //delete成功
    		  result = true;
    	  }
    	  return result;
      }

      //サイト検索合致分、全件取得用メソッド
      public List<Drama> selectPlural(SiteSearch search) {

    	 return dao.selectPlural(search);
     }
}
