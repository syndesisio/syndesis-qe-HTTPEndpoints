package io.syndesis.qe.springboot.http.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Pet {

    static final ObjectMapper mapper = new ObjectMapper();

    public Pet(){}

    public Pet(long id, String name){
        this.id = id;
        this.name = name;
    }

    private long id;
    private String category;
    private String name;
    private String[] photoUrls;
    private String status;

    public String toJSON(){
        try {
            return mapper.writeValueAsString(this);
        } catch (Exception e){
            return "{}";
        }
    }

    public static Pet fromJSON(String JSON){
        log.info("Trying to parse {} ", JSON);
        try {
            return mapper.readValue(JSON, Pet.class);
        } catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
    }

}
