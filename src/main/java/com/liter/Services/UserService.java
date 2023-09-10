package com.liter.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liter.DTO.User;
import com.liter.Repository.UserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class UserService {
     @Autowired
    public UserRepository UserRepository;

    public Flux<User> getUsers() {
      //return Flux.just(new User(1,"Ashwin","testUser","ashwin@gmai.com","9806587637"));
      return UserRepository.findAll();
    } 
    public Mono<User> getUserById(Long id) {
      //return Mono.just(new User(id,"Ashwin","testUser","ashwin@gmai.com","9806587637"));
      return UserRepository.findById(id);
    }
    public Mono<User> addUser(User user) {
      //return Mono.just(new User(2,"Ashwin","testUser","ashwin@gmai.com","9806587637"));
      return UserRepository.save(user);
    }
    public Mono<User> updateUser(User user) {
      //return Mono.just(new User(2,"Ashwin","testUser","ashwin@gmai.com","9806587637"));
      return UserRepository.findById((long)user.getCustomer_id())
            .flatMap(existingUser -> {
                existingUser.setFirstname(user.getFirstname());
                existingUser.setLastname(user.getLastname());
                existingUser.setEmail(user.getEmail());
                existingUser.setTelephone(user.getTelephone());
                return UserRepository.save(existingUser);
            });
    }
    public Mono<Void> deleteUser(User user) {
      //return Mono.just(new User(2,"Ashwin","testUser","ashwin@gmai.com","9806587637"));
       return UserRepository.delete(user);
    }

}

