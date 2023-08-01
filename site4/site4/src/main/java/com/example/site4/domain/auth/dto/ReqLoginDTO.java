package com.example.site4.domain.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReqLoginDTO {

  private User user;

  @AllArgsConstructor
  @NoArgsConstructor
  @Getter
  public static class User {
    private String id;
    private String password;
  }
}
