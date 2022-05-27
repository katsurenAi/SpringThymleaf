package com.example.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.example.domain.entity.MessageEntity;
import com.example.domain.repository.MessageRepository;

/**
 * アカウント情報を操作するビジネスロジックを実装します
 */
@Service
@Transactional
public class MessageService implements ServiceInterFace<List<MessageEntity>>  {

    // Beenからリポジトリの呼び出し
    @Autowired
    MessageRepository messageRepository;

    /**
     * メッセージ情報を全て取得します
     * @return List<メッセージ> メッセージ情報リスト
     */
    public List<MessageEntity> getAll() {
        return messageRepository.findAll();
    }

    /**
     * メッセージ情報を保存します
     * @return List<AccountEntity> メッセージ情報リスト
     */
    public void saveMessage(Map massageParam) {
        List<MessageEntity> entities = Arrays.asList(
                new MessageEntity(
                    7, //メッセージID
                    massageParam.get("messageTitle").toString(),//メッセージタイトル
                    massageParam.get("messageDetail").toString(),//メッセージ詳細
                    massageParam.get("submitAccount").toString()//メッセージsubmitAccount
                    ));              
                //入力された値を保存する
                 messageRepository.saveAll(entities);
        }
}
