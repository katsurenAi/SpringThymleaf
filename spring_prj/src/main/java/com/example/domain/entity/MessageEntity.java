package com.example.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * アカウントの情報を永続化するEntity
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "massage")

public class MessageEntity {
    // メッセージのID
    @Id
    @GeneratedValue
    private int messageId;

    // メッセージのタイトル
    @Column(nullable = false)
    private String messageTitle;

    // メッセージの詳細
    @Column(nullable = false)
    private String messageDetail;

    // メッセージのsubmitAccount
    @Column(nullable = false)
    private String submitAccount;

}
