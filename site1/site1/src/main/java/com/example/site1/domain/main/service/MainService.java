package com.example.site1.domain.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.site1.domain.main.dto.ResMainDTO;
import com.example.site1.model.site.entity.UserEntity;
import com.example.site1.model.site.repository.UserRepository;

// 약속
// entity객체는 Service에서 빠져나가지 못한다
// entity -> dto

@Service
public class MainService {

    // Ioc 컨테이너에서 RegionsRepository타입의 객체를 가져온다
    // 의존성 주입 DI
    @Autowired
    private UserRepository userRepository;

    public List<ResMainDTO> getMainPageData(){

        List<UserEntity> userEntityList = userRepository.findAll();

        List<ResMainDTO> resMainDTOList = userEntityList
            .stream()
            .map((siteEntity) -> ResMainDTO.fromEntity(userEntity))
            .toList();

        return resMainDTOList;

    }


    
}
