package com.example.domain.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.entity.UserEntity;
import com.example.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//あとはServiceでEntityの値をJPAで登録させる
@Service
@Transactional
@RequiredArgsConstructor

public class SignUpService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public void save(UserEntity userEntity){
        UserEntity   entities = new UserEntity();
        //パスワードをハッシュ化して、insertする時の引数にセット。
        entities.setLoginid(userEntity.getLoginid());
        entities.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        /*
        List<UserEntity> insertList = Arrays.asList(
            new UserEntity(
                1,
                entities.getLoginid(),//ログインID
                entities.getPassword()//パスワード
                )); */              
        userRepository.save(entities);
    }
}

