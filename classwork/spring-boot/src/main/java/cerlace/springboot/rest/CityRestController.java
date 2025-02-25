package cerlace.springboot.rest;

import cerlace.springboot.dto.CityDto;
import cerlace.springboot.entity.City;
import cerlace.springboot.service.CityService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("cities")
public class CityRestController {

    private final CityService cityService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CityDto> getCities() {
        return cityService.getCities();
    }

    @GetMapping(value = "/page")
    public Page<CityDto> getCitiesPage(
            @NotNull @RequestParam int pageNumber,
            @NotNull @RequestParam int pageSize) {
        return cityService.findAll(pageNumber, pageSize);
    }

    @PostMapping
    public CityDto createCity(@RequestBody CityDto city) {
        return cityService.saveOrUpdate(city);
    }
}
