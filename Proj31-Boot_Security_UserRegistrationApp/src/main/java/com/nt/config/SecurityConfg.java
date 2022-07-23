package com.nt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfg extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService service;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(encoder);
	}
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//		.antMatchers("/bank/").permitAll()
//		.antMatchers("/user/register").permitAll()
//		.antMatchers("/bank/offers").authenticated()
//		.antMatchers("/bank/balance").hasAnyAuthority("CUSTOMER", "MANAGER")
//		.antMatchers("/bank/loanApprove").hasAuthority("MANAGER")
//		.anyRequest().authenticated()
//		.and().exceptionHandling().accessDeniedPage("/bank/denied")
//		.and()
//		.formLogin().defaultSuccessUrl("/bank/",true)
//		.and()
//		.logout().logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
//		.and()
//		.sessionManagement().maximumSessions(3);
//	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
		.antMatchers("/bank/").permitAll()
		.antMatchers("/user/register", "/user/showLogin").permitAll()
		.antMatchers("/bank/offers").authenticated()
		.antMatchers("/bank/balance").hasAnyAuthority("CUSTOMER", "MANAGER")
		.antMatchers("/bank/loan").hasAuthority("MANAGER")
		.anyRequest().authenticated()
		.and()
		.formLogin()
			.loginPage("/user/showLogin")    	//for  GET mode request to launch form page
			.loginProcessingUrl("/login")	 	//for POST mode request to submit and process the request
			.defaultSuccessUrl("/bank/",true)	//HOME page url
			.failureUrl("/user/showLogin?error")// Authentication failed url
		.and()
		.rememberMe()
		.and()
		.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
			.logoutSuccessUrl("/user/showLogin?logout")
		.and()
		.exceptionHandling().accessDeniedPage("/bank/denied")
		.and()
		.sessionManagement().maximumSessions(3).maxSessionsPreventsLogin(true);
		
		// disable or enable  csrf protection
		//http.csrf().disable();
		}
}
