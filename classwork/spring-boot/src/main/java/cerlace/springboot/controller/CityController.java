package cerlace.springboot.controller;

import cerlace.springboot.dto.CityDto;
import cerlace.springboot.service.CityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class CityController {

    private final CityService cityService;

    @GetMapping("/getCity")
    public String getCities(Model model) {
        model.addAttribute("cities", cityService.getCities());
        model.addAttribute("addCity", new CityDto());
        return "city";
    }

    @PostMapping("/addCity")
    public String saveCity(@Valid @ModelAttribute("addCity") CityDto city,
                           BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            cityService.saveOrUpdate(city);
            return "redirect:/getCity";
        }
        return "city";
    }
}
