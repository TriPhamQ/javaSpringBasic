package com.phamqtri.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Random {
  @RequestMapping("/random")
  public String SayHello() {
    return "Spring boot is great! So easy to just respond with strings";
  }
}
