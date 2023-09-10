package com.liter.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.liter.DTO.User;
import com.liter.Services.UserService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class UserController {
 @Autowired
  public UserService userService;
   
  @GetMapping("/user")
  public Flux<User> getUsers() {
    return userService.getUsers();
  } 
 
  @GetMapping("/userbyid")
  public Mono<User> getUserById(@RequestParam(value = "id") Long id) {
    try {
      return userService.getUserById(id);
    } catch (Exception e) {
      log.error("their is some error", e);
      return userService.getUserById(id); 
    }
    
  }

  @PostMapping("/addUser")
  public Mono<User> addUser(@RequestBody User User) {
    return userService.addUser(User);
  }

  @PostMapping("/updateUser")
  public Mono<User> updateUser(@RequestBody User User) {
    return userService.updateUser(User);
  }

  @PostMapping("/deleteUser")
  public Mono<String> deleteUser(@RequestBody User User) {
    Mono<Void> deleteConfirmation = userService.deleteUser(User);

   Mono<String> delConf = deleteConfirmation.then(Mono.just("Deleted Sucessfully"));
  
   return delConf ;
   
  }}
