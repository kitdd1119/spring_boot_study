package com.example.site1.domain.second.service;

import java.util.ArrayList;
import java.util.List;

// import java.util.List;

import org.springframework.stereotype.Service;

import com.example.site1.domain.second.dto.ResSecondDTO;
import com.example.site1.model.post.entity.PostEntity;
import com.example.site1.model.post.repository.PostRepository;

// import com.example.site1.model.post.entity.PostEntity;
// import com.example.site1.model.post.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SecondService {

    private final PostRepository postRepository;

    public ResSecondDTO getSecondDate() {
        List<PostEntity> postEntityList = postRepository.findAll();

        List<ResSecondDTO.Post> postList = new ArrayList<>();

        for (PostEntity postEntity : postEntityList) {
            ResSecondDTO.Post.User user = new ResSecondDTO.Post.User(postEntity.getUserEntity().getIdx());

            ResSecondDTO.Post post = new ResSecondDTO.Post(postEntity.getTitle(), postEntity.getContent(),user);

            postList.add(post);
        }

        ResSecondDTO resSecondDTO = new ResSecondDTO(postList);

        return resSecondDTO;
    }
}