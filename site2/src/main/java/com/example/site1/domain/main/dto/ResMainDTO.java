package com.example.site1.domain.main.dto;

import com.example.site1.model.user.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResMainDTO {

    private String id;

    public static ResMainDTO fromEntity(UserEntity userEntity){
        return new ResMainDTO(userEntity.getId());
    }
    
}
