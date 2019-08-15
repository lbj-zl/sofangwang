package com.imooc.repository;

import com.imooc.entity.SubWay;
import com.imooc.entity.SubwayStation;
import com.imooc.entity.SupportAddress;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SupportAddressRepository extends CrudRepository<SupportAddress, Long> {

    List<SupportAddress> findAllByLevel(String Level);

    List<SubWay> findAllByCity(String name);

    List<SubwayStation> findAllBySubwayId(Long subwayId);
}
