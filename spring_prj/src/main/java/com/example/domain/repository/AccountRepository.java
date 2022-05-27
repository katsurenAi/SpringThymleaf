package com.example.domain.repository;

import com.example.domain.entity.AccountEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;



/**
 * アカウント情報EntityにアクセスするRepositoryクラス
 */
@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {

     /**
     * 入力されたアカウント名と一致するデータを検索
     * @return List<AccountEntity>
     */
    @Query(value = "select * from account  where account.user_name = ?1", nativeQuery = true)
    public List<AccountEntity> findByUserName(String userName);

    /**
     * 入力されたidと一致するデータを削除
     * @return void
     */
    @Query(value = "delete account where  account.account_id = ?1", nativeQuery = true)
    public void delete(int id);
    
}