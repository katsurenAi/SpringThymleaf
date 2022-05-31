package com.example.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;

/**
 * UserEntityを登録・検索するクラス
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  
    @Query(value = "SELECT * FROM account_user WHERE account_user.loginid = ?1", nativeQuery = true)
    UserEntity findUser(String loginid);
}