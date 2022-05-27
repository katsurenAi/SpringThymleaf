package com.example.domain.service;

abstract class AbstractService<T, A> {

    /**
     * 全てのデータを取得し、返却します
     * 
     * @return A データ
     */
    abstract A getAll();

    /**
     * IDからデータを取得し、返却します
     * 
     * @return T データ
     */
    abstract T findById(int id);
    
}
