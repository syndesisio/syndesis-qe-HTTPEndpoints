package com.github.avano.springboot.http.controller.auth;


import com.github.avano.springboot.http.model.Pet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Controller
@Slf4j
public class AuthController {

    private static final String QUERY_PARAM_NAME = "api_key";
    private static final String HEADER_PARAM_NAME = "apikey";

    static {
        PetRepository.addPet(new Pet(1, "Zerik"));
    }

    @GetMapping(path = "/auth/pet/{id}")
    @ResponseBody
    public ResponseEntity<String> getPet(@PathVariable long id,
                                         @RequestParam Map<String, String> queryParams,
                                         @RequestHeader Map<String, String> headers){
        if (isAuthorized(queryParams, headers)){
            if (PetRepository.getPets().containsKey(id)){
                return new ResponseEntity<>(PetRepository.getPet(id).toJSON(), HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity<>("No pet", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("You are not authorized", HttpStatus.UNAUTHORIZED);
        }
    }


    @GetMapping(path = "/auth/pet")
    @ResponseBody
    public String test(){
        return "Success";
    }

    private boolean isKeyValid(String key){
        log.info("Verifying {}", key);
        return "password".equals(key);
    }


    private boolean isAuthorized(Map<String, String> queryParams, Map<String, String> headers){
        log.info("Query: {}", queryParams);
        log.info("Headers: {}", headers);
        if (queryParams.containsKey(QUERY_PARAM_NAME)){
            return isKeyValid(queryParams.get(QUERY_PARAM_NAME));
        } else if (headers.containsKey(HEADER_PARAM_NAME)){
            return isKeyValid(headers.get(HEADER_PARAM_NAME));
        }
        return false;
    }

    @PostMapping(path = "/auth/pet")
    @ResponseBody
    public ResponseEntity<String> addPet(@RequestBody String body,
                                 @RequestParam Map<String, String> queryParams,
                                 @RequestHeader Map<String, String> headers){
        if (isAuthorized(queryParams, headers)){
            try {
                body = URLDecoder.decode(body, StandardCharsets.UTF_8.toString());
                //Query parameters are also included in the request body
                //So parsing starts from actual start of the JSON object
                if (!queryParams.isEmpty()){
                    body = body.substring(body.indexOf('{'));
                }
                Pet pet = Pet.fromJSON(body);
                PetRepository.addPet(pet);
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            } catch (Exception e){
                return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
            }
        }
        return new ResponseEntity<>("You are not authorized", HttpStatus.UNAUTHORIZED);
    }

}
