package com.nt.config;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfigDB extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource ds;
	
	public SecurityConfigDB() {
		System.out.println("SecurityConfigDB.SecurityConfigDB()");
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(ds).passwordEncoder(new BCryptPasswordEncoder())
		.usersByUsernameQuery("SELECT UNAME,PWD,STATUS FROM USERS WHERE UNAME=?")   //for autheentication
		.authoritiesByUsernameQuery("SELECT UNAME,ROLE FROM USER_ROLES WHERE UNAME=?");  //for authorization
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/offers").authenticated()
		.antMatchers("/balance").hasAnyAuthority("CUSTOMER", "MANAGER")   //use hasAnyAuthorities()
		.antMatchers("/loan").hasAuthority("MANAGER")
		.and().formLogin()
		.and().exceptionHandling().accessDeniedPage("/denied")
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/signout"));
	}	
}
