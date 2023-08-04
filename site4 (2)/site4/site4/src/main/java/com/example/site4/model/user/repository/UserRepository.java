package com.example.site4.model.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.site4.model.user.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> { // UserEntity의 idx의 타입은 Long이다.
  // select * from user where idx = ?;
  // void findByIdx(Long idx);
  Optional<UserEntity> findByIdx(Long idx);

  // select * from user where id = ?;
  // void findById(String id);
  Optional<UserEntity> findById(String id);

  // select * from user where password = ?;
  // void findByPassword(String password);
  // password는 중복이 가능하므로 list로 간다.
  List<UserEntity> findByPassword(String password);

  // select * from user
  // where idx = ?
  // and id = ?
  // void findByIdxAndId(Long idx, Strig id);
  Optional<UserEntity> findByIdxAndId(Long idx, String id);

  // select * from user
  // where id like '%?%'
  // void findByIdContaining(String id);
  List<UserEntity> findByIdContaining(String id);
}
