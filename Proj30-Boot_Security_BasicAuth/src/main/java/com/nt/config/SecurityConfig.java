package com.nt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//@Configuration
//@EnableWebSecurity      //optional to write
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Raja").password("{noop}rani").roles("CUSTOMER");
		auth.inMemoryAuthentication().withUser("Ramesh").password("{noop}hyd").roles("MANAGER");
	}
	
/*	// basic mode authentication without form
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/offers").authenticated()
		.antMatchers("balance").hasAnyRole("CUSTOMER", "MANAGER")
		.antMatchers("/loan").hasRole("MANAGER")
		.anyRequest().authenticated()
		.and().httpBasic()             //basic mode for authentication
		.and().exceptionHandling()
		.accessDeniedPage("/denied");
	}
*/

	// basic mode authentication with form	
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
