package com.example.api.api_file_example;

import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;

@Service
public class ApiServiceWather {
    public String getWeather(){
        String url = "https://api.open-meteo.com/v1/forecast?" +
                "latitude=35&" +
                "longitude=139&" +
                "hourly=temperature";
        // Configuracao do proxy
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        Proxy proxy = new Proxy(Proxy.Type.HTTP,
                new InetSocketAddress("proxy.br.bosch.com",80));
        factory.setProxy(proxy);

        //Criando ResTemplate com proxy
        RestTemplate restTemplate = new RestTemplate(factory);

        // Fazendo a requisicao
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return response.getBody();
        } catch(RestClientException e){
            System.out.println("Erro ao consumir API: "+e.getMessage());
            return "Erro na requisição";
        }
    }
}
