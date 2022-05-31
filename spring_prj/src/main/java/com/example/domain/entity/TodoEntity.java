package com.example.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

import javax.persistence.*;

/**
 * アカウントの情報を永続化するEntity
 */
@Entity
@Data
@NoArgsConstructor//コンストラクタに引数なしでもコンストラクタを生成できる＝デフォルト
@AllArgsConstructor//コンストラクタ作成＝引数あり
//@Table(name = "diary")	//↓のコンストラクタは不要
public class TodoEntity {
    // ID
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    // テキスト
    @Column(nullable = false)
    private String bodytext;

    // 入力時間
    @Column(name = "create_datetime", nullable = false)
    private LocalDateTime  createDatetime;

}
