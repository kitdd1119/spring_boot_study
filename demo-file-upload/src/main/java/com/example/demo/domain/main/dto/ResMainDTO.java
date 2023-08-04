package com.example.demo.domain.main.dto;

import java.util.List;

import com.example.demo.model.entity.GalleryEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class ResMainDTO {

    private List<Gallery> galleryList; // 봉지

    public static ResMainDTO of(List<GalleryEntity> galleryEntityList) { // 상자
        List<Gallery> galleryList = galleryEntityList
                .stream()
                .map(galleryEntity -> Gallery.fromEntity(galleryEntity))
                .toList();

        return ResMainDTO.builder()
                .galleryList(galleryList)
                .build();
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class Gallery { // 치킨
        private String imgUrl;

        public static Gallery fromEntity(GalleryEntity galleryEntity) {
            return Gallery.builder()
                    .imgUrl(galleryEntity.getImgUrl())
                    .build();
        }
    }

}
