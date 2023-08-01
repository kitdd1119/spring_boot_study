package com.example.site4.domain.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.site4.domain.auth.dto.ReqJoinDTO;
import com.example.site4.domain.auth.dto.ReqLoginDTO;
import com.example.site4.domain.auth.service.AuthServiceApiV1;

import jakarta.servlet.http.HttpSession;

@RestController // JSON으로 응답을 보내준다.
// RequestMapping는 주솟값만 인식함.
// /api/v1/auth 이는 컨트롤러와 주소값을 다르게 하기위해서 사용한 것임.
@RequestMapping("/api/v1/auth")
public class AuthControllerApiV1 {
  @Autowired
  private AuthServiceApiV1 authServiceApiV1;

  @PostMapping("/join")
  // ResponseEntity안에 상태코드를 넣어서 보내줄 수 있다.
  // public ResponseEntity<?>이 사이에 @ResponseBody 생략 가능 (이유는 @RestController가 있기
  // 때문이다.)
  public ResponseEntity<?> join(@RequestBody ReqJoinDTO dto) {
    ResponseEntity<?> responseEntity = authServiceApiV1.join(dto);
    return responseEntity;
    // 만들어 낸 변수로 값을 받는거랑
  }

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody ReqLoginDTO dto, HttpSession session) { // session에 내 정보를 담는다.
    return authServiceApiV1.login(dto, session);
    // 데이터 값을 바로 받는거랑 같음.
  }

}
