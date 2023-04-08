package com.mainak.backendApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.mainak.backendApp.models.User;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	@Autowired
	UserDetailsService userDetailService;
	
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	//authenticate
	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception{
		return http.getSharedObject(AuthenticationManagerBuilder.class)
					.userDetailsService(userDetailService)
					.passwordEncoder(passwordEncoder())
					.and()
					.build();
	}
	//authorize
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.cors();
		http
			.csrf().disable()
			.authorizeHttpRequests()
			.requestMatchers("/api/v1/loginBackend").permitAll()
			.anyRequest().authenticated().and().httpBasic();
		return http.build();
	}
}
