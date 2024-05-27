package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*

Below is an example of a RESTful Spring Boot API that includes all
HTTP methods (GET, POST, PUT, DELETE, and PATCH). This example will
use a simple entity called Person.
 */

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @Autowired
    private PersonServiceImpl personService;

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person personDetails) {
        return ResponseEntity.ok(personService.updatePerson(id, personDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Person> patchPerson(@PathVariable Long id, @RequestBody Person personDetails) {
        return ResponseEntity.ok(personService.patchPerson(id, personDetails));
    }

}