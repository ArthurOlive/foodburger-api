package com.api.foodburg.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.api.foodburg.auth.JwtAuthenticationEntryPoint;
import com.api.foodburg.auth.JwtRequestFilter;
import com.api.foodburg.auth.JwtUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;

    @Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.httpBasic();
		httpSecurity.csrf().disable();

		configureEndPointAuthenticate(httpSecurity);
		configureOpenEndPointPermissions(httpSecurity);
	}

    private void configureEndPointAuthenticate(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().authorizeRequests()
			.antMatchers(HttpMethod.POST, "/api/register").permitAll()
			.antMatchers(HttpMethod.POST, "/api/authenticate").permitAll()
			.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	private void configureOpenEndPointPermissions(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().authorizeRequests()
			.anyRequest().authenticated()
			.and().exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
			.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and().addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder
			.userDetailsService(jwtUserDetailsService)
			.passwordEncoder(passwordEncoder());
	}
    
}
