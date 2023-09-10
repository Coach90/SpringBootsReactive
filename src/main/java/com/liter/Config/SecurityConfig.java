package com.liter.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

import com.liter.Repository.AdminRepository;

import reactor.core.publisher.Mono;

@EnableReactiveMethodSecurity
@Configuration
public class SecurityConfig {
    @Autowired
    public AdminRepository adminRepository;
    
    
    @Bean
    SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http)  throws Exception{
        http
            .authorizeExchange((authz) -> authz
                .pathMatchers(
                    "/auth/**",
                    "/status"
                    ).permitAll()
                .anyExchange().authenticated()
            )
            .cors((cors) -> cors
            .disable()
            )
            .csrf((csrf) -> csrf
            .disable()
            )
            .formLogin(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public ReactiveUserDetailsService reactiveUserDetailsService(){
         return username -> adminRepository.findByUsername(username)
                .switchIfEmpty(Mono.error(new UsernameNotFoundException("User not found")));
    }
    
    @Bean
    public PasswordEncoder passwordEncoder(){
       
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
         //System.out.println(passwordEncoder.encode("Coach@1234"));
         return passwordEncoder;
    }

    

    

}
    

 