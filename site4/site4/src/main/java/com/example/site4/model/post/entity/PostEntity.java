package com.example.site4.model.post.entity;

import com.example.site4.model.user.entity.UserEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "`post`")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class PostEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idx", nullable = false, unique = true)
  private Long idx;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "content", nullable = false)
  private String content;

  // @Column(name = "user_idx", nullable = false)
  // private Long userIdx;

  // 쿼리문으로 직접 작성하는 방법
  @ManyToOne
  @JoinColumn(name = "user_idx", referencedColumnName = "idx")
  private UserEntity userEntity;

}
