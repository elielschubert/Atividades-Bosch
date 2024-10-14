package com.example.api.api_file_example;

import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ApiServiceMovies {

    public static void main(String[] args){
        System.out.println("hello World");
        Scanner input = new Scanner(System.in).useDelimiter(" ");
        System.out.println("Digite o nome do filme: ");
        String filme = URLEncoder.encode(input.nextLine(), StandardCharsets.UTF_8);
        String endereco = "https://www.omdbapi.com/?t="+filme+"&apikey=5f77a6a2";

        try{
            //Configurando o cliente HTTP com proxy
            HttpClient client = HttpClient.newBuilder()
                    .proxy(ProxySelector.of(new
                            InetSocketAddress("proxy.br.bosch.com", 80)))
                    .authenticator(new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(
                                    "usuario",
                                    "senha".toCharArray());
                        }
                    })

                    .build();

            // Criando a requisicao HTTP
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();

            // Enviando a requisicao e obtendo a resposta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Imprimir a resposta
            System.out.println("Resposta da API: "+response.body());

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
