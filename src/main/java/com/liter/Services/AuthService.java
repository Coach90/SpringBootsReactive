package com.liter.Services;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.liter.Repository.AdminRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AuthService {

    @Autowired
    public AdminRepository adminRepository;

    public Mono<String> login() {
      //return Flux.just(new Admin(1,"Ashwin","testUser","ashwin@gmai.com","9806587637"));
      //String pw_hash = BCrypt.hashpw("Coach@90", BCrypt.get());
      //return adminRepository.findByUsername("Coach");
      return Mono.just("Login Service");
    } 
    public Flux<String> register() {
      //return Mono.just(new Admin(id,"Ashwin","testUser","ashwin@gmai.com","9806587637"));
      return Flux.just("register Service");
    }
    public Flux<String> forgetPassword() {
      //return Mono.just(new Admin(id,"Ashwin","testUser","ashwin@gmai.com","9806587637"));
      return Flux.just("forgetPassword Service");
    }
    

}










