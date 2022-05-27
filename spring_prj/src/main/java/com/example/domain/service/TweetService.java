package com.example.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.entity.TweetEntity;
import com.example.domain.repository.TweetRepository;

import java.util.Arrays;
import java.util.List;

/**
 * アカウント情報を操作するビジネスロジックを実装します
 */
@Service
@Transactional
public class TweetService extends AbstractService<TweetEntity, List<TweetEntity>> {
    // Beanからリポジトリの呼び出し
    @Autowired
    TweetRepository tweetRepository;

    /**
     * ツイートを全取得して返却します
     * @return List<TweetEntity> ツイート情報リスト
     */
    public List<TweetEntity> getAll() {
        return tweetRepository.findAll();
    }

    /**
     * IDからツイート情報を取得して返却します
     * @return TweetEntity ツイート情報
     */
    public TweetEntity findById(int id) {
        return tweetRepository.findById(id).orElseThrow();
    }

    /**
     * ツイートを保存します
     * @param String tweetString ツイート文字
     * @return void
     */
    public void storeTweet(String tweetString) {
        List<TweetEntity> entities = Arrays.asList(
                new TweetEntity(0,//ツイートID
                 tweetString, //ツイート文字
                 "1"));//アカウントID
        tweetRepository.saveAll(entities);
    }
}

