package com.example.springmongodb;

import com.example.springmongodb.da.JsonSerializeReaderHomeWork;
import com.example.springmongodb.entity.JsonFileClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringmongodbApplication implements CommandLineRunner {

    @Autowired
    private JsonFileClassRepository repository;

    @Autowired
    JsonSerializeReaderHomeWork jsonSerializeReaderHomeWork;

    public static void main(String[] args) {
        SpringApplication.run(SpringmongodbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        String SOURCE_FILE = "homework.parameters.json";

        System.out.println("Read data from file source JSON file" + SOURCE_FILE + "\n");
        JsonFileClass jsonData = jsonSerializeReaderHomeWork.read(SOURCE_FILE);

        repository.deleteAll();
        repository.save(jsonData);

        for(JsonFileClass dataFromMongoDB : repository.findAll())
        {
            System.out.println(dataFromMongoDB);
        }
    }
}
