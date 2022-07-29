package com.sorsix.majstor_backend.config

import com.sorsix.majstor_backend.config.filters.JWTAuthenticationFilter
import com.sorsix.majstor_backend.config.filters.JwtAuthorizationFilter
import com.sorsix.majstor_backend.service.UserService
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.CrossOrigin

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
class JWTWebSecurityConfig(
    val passwordEncoder: PasswordEncoder,
    val userService: UserService
) : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {
        http!!.cors().and().csrf().disable()
            .authorizeRequests()
            .antMatchers("/registerMaster","/registerAdmin","/registerClient","/api/masters/approved","/api/cities", "/api/masters/types","/api/masters/filter","/api/masters/recommendations/*").permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .loginPage("/")
            .and()
            .addFilter(JWTAuthenticationFilter(authenticationManager(),this.userService,this.passwordEncoder))
            .addFilter(JwtAuthorizationFilter(authenticationManager(),userService))
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    }
}