package com.imooc.web.controller.house;

import com.imooc.base.ApiResponse;
import com.imooc.service.ISupportAddressService;
import com.imooc.service.ServiceMultiResult;
import com.imooc.web.dto.SubwayDTO;
import com.imooc.web.dto.SubwayStationDTO;
import com.imooc.web.dto.SupportAddressDTO;
import com.imooc.web.form.HouseForm;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HouseController {

    @Autowired
    private ISupportAddressService supportAddressService;

    @GetMapping(value = "/address/support/cities")
    @ResponseBody
    public ApiResponse getSupportCities() {
        ServiceMultiResult<SupportAddressDTO> allCities = supportAddressService.findAllCities();
        if (allCities.getResultSize() == 0) {
            return ApiResponse.ofStatus(ApiResponse.Status.NOT_FOUND);
        }

        return ApiResponse.ofSuccess(allCities.getResult());
    }

    @GetMapping("/address/support/subway/line")
    @ResponseBody
    public ApiResponse getSupportSubwayLine(@RequestParam("city_name") String name) {
        ServiceMultiResult<SubwayDTO> allByCity = supportAddressService.findAllByCity(name);
        if (allByCity.getResultSize() == 0) {
            return ApiResponse.ofStatus(ApiResponse.Status.NOT_FOUND);
        }
        return ApiResponse.ofSuccess(allByCity.getResult());
    }

    @GetMapping("/address/support/subway/station")
    @ResponseBody
    public ApiResponse getSupportSubwayStation(@RequestParam("subway_id") Long subwayId) {
        ServiceMultiResult<SubwayStationDTO> allBySubway = supportAddressService.findAllBySubway(subwayId);
        if (allBySubway.getResultSize() == 0) {
            return ApiResponse.ofStatus(ApiResponse.Status.NOT_FOUND);
        }

        return ApiResponse.ofSuccess(allBySubway.getResult());
    }

    @PostMapping("/admin/add/house")
    @ResponseBody
    public ApiResponse addHouse(@Valid @ModelAttribute("form-house-add"
    ) HouseForm houseForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ApiResponse.ofMessage(HttpStatus.SC_BAD_REQUEST,
                    bindingResult.getAllErrors().get(0).getDefaultMessage());
        }

        if (houseForm.getPhotos() == null || houseForm.getCover() == null) {
            return ApiResponse.ofMessage(HttpStatus.SC_BAD_REQUEST, "必须上传图片");
        }
        return null;
    }
}
