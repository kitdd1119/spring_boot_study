package com.example.site4.domain.auth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.site4.domain.auth.dto.ReqJoinDTO;
import com.example.site4.domain.auth.dto.ReqLoginDTO;
import com.example.site4.model.user.entity.UserEntity;
import com.example.site4.model.user.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
@Transactional(readOnly = true)
public class AuthServiceApiV1 {

  @Autowired
  private UserRepository userRepository;

  // 데이터를 db에 넣을 땐 Transactional 어노테이션을 사용해야 한다.
  // 회원가입
  @Transactional
  public ResponseEntity<?> join(ReqJoinDTO reqJoinDTO) {

    // 유저가 제대로된 데이터를 보냈는지 확인
    if (reqJoinDTO.getUser().getId() == null) {
      return new ResponseEntity<>("아이디를 입력해주세요.", HttpStatus.BAD_REQUEST);
    }
    if (reqJoinDTO.getUser().getId().length() < 3) {
      return new ResponseEntity<>("아이디는 3글자 이상이어야 합니다.", HttpStatus.BAD_REQUEST);
    }

    if (reqJoinDTO.getUser().getPassword() == null) {
      return new ResponseEntity<>("비밀번호를 입력해주세요.", HttpStatus.BAD_REQUEST);
    }
    if (reqJoinDTO.getUser().getPassword().length() < 3) {
      return new ResponseEntity<>("비밀번호는 3글자 이상이어야 합니다.", HttpStatus.BAD_REQUEST);
    }

    // DB에 넣기 전에 해당 id를 가진 유저가 있는지를 찾고
    // 있다면 이미 사용중인 아이디입니다. 라는 메시지를 보내주기
    Optional<UserEntity> userEntityOptional = userRepository.findById(reqJoinDTO.getUser().getId());
    // Present 존재한다라는 의미
    if (userEntityOptional.isPresent()) {
      return new ResponseEntity<>("이미 사용중인 아이디입니다.", HttpStatus.BAD_REQUEST);
    }

    UserEntity userEntity = new UserEntity(null, reqJoinDTO.getUser().getId(),
        reqJoinDTO.getUser().getPassword());

    // insert into user values(...);
    userRepository.save(userEntity);

    return new ResponseEntity<>(
        "회원가입에 성공하였습니다.",
        HttpStatus.OK);
  }

  // 로그인
  public ResponseEntity<?> login(ReqLoginDTO dto, HttpSession session) {
    Optional<UserEntity> userEntityOptional = userRepository.findById(dto.getUser().getId());

    // entity가 null이면 아이디를 잘 못 입력한 것.
    if (!userEntityOptional.isPresent()) {
      return new ResponseEntity<>("아이디를 잘 못 입력하셨습니다.", HttpStatus.BAD_REQUEST);
    }

    // 옵셔널에서 유저 엔티티 가져오기
    UserEntity userEntity = userEntityOptional.get();

    // 비밀번호 체크해서 다르면 잘 못 입력한 것
    if (!userEntity.getPassword().equals(dto.getUser().getPassword())) {
      return new ResponseEntity<>("비밀번호를 잘 못 입력하셨습니다.", HttpStatus.BAD_REQUEST);
    }

    // 인증 완료. 세션에 유저 정보를 입력, 담는다(저장한다)
    session.setAttribute("idx", userEntity.getIdx());
    session.setAttribute("id", userEntity.getId());

    return new ResponseEntity<>(
        "로그인에 성공하였습니다.",
        HttpStatus.OK);

  }
}
