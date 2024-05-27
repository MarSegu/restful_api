package com.example.demo.service;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<Person> getAllPersons();
    Optional<Person> getPersonById(Long id);
    Person savePerson(Person person);
    Person updatePerson(Long id, Person personDetails);
    void deletePerson(Long id);
    Person patchPerson(Long id, Person personDetails);
}
