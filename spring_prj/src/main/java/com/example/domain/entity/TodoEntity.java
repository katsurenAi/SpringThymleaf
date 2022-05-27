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
<<<<<<< HEAD
@NoArgsConstructor//コンストラクタに引数なしでもコンストラクタを生成できる＝デフォルト
@AllArgsConstructor//コンストラクタ作成＝引数あり
//@Table(name = "diary")	//↓のコンストラクタは不要
=======
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "diary")	//指定しないと生成されるテーブルはクラス名と同じdiary
>>>>>>> parent of e80dc3e (更新処理の追加とメソッド名・変数名の変更)
public class TodoEntity {
    // ID
    @Id
    @GeneratedValue
    private int id;

    // テキスト
    @Column(nullable = false)
    private String bodytext;

    // 入力時間
    @Column(name = "create_datetime", nullable = false)
    private LocalDateTime  createDatetime;

}
