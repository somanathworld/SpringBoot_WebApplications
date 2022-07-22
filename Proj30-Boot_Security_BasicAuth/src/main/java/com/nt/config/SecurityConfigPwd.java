package com.nt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@SuppressWarnings("deprecation")
//@Configuration
public class SecurityConfigPwd extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.passwordEncoder(new BCryptPasswordEncoder())
		.withUser("Raja").password("$2a$10$r07n2pORB/LcwR18TRyVKe1HfJFSPM.sSSbxqefRAAUIdyZqPu.7i")
		.roles("CUSTOMER");
		
		auth.inMemoryAuthentication()
		.passwordEncoder(new BCryptPasswordEncoder())
		.withUser("Ramesh").password("$2a$10$Zu34ql4ViSe.ESHcykDvgeA8gLnBdGqKpupO2TjSxrMw75DFOVd8K")
		.roles("MANAGER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/offers").authenticated()
		.antMatchers("/balance").hasAnyRole("CUSTOMER", "MANAGER")
		.antMatchers("/loan").hasRole("MANAGER")
		.anyRequest().authenticated()
		.and().formLogin()
		.and().exceptionHandling().accessDeniedPage("/denied")
//		.and().logout()          //url = logout
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
		.and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true);
	}
}
