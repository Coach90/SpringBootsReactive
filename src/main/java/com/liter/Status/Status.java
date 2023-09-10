package com.liter.Status;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class Status {
   @GetMapping("/status")
    public Mono<String> status() {
      return Mono.just("Liter server is running");
    } 
}
