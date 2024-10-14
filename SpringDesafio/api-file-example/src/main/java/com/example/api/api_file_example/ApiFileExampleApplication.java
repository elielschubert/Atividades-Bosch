package com.example.api.api_file_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiFileExampleApplication implements CommandLineRunner {

	@Autowired
	private ApiServiceWather apiServiceWather;

	@Autowired
	private FileService fileService;

	public static void main(String[] args) {
		SpringApplication.run(ApiFileExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		String weatherData = apiServiceWather.getWeather();
		System.out.println("Dados da API"+ weatherData);

		// Salvar dados no arquivo
		fileService.saveDataToFile(weatherData);
	}

}
