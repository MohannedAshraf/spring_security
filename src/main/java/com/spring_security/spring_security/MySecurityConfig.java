package com.spring_security.spring_security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MySecurityConfig {
// @Bean
// UserDetailsService userDetailsService(){
//     InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
//   UserDetails user = 
//    User.withUsername("Mohanned")
//    .password(passwordEncoder().encode("204200")).authorities("read").build();
//   userDetailsService.createUser(user); 
  
//   return userDetailsService;
// }

@Bean 
 BCryptPasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
}


    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.formLogin(Customizer.withDefaults());
        http.authorizeHttpRequests(auth -> auth.requestMatchers("/hello").authenticated().anyRequest().denyAll());
        return http.build();
    }
}
