package com.example.site4.domain.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

  @GetMapping("/join")
  public String join() {
    return "auth/join";
  }

  @GetMapping("/login")
  public String login(HttpSession session) {
    Object attribute = session.getAttribute("idx");

    Long idx = (Long) attribute;

    System.out.println("로그인 페이지 idx : " + idx);

    return "auth/login";
  }

}
