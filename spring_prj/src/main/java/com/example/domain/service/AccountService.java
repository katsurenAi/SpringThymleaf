package com.example.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.example.domain.entity.AccountEntity;
import com.example.domain.repository.AccountRepository;

/**
 * アカウント情報を操作するビジネスロジックを実装します
 */
@Service
@Transactional
public class AccountService extends AbstractService<AccountEntity, List<AccountEntity>> {

    // Beenからリポジトリの呼び出し
    @Autowired
    AccountRepository accountRepository;

    /**
     * アカウント情報を全て取得します
     * @return List<AccountEntity> アカウント情報リスト
     */
    public List<AccountEntity> getAll() {
        return accountRepository.findAll();
    }

    /**
     * IDからツイート情報を取得して返却します
     * @return TweetEntity ツイート情報
     */
    public AccountEntity findById(int id) {
        return accountRepository.findById(id).orElseThrow();
    }

    /**
     * 入力されたアカウントを保存します
     * @param accountParam
     * @return void
     */
    public void saveAcccount(Map accountParam) {
        List<AccountEntity> entities = Arrays.asList(
                new AccountEntity(
                    7, //ID
                    accountParam.get("email").toString(),//メールアドレス
                    accountParam.get("password").toString(),//パスワード
                    accountParam.get("userName").toString(),//ユーザー名 
                    accountParam.get("accountDetails").toString()//アカウントの詳細
                    ));               
             accountRepository.saveAll(entities);
        }

    /**
     * アカウント名と一致する情報を検索します
     * @param userName 
     * @return void
     */
    public List<AccountEntity> serchInfo(String userName) {
        //アカウント名で検索    
        return accountRepository.findByUserName(userName);
        
    }

    /**
     * アカウントIDと一致する情報を削除します。
     * @param id  文字
     * @return void
     */
    public void delete(int id) {
        //削除する処理
        accountRepository.deleteById(id);
        
    }

} 