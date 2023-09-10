package com.liter.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liter.DTO.Admin;
import com.liter.Repository.AdminRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AdminService {

    @Autowired
    public AdminRepository adminRepository;

    public Flux<Admin> getAdmins() {
      //return Flux.just(new Admin(1,"Ashwin","testUser","ashwin@gmai.com","9806587637"));
      return adminRepository.findAll();
    } 
    public Mono<Admin> getAdminById(Long id) {
      //return Mono.just(new Admin(id,"Ashwin","testUser","ashwin@gmai.com","9806587637"));
      return adminRepository.findById(id);
    }
    public Mono<Admin> addAdmin(Admin admin) {
      //return Mono.just(new Admin(2,"Ashwin","testUser","ashwin@gmai.com","9806587637"));
      return adminRepository.save(admin);
    }
    public Mono<Admin> updateAdmin(Admin admin) {
      //return Mono.just(new Admin(2,"Ashwin","testUser","ashwin@gmai.com","9806587637"));
      return adminRepository.findById((long)admin.getId())
            .flatMap(existingAdmin -> {
                existingAdmin.setName(admin.getName());
                existingAdmin.setUsername(admin.getUsername());
                existingAdmin.setEmail(admin.getEmail());
                existingAdmin.setMobile(admin.getMobile());
                return adminRepository.save(existingAdmin);
            });
    }
    public Mono<Void> deleteAdmin(Admin admin) {
      //return Mono.just(new Admin(2,"Ashwin","testUser","ashwin@gmai.com","9806587637"));
       return adminRepository.delete(admin);
    }

}










