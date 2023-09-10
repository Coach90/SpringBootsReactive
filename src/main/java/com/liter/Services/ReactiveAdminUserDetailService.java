package com.liter.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;

import com.liter.Repository.AdminRepository;

import reactor.core.publisher.Mono;

public class ReactiveAdminUserDetailService implements ReactiveUserDetailsService {
    
    @Autowired
    AdminRepository adminRepository;
    @Override
    public Mono<UserDetails> findByUsername(String username) throws UnsupportedOperationException {
       return adminRepository.findByUsername(username);
    }
    
}
