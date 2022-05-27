package com.example.domain.service;

interface ServiceInterFace<T> {

    /**
     * 全てのデータを取得し、返却します
     * 
     * @return T データ
     */
    public T getAll();
    
}