package com.example.site1.model.post.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.site1.model.post.entity.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Integer>{
    
    // idx로 Optional<PostEntity>찾기
    Optional<PostEntity> findByIdx(Integer idx);
    // title로 List<PostEntity> 찾기
    List<PostEntity> findByTitle(String title);
    // content로 List<PostEntity> 찾기
    List<PostEntity> findByContent(String content);
    // user_idx로 List<PostEntity> 찾기
    //정확히 말하면, userEntity 필드에 @JoinColumn 어노테이션이 지정되어 있고 user_idx가 column으로 지정되어 있지 않을 때, Spring Data JPA의 네이밍 규칙에 따라 findByUser_idx 메서드를 사용할 수는 없습니다.
    //@JoinColumn 어노테이션은 userEntity 필드를 사용하여 PostEntity와 UserEntity 사이의 관계를 매핑하는데 사용됩니다. @JoinColumn 어노테이션은 user_idx column과 UserEntity의 idx 필드를 연결해주는 역할을 합니다.
    //따라서 user_idx column이 직접 존재하지 않고 userEntity 필드를 통해 매핑되어 있는 경우, Spring Data JPA의 네이밍 규칙에 따라 findByUser_idx와 같은 메서드는 지원되지 않습니다.
    //대신, userEntity 필드의 속성을 기반으로 검색하는 메서드를 사용해야 합니다. 예를 들어, findByUserEntity_idx와 같은 메서드를 사용하여 userEntity의 userIdx 값을 기준으로 PostEntity를 찾을 수 있습니다.
    List<PostEntity> findByUserEntity_idx(Integer userIdx);

    // title이 포함된 List<PostEntity> 찾기
    List<PostEntity> findByTitleContaining(String title);
    // content가 포함된 List<PostEntity> 찾기
    List<PostEntity> findByContentContaining(String content);


    // title 또는 content가 포함된 List<PostEntity> 찾기
    List<PostEntity> findByTitleContainingOrContentContaining(String title, String content);

    // title과 content가 정확히 일치하는 List<PostEntity> 찾기
    List<PostEntity> findByTitleAndContent(String title, String content);

    // user_Idx가 일치하고 content를 포함하고 있는 List<PostEntity> 찾기
    List<PostEntity> findByUserEntity_idxAndContentContaining(Integer useridx, String Content);

    
}
