package com.liter.DTO;

import java.util.ArrayList;
import java.util.Collection;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "admins")
public class Admin implements UserDetails{
   @Id
   @Generated
   private Integer id;
   private String name;
   private String username;
   private String email;
   private String mobile;
   private String tempToken;
   private Integer otp;
   private DateTime otpExpiredAT;
   private String password;
   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      GrantedAuthority simpleAuthority = new SimpleGrantedAuthority("ROLE_USER");

      // Convert the SimpleGrantedAuthority into a Collection<GrantedAuthority>
      Collection<GrantedAuthority> authorities = new ArrayList<>();
      authorities.add(simpleAuthority);
      return authorities;
      
   }
   
   @Override
   public boolean isAccountNonExpired() {
     return true;
   }
   @Override
   public boolean isAccountNonLocked() {
     return true;
   }
   @Override
   public boolean isCredentialsNonExpired() {
      return true;
   }
   @Override
   public boolean isEnabled() {
     return true;
   }
   
}
