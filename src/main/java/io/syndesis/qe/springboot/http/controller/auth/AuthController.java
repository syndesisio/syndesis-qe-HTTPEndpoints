package io.syndesis.qe.springboot.http.controller.auth;

import io.syndesis.qe.springboot.http.model.Pet;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AuthController {

    private static final String QUERY_PARAM_NAME = "api_key";
    private static final String HEADER_PARAM_NAME = "apikey";
    private static final String BASIC_AUTH_KEY = "authorization";
    private static final String BASIC_USERNAME = "username";
    private static final String BASIC_PASSWORD = "password";

    static {
        PetRepository.addPet(new Pet(1, "Zerik"));
    }

    @GetMapping(path = "/auth/pet/{id}")
    @ResponseBody
    public ResponseEntity<String> getPet(@PathVariable long id,
        @RequestParam Map<String, String> queryParams,
        @RequestHeader Map<String, String> headers) {
        if (isAuthorized(queryParams, headers)) {
            if (PetRepository.getPets().containsKey(id)) {
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
    public String test() {
        return "Success";
    }

    public static String encodeExpectedPasswordAndUsername() {
        String auth = BASIC_USERNAME + ":" + BASIC_PASSWORD;
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.UTF_8));
        return "Basic " + new String(encodedAuth);
    }

    private boolean isKeyValid(String key) {
        log.info("Verifying {}", key);
        return "password".equals(key);
    }

    private boolean isUsernameAndPasswordValid(String basicAuthString) {
        return encodeExpectedPasswordAndUsername().equals(basicAuthString);
    }

    private boolean isAuthorized(Map<String, String> queryParams, Map<String, String> headers) {
        log.info("Query: {}", queryParams);
        log.info("Headers: {}", headers);
        if (queryParams.containsKey(QUERY_PARAM_NAME)) {
            return isKeyValid(queryParams.get(QUERY_PARAM_NAME));
        } else if (headers.containsKey(HEADER_PARAM_NAME)) {
            return isKeyValid(headers.get(HEADER_PARAM_NAME));
        } else if (headers.containsKey(BASIC_AUTH_KEY)) {
            return isUsernameAndPasswordValid(headers.get(BASIC_AUTH_KEY));
        }
        return false;
    }

    @PostMapping(path = "/auth/pet")
    @ResponseBody
    public ResponseEntity<String> addPet(@RequestBody String body,
        @RequestParam Map<String, String> queryParams,
        @RequestHeader Map<String, String> headers) {
        if (isAuthorized(queryParams, headers)) {
            try {
                body = URLDecoder.decode(body, StandardCharsets.UTF_8.toString());
                //Query parameters are also included in the request body
                //So parsing starts from actual start of the JSON object
                if (!queryParams.isEmpty()) {
                    body = body.substring(body.indexOf('{'));
                }
                Pet pet = Pet.fromJSON(body);
                PetRepository.addPet(pet);
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            } catch (Exception e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
            }
        }
        return new ResponseEntity<>("You are not authorized", HttpStatus.UNAUTHORIZED);
    }
}
