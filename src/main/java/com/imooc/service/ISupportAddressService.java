package com.imooc.service;

import com.imooc.web.dto.SubwayDTO;
import com.imooc.web.dto.SubwayStationDTO;
import com.imooc.web.dto.SupportAddressDTO;

public interface ISupportAddressService {
    ServiceMultiResult<SupportAddressDTO> findAllCities();

    ServiceMultiResult<SubwayDTO> findAllByCity(String name);

    ServiceMultiResult<SubwayStationDTO> findAllBySubway(Long subwayId);
}
