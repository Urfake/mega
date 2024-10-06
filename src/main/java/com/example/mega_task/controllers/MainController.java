package com.example.mega_task.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class MainController {
    @GetMapping("/objects")
    private ResponseEntity<String> getObjects()
    {
        final String uri = "https://api.restful-api.dev/objects";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        return ResponseEntity.ok(result);
    }
}
