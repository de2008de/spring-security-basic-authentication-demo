package com.david.springsecuriryapplication.configuration;

import com.david.springsecuriryapplication.authentication.CustomAuthenticationProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
	protected void configure(HttpSecurity http) throws Exception {
        
        http
        .csrf()
        .disable()
        .authorizeRequests()
        .antMatchers("/h2-console/**")
        .permitAll()
        .antMatchers("/api/v1/registration")
        .permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .httpBasic();

        http.headers().frameOptions().disable();
        
    }

    @Bean
    public AuthenticationProvider doAuthenticationProvider() {

        DaoAuthenticationProvider provider = new CustomAuthenticationProvider();

        // Must set UserDetailsService, or assert not null exception will be thrown
        provider.setUserDetailsService(userDetailsService);

        return provider;

    }

    @Bean
    public PasswordEncoder myPasswordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
