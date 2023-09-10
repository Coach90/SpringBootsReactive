package com.liter.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.liter.DTO.Admin;
import com.liter.Services.AdminService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class AdminRestController {
   
  @Autowired
  public AdminService adminService;
   
  @GetMapping("/admin")
  public Flux<Admin> getAdmins() {
    return adminService.getAdmins();
  } 

  @GetMapping("/test")
  public Flux<Integer> testMap() {
    Flux<Integer> ofInt = Flux.just(1,5,7,9,15,17); 
    return ofInt.map(it->it*it);
  }
  
  @GetMapping("/adminbyid")
  public Mono<Admin> getAdminById(@RequestParam(value = "id") Long id) {
    try {
      return adminService.getAdminById(id);
    } catch (Exception e) {
      log.error("their is some error", e);
      return adminService.getAdminById(id); 
    }
    
  }

  @PostMapping("/addadmin")
  public Mono<Admin> addAdmin(@RequestBody Admin admin) {
    return adminService.addAdmin(admin);
  }

  @PostMapping("/updateadmin")
  public Mono<Admin> updateAdmin(@RequestBody Admin admin) {
    return adminService.updateAdmin(admin);
  }

  @PostMapping("/deleteadmin")
  public Mono<String> deleteAdmin(@RequestBody Admin admin) {
    Mono<Void> deleteConfirmation = adminService.deleteAdmin(admin);

   Mono<String> delConf = deleteConfirmation.then(Mono.just("Deleted Sucessfully"));
  
   return delConf ;
   
  }
}
