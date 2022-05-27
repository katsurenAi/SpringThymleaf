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
@Table(name = "image")
public class ImageEntity {
    // 画像ID
    @Id
    @GeneratedValue
    private int imageId;

    // 画像のパス
    @Column(nullable = false)
    private String imagePath;

}
