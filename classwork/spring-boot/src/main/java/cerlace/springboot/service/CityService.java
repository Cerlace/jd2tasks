package cerlace.springboot.service;

import cerlace.springboot.dto.CityDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CityService {
    CityDto saveOrUpdate(CityDto cityDto);

    CityDto getByName(String name);

    List<CityDto> getCities();

    Page<CityDto> findAll(int pageNumber, int pageSize);

    void deleteById(Integer id);
}
