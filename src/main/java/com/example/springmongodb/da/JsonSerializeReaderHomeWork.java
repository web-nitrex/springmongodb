package com.example.springmongodb.da;

import com.example.springmongodb.entity.JsonFileClass;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class JsonSerializeReaderHomeWork {
    public JsonFileClass read(String url) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        final JsonFileClass jsonFileClass = mapper.readValue(new File(url), JsonFileClass.class);
        return jsonFileClass;
    }
}
