package com.example.domain.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.domain.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    //パスワードの暗号化
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // フィルタリングしないフォルダやファイル
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/image/**",
                "/css/**",
                "/js/**"
                );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // ログイン画面と新規登録画面は誰でも遷移可能
        http.authorizeRequests()
        .antMatchers("/login", "/signup")
        .permitAll()
        .anyRequest().authenticated();

        // ログイン
        http.formLogin()
        .loginPage("/login") //ログインページはコントローラを経由しないのでViewNameとの紐付けが必要
        .loginProcessingUrl("/login") //フォームのSubmitURL、このURLへリクエストが送られると認証処理が実行される
        .usernameParameter("loginId") //リクエストパラメータのname属性を明示
        .passwordParameter("password")
        .successForwardUrl("/index")
        .failureUrl("/login?error")
        .permitAll();

        // ログアウト
        http.logout()
        .logoutUrl("/logout")
        .logoutSuccessUrl("/login")
        .invalidateHttpSession(true)
        .deleteCookies("JSESSIONID", "SESSION", "remember-me")
        .permitAll();
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
}
