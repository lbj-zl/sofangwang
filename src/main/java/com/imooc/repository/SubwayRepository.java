package com.imooc.repository;

import com.imooc.entity.SubWay;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubwayRepository extends CrudRepository<SubWay, Long> {

    List<SubWay> findAllByCityEnName(String cityEnName);
}
