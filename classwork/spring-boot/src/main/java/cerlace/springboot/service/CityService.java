package cerlace.springboot.service;

import cerlace.springboot.dto.CityDto;

import java.util.List;

public interface CityService {
    void saveOrUpdate(CityDto cityDto);

    CityDto getByName(String name);

    List<CityDto> getCities();

    void deleteById(Integer id);
}
