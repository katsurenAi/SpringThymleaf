package com.example.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import com.example.domain.entity.TweetEntity;
import com.example.domain.service.TweetService;

import org.springframework.ui.Model;
/**
 * アカウント情報に対してのリクエストを処理します
 */
@RestController
@RequestMapping("tweet")
@CrossOrigin
public class TweetController {
    // Beenからserviceクラスを呼び出し
    @Autowired
    TweetService TweetService;

    /**
     * ツイート情報を全件取得します
     * @return List<TweetEntity> アカウント情報リスト
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<TweetEntity> getAll() {
        return TweetService.getAll();
    }

    /**
     * ツイート情報を全件取得します
     * @return List<TweetEntity> アカウント情報リスト
     */
    @RequestMapping(value = "/get/id", method = RequestMethod.GET)
    public List<TweetEntity> findById() {
        return TweetService.getAll();
    }
    
    /**
     * ツイート情報を全件取得します
     * @param tweetString
     * @return void
     */
    @RequestMapping(value = "/store", method = RequestMethod.POST)
    public void storeTweet(@RequestBody Map postParam) {
        TweetService.storeTweet(postParam.get("tweet").toString());
    }
}