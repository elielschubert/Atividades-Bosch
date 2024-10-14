package com.example.api.api_file_example;

import org.springframework.stereotype.Service;

import java.awt.image.BufferedImageFilter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class FileService {
    public void saveDataToFile(String data){
        try{
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("data.txt"));
            writer.write(data);
            writer.close();
            System.out.println("Dados salvos com sucesso:");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: "+e.getMessage());
        }
    }
}
