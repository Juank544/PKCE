package co.com.perficient.pkce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping
    public ResponseEntity<String> getEndpoint(){
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }
}
