package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.PersonDto;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;

@RestController
@RequestMapping("/auth")
public class PersonController {
    @Autowired
    PersonService personService;

    @Autowired
    PersonRepository personRepository;

    @PostMapping(value = "/signup")
    public ResponseEntity<?> addPerson(@RequestBody PersonDto personDto) {
        Long recordedId = personService.addPerson(personDto);
        return ResponseEntity.ok("User registered successfully! User id: " + recordedId);
    }
}
