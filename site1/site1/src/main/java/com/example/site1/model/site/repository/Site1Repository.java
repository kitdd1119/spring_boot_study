package com.example.site1.model.site.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Site1Repository extends JpaRepository<Site1Entity, Integer> {
    // 특정 엔티티 단일 데이터 가져오기
    // select * from regions where region_id = ?
    Site1Entity findByIdx(Integer Idx);

    // region_name으로 데이터 가져오기
    // region_name은 유니크하지 않기 때문에 여러 개를 가져올 수 있다.
    // List 타입으로 가져와야 한다.
    // RegionsEntity findByRegionName(String regionName);
    List<Site1Entity> findById(String Id);

    // region_id와 region_name이 둘 다 조건에 맞을 때 == 단일값
    // find - select * from regions
    // by - where
    // and - and
    Site1Entity findIdAndIdx(Integer Idx, String Id);

}
