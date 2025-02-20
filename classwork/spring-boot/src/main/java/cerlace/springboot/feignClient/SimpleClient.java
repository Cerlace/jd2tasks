package cerlace.springboot.feignClient;

import cerlace.springboot.dto.CityDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "simple-feign", url = "http://localhost:8080")
public interface SimpleClient {
    @GetMapping("/cities")
    List<CityDto> getCities();
}
