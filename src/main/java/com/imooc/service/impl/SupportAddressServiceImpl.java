package com.imooc.service.impl;

import com.imooc.entity.SubWay;
import com.imooc.entity.SubwayStation;
import com.imooc.entity.SupportAddress;
import com.imooc.repository.SupportAddressRepository;
import com.imooc.service.ISupportAddressService;
import com.imooc.service.ServiceMultiResult;
import com.imooc.web.dto.SubwayDTO;
import com.imooc.web.dto.SubwayStationDTO;
import com.imooc.web.dto.SupportAddressDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupportAddressServiceImpl implements ISupportAddressService {

    @Autowired
    private SupportAddressRepository supportAddressRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ServiceMultiResult<SupportAddressDTO> findAllCities() {
        List<SupportAddress> allByLevel =
                supportAddressRepository.findAllByLevel(SupportAddress.Level.CITY.getValue());
        List<SupportAddressDTO> addressDTOS = new ArrayList<>();
        for (SupportAddress supportAddress : allByLevel) {
            SupportAddressDTO supportAddressDTO = modelMapper.map(supportAddress, SupportAddressDTO.class);
            addressDTOS.add(supportAddressDTO);
        }
        return new ServiceMultiResult<>(addressDTOS.size(), addressDTOS);
    }

    @Override
    public ServiceMultiResult<SubwayDTO> findAllByCity(String name) {
        List<SubWay> allByCity = supportAddressRepository.findAllByCity(name);
        List<SubwayDTO> subwayDTOS = new ArrayList<>();
        for (SubWay subWay : allByCity) {
            SubwayDTO subwayDTO = modelMapper.map(subWay, SubwayDTO.class);
            subwayDTOS.add(subwayDTO);
        }
        return new ServiceMultiResult<>(subwayDTOS.size(), subwayDTOS);
    }

    @Override
    public ServiceMultiResult<SubwayStationDTO> findAllBySubway(Long subwayId) {
        List<SubwayStation> allSubwayStation =
                supportAddressRepository.findAllBySubwayId(subwayId);
        List<SubwayStationDTO> subwayStationDTOS = new ArrayList<>();
        for (SubwayStation subwayStation : allSubwayStation) {
            SubwayStationDTO subwayStationDTO = modelMapper.map(subwayStation, SubwayStationDTO.class);
            subwayStationDTOS.add(subwayStationDTO);
        }
        return new ServiceMultiResult<>(subwayStationDTOS.size(), subwayStationDTOS);
    }
}
