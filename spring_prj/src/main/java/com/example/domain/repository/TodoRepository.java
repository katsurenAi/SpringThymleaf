package com.example.domain.repository;

import com.example.domain.entity.TodoEntity;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
/**
 * アカウント情報EntityにアクセスするRepositoryクラス
 */
@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Integer> {
    /**
     * 入力されたidと一致するデータを削除
     * @return void
     */
    @Query(value = "delete diary_entity where  diary_entity.account_id = ?1", nativeQuery = true)
    public void delete(int id);

    /**
     * 降順にソートするasc
     * @return void
     */
    @Query(value = "select *  from todo_entity order by id desc", nativeQuery = true)
    public List<TodoEntity> desc();

    /**
     * 降順にソートするasc
     * @return void
     */
    @Query(value = "select *  from todo_entity order by id ", nativeQuery = true)
    public List<TodoEntity> asc();

}