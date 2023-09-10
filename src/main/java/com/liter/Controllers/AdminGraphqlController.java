package com.liter.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import com.liter.DTO.Admin;
import com.liter.Services.AdminService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@Slf4j
public class AdminGraphqlController {
   
@Autowired
public AdminService adminService;
   
 @QueryMapping
 Flux<Admin> getAllAdmins() {
  return adminService.getAdmins();
  } 

  @QueryMapping("getAdmin")
  public Mono<Admin> getAdminById(@Argument Long id) {
    return adminService.getAdminById(id);
  }

  @MutationMapping("addAdmin")
  public Mono<Admin> addAdmin(@Argument Admin adminInput) {
    //return Mono.just(new Admin(3,"test","testUser","Test@gmail.com","980658737")).log();
    return adminService.addAdmin(adminInput);
  }

  @MutationMapping("updateAdmin")
  public Mono<Admin> updateAdmin(@Argument Admin updateInput) {
    return adminService.updateAdmin(updateInput);
  }
  
  @MutationMapping("deleteAdmin")
  public Mono<String> deleteAdmin(@Argument Admin updateInput) {
    try {
      Mono<Void> deleteConfirmation = adminService.deleteAdmin(updateInput);

        return deleteConfirmation.then(Mono.just("Deleted Sucessfully"));

    } catch (Exception e) {
     
      log.error("deletion was not sucessfull", e);
     
      return Mono.just("Deletion was unsucessfull");
    }
    
  }
}
