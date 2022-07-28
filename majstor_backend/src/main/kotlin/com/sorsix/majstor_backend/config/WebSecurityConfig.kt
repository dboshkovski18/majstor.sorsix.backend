package com.sorsix.majstor_backend.config

//import org.springframework.context.annotation.Configuration
//import org.springframework.context.annotation.Profile
//import org.springframework.security.authentication.AuthenticationProvider
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
//import org.springframework.security.config.annotation.web.builders.HttpSecurity
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
//import org.springframework.security.crypto.password.PasswordEncoder
//
//@Profile("statefull-auth")
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
//class WebSecurityConfig(
//    private val passwordEncoder: PasswordEncoder,
//    private val authenticationProvider: CustomUsernameAndPasswordAuthenticationProvider
//) : WebSecurityConfigurerAdapter() {
//
//
//    override fun configure(http: HttpSecurity) {
//        http.csrf().disable()
//            .authorizeRequests()
//            .antMatchers("/login").permitAll()
//            .anyRequest()
//            .authenticated()
//            .and()
//            .formLogin()
//            .loginProcessingUrl("/loginPost")
//            .failureUrl("/login?error=BadCredentials")
//            .defaultSuccessUrl("/api/masters", true)
//            .and()
//            .logout()
//            .logoutUrl("/logout")
//            .clearAuthentication(true)
//            .invalidateHttpSession(true)
//            .deleteCookies("JSESSIONID")
//            .logoutSuccessUrl("/login")
//            .and()
//            .exceptionHandling().accessDeniedPage("/access_denied")
//    }
//
//    override fun configure(auth: AuthenticationManagerBuilder) {
//        auth.authenticationProvider(authenticationProvider)
//    }
//
//
//}