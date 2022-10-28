package com.ojas.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityCfg extends WebSecurityConfigurerAdapter{

	@Override
	public void configure(AuthenticationManagerBuilder auth)throws Exception {
		
		auth.inMemoryAuthentication().withUser("admin").password("adminpassword").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("user1").password("user1password").roles("USER1");
	}
	
//	@Override
//	public void configure(HttpSecurity http)throws Exception {
//		
//		http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
//	}
	
	@Override
	public void configure(HttpSecurity http)throws Exception {
		
		http.authorizeRequests().antMatchers("/emp/**").hasAnyRole("ADMIN").and().httpBasic();
	}
	
	@Bean
	public NoOpPasswordEncoder passEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
}
