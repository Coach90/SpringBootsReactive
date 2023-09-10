package com.liter.DTO;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class User {
   @Id
   @Generated
   @Column("customer_id")
   private Integer customer_id;
   private String firstname;
   private String lastname;
   private String email;
   private String telephone;
   private Date dob;
}
