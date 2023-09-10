package com.liter.Repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.liter.DTO.Admin;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface AdminRepository extends ReactiveCrudRepository<Admin,Long> {
    
    public Flux<Admin> findAll();
    
    public Mono<Admin> save(Admin admin);
   
    public Mono<Admin> findById(Long id);

    public Mono<Void> delete(Admin admin);

    //public Mono<Admin> findByUsername(String username);

    public Mono<UserDetails> findByUsername(String username);
}
