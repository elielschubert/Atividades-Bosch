package com.example.api.api_file_example;

import com.google.gson.Gson;

public class JsonExample {
    public static void main(String[] args){
        // Serializando um objeto Java para JSON
        Person person = new Person("Marcelo", 45);
        Gson gson = new Gson();
        String json = gson.toJson(person);
        System.out.println("JSON: "+json);

        // Desserializando JSON para objeto Java
        String jsonResonse = "{\"name\":\"John\",\"age\":30}";
        Person deserializedPerson = gson.fromJson(jsonResonse, Person.class);
        System.out.println("Nome: "+deserializedPerson.getName());

    }
}

class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
