package com.example.domain.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.entity.UserEntity;

/**
 * DBへのアクセスメソッドを呼び出すDao
 * 
 *
 */
@Repository
public class LoginUserDao {
	
	@Autowired
	EntityManager em;
	
	/**
	 * フォームの入力値から該当するユーザを検索 合致するものが無い場合Nullが返される
	 * @param loginid
	 * @return 一致するユーザが存在するとき:UserEntity、存在しないとき:Null
	 */
	public UserEntity findUser(String loginid) {
		String query = "";
		query += "SELECT * ";
		query += "FROM accountUser ";
		query += "WHERE loginid = :loginid "; //setParameterで引数の値を代入できるようにNamedParameterを利用
		
		//EntityManagerで取得された結果はオブジェクトとなるので、LoginUser型へキャストが必要となる
		return (UserEntity)em.createNativeQuery(query, UserEntity.class).setParameter("loginid", loginid)
				.getSingleResult();
	}

}