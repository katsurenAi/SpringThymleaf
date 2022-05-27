package com.example.domain.repository;

import com.example.domain.entity.ImageEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * アカウント情報EntityにアクセスするRepositoryクラス
 */
@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Integer> {

}
