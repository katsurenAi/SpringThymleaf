package com.example.domain.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.domain.entity.UserEntity;
import com.example.domain.repository.UserRepository;
/**
 * Spring Securityのユーザ検索用のサービスの実装クラス
 * DataSourceの引数として指定することで認証にDBを利用できるようになる
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	//DBからユーザ情報を検索するメソッドを実装したクラス
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * UserDetailsServiceインタフェースの実装メソッド
	 * フォームから取得したユーザ名でDBを検索し、合致するものが存在したとき、
	 * パスワード、権限情報と共にUserDetailsオブジェクトを生成
	 * コンフィグクラスで上入力値とDBから取得したパスワードと比較し、ログイン判定を行う
	 */
	@Override
	public UserDetails loadUserByUsername(String loginid) throws UsernameNotFoundException {
		
		UserEntity userEntity = userRepository.findUser(loginid);
		
		if (userEntity == null) {
			throw new UsernameNotFoundException("User" + loginid + "was not found in the database");
		}
		
		return userEntity;
	}

}