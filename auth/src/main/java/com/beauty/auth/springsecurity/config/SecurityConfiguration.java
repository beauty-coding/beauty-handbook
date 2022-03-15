package com.beauty.auth.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author beauty
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				// 匹配路径
				.authorizeRequests()
				.antMatchers("/security/home").permitAll()
				.antMatchers("/security/**").hasRole("ADMIN")
				.antMatchers("/security/product/info").hasRole("USER")
				.and()
				// 修改默认登录界面
				.formLogin()
				.and()
				.logout();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		auth
				// 基于内存存储用户信息
				.inMemoryAuthentication()
				.passwordEncoder(passwordEncoder)
				.withUser("admin").password(passwordEncoder.encode("123456")).roles("ADMIN", "USER")
				.and()
				.withUser("spring").password(passwordEncoder.encode("123456")).roles("USER")
				.and()
				.withUser("user").password(passwordEncoder.encode("123456")).roles("ADMIN")
		;

//		super.configure(auth);

	}


	@Override
	public void configure(WebSecurity web) throws Exception {

		super.configure(web);
	}



}