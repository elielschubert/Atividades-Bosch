package com.example.api.api_file_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WatherController {

    @Autowired
    private ApiServiceWather apiServiceWather;

    @GetMapping("/weather")
    public String getWeather(Model model){
        //Consome a api para obter o clima
        String weatherData = apiServiceWather.getWeather();

        model.addAttribute("weatherData", weatherData);

        return "weatherPage";
    }
}
