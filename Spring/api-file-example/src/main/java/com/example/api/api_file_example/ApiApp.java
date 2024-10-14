package com.example.api.api_file_example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class ApiApp implements CommandLineRunner {

    @Autowired
    private WeatherController weatherController;

    public static void main(String[] args) {
        SpringApplication.run(ApiApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
