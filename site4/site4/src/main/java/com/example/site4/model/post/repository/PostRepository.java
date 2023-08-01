package com.example.site4.model.post.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.site4.model.post.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Long> { // PostEntity의 idx의 타입은 Long이다.

  // 쿼리문으로 직접 작성하는 방법
  // @Query(value = "select * from post where title = ?", nativeQuery = true)
  // void getPostList(String title);

  // select * from post where idx = ?;
  Optional<PostEntity> findByIdx(Long idx);

  // select * from post where title = ?;
  List<PostEntity> findByTitle(String title);

  // select * from post where content = ?;
  List<PostEntity> findByContent(String content);

  // select * from post where user_idx = ?;
  // List<PostEntity> findByUserIdx(Long userIdx);

  // select * from post
  // where title = ?
  // or content = ?
  List<PostEntity> findByTitleOrContent(String title, String content);

  // select * from post
  // where title like '%?%'
  // or content like '%?%';
  List<PostEntity> findByTitleContainingOrContentContaining(String title, String content);

}
