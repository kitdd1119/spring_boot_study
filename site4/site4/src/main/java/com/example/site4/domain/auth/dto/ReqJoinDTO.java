package com.example.site4.domain.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReqJoinDTO {
  // 이 놈이 ㄹㅇ User
  private User user;

  // 이 아래 내용은 설계도(밖에 있어야 할 내용을 안에 넣은 것임.)
  @AllArgsConstructor
  @NoArgsConstructor
  @Getter
  public static class User {
    private String id;
    private String password;
  }
}
