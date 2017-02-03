/*package com.example.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/login*").permitAll()
		.antMatchers("/scripts/*").permitAll()
		.antMatchers("/styles/*").permitAll()
		.antMatchers("/login.html").permitAll()
		.antMatchers("/user/login").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login.html").usernameParameter("name").passwordParameter("password")
		.permitAll()
		.successForwardUrl("/alcohol.html")
		.defaultSuccessUrl("/alcohol.html")
		.failureUrl("/login.html?error=true");
	}


	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.inMemoryAuthentication()
		.withUser("user").password("password").roles("ADMIN");
	}
}*/