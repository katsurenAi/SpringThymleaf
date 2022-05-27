package com.example.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.domain.entity.ImageEntity;
import com.example.domain.service.ImageService;

/**
 * アカウント情報に対してのリクエストを処理します
 */
@RestController
@RequestMapping("image")
@CrossOrigin
public class ImageController {
    // Beenからserviceクラスを呼び出し
    @Autowired
    ImageService imageService;

    /**
     * アカウント情報を全件取得します
     * @return List<ImageEntity> image情報リスト
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<ImageEntity> getAll() {
        return imageService.getAll();
    }
}
    
