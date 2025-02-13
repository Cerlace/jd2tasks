package cerlace.springboot.controller;

import cerlace.springboot.dto.CityDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Controller
public class CityController {

    private final List<CityDto> cityDtoList = Stream.of(
                    CityDto.builder()
                            .id(1)
                            .location("Belarus")
                            .name("Minsk")
                            .build(),
                    CityDto.builder()
                            .id(2)
                            .location("Russia")
                            .name("Moscow")
                            .build())
            .collect(Collectors.toCollection(ArrayList::new));

    @GetMapping("/getCity")
    public String getCities(Model model) {
        model.addAttribute("cities", cityDtoList);
        model.addAttribute("addCity", new CityDto());
        return "city";
    }

    @PostMapping("/addCity")
    public String savePerson(@Valid @ModelAttribute("addCity") CityDto city,
                             BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            cityDtoList.add(city);
            return "redirect:/getCity";
        }
        return "city";
    }
}
