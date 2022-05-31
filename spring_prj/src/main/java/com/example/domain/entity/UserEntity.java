package com.example.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
 
import javax.persistence.*;
import java.util.Collection;

/**
 * DBに入れる値を格納するクラス。
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accountUser")
public class UserEntity  implements UserDetails{

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String loginid;

    @Column(nullable = false)
    private String password;
    
        /* (非 Javadoc)
    * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
    */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
 
    /* (非 Javadoc) ##############ログインID＃＃＃＃＃＃＃＃＃＃＃
    * @see org.springframework.security.core.userdetails.UserDetails#getUsername()
    */
    @Override
    public String getUsername() {
        return this.loginid;
    }
 
    /* (非 Javadoc)
    * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
    */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    /* (非 Javadoc)
    * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
    */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return true;
    }
}