package cerlace.springboot.service.impl;

import cerlace.springboot.dto.CityDto;
import cerlace.springboot.entity.City;
import cerlace.springboot.repository.CityRepository;
import cerlace.springboot.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public CityDto saveOrUpdate(CityDto cityDto) {
        City city = cityRepository.save(City.builder()
                .id(cityDto.getId())
                .name(cityDto.getName())
                .location(cityDto.getLocation())
                .build());
        return CityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .location(city.getLocation())
                .build();
    }

    @Override
    public CityDto getByName(String name) {
        Optional<City> cityOptional = cityRepository.findByName(name);
        return cityOptional.map(city -> CityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .location(city.getLocation())
                .build()).orElse(null);
    }

    @Override
    public List<CityDto> getCities() {
        return cityRepository.findAll().stream()
                .map(city -> CityDto.builder()
                        .id(city.getId())
                        .name(city.getName())
                        .location(city.getLocation())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public Page<CityDto> findAll(int pageNumber, int pageSize) {
        return cityRepository.findAll(PageRequest.of(pageNumber, pageSize))
                .map(city ->
                        CityDto.builder().id(city.getId())
                                .name(city.getName())
                                .location(city.getLocation())
                                .build());
    }

    @Override
    public void deleteById(Integer id) {
        cityRepository.deleteById(id);
    }
}
