package com.liter.Repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.liter.DTO.Admin;
import com.liter.DTO.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Repository
public interface UserRepository  extends ReactiveCrudRepository<User,Long> {
public Flux<User> findAll();
    
    public Mono<User> save(Admin admin);
   
    public Mono<User> findById(Long id);

    public Mono<Void> delete(User user);

    //public Mono<Admin> findByUsername(String username);

    //public Mono<UserDetails> findByUsername(String username);
}
