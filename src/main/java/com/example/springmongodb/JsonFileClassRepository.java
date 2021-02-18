package com.example.springmongodb;

import com.example.springmongodb.entity.JsonFileClass;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JsonFileClassRepository extends MongoRepository<JsonFileClass,String> {
}
