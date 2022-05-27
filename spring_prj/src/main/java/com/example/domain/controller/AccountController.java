package com.example.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import com.example.domain.entity.AccountEntity;
import com.example.domain.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.annotation.Validated;
/**
 * アカウント情報に対してのリクエストを処理します
 */
@RestController
@RequestMapping("account")
@CrossOrigin
@Validated  // 追加
public class AccountController {
    // Beenからserviceクラスを呼び出し
    @Autowired
    AccountService accountService;

    /**
     * アカウント情報を全件取得します
     * @param postparam
     * @return List<AccountEntity> アカウント情報リスト
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<AccountEntity> getAll() {
        return accountService.getAll();
    }

    /**
     * アカウント情報を全件取得します
     * @return List<AccountEntity> アカウント情報リスト
     */
    @RequestMapping(value = "/get/id", method = RequestMethod.GET)
    public List<AccountEntity> findById() {
        return accountService.getAll();
    }

    /**
     * アカウント情報を保存します
     * @param accountParam
     * @return void
     */
    @RequestMapping(value = "/store", method = RequestMethod.POST)
    public void saveAcccount(@RequestBody Map accountParam) {
        accountService.saveAcccount(accountParam);        
    } 

    /**
     * 指定したAccount名をもつaccountテーブルのデータを取得する
     * @param userName
     * @return List<AccountEntity> アカウント情報リスト
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<AccountEntity> selectAcccount(@Validated @RequestParam("accountName") String userName ) {
        //サービスクラスで検索した、検索結果をListに格納します
        List<AccountEntity> list = accountService.serchInfo(userName);
        //検索結果を出力
        return list;
    }
    
    /**
     * 指定したIDをもつaccountテーブルのデータを削除する 
     * @param id
     * @return List<AccountEntity> アカウント情報リスト
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public void delete(@Validated @RequestParam("id") int id) {
        //サービスクラスを呼び出して削除します
        accountService.delete(id);
    }
}
