package com.example.api.api_file_example;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;

@Controller
public class WeatherController {

    private final String OPEN_METEO_API_URL = "https://api.open-meteo.com/v1/forecast";

    @GetMapping("/weather")
    public String showForm(Model model) {
        return "weatherForm";
    }

    @PostMapping("/weather")
    public String getWeather(@RequestParam String latitude, @RequestParam String longitude, Model model) {

        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.br.bosch.com",80));
        factory.setProxy(proxy);

        RestTemplate restTemplate = new RestTemplate(factory);
        String url = OPEN_METEO_API_URL + "?latitude=" + latitude + "&longitude=" + longitude + "&current_weather=true";
        WeatherResponse response = restTemplate.getForObject(url, WeatherResponse.class);

        model.addAttribute("weather", response);
        return "weatherResult";
    }

}

