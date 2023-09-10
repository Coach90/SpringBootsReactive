package com.liter.Controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liter.Services.AuthService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  AuthService authService;
  
  @RequestMapping("/adminuser")
  public Object adminUser(Mono<Authentication> user) {
    return user.map(userd ->  userd.getPrincipal());
  }

  @RequestMapping("/login")
  public Mono<String> login() {
    return authService.login();
  }
  @RequestMapping("/register")
  public Flux<String> register() {
    return authService.register();
  }
  @RequestMapping("/forget-password")
  public Flux<String> forgetPassword() {
    return authService.forgetPassword();
  }
  
}
