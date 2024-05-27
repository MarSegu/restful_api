package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public Person updatePerson(Long id, Person personDetails) {
        Person person = personRepository.findById(id).orElseThrow();
        person.setFirstName(personDetails.getFirstName());
        person.setLastName(personDetails.getLastName());
        person.setAge(personDetails.getAge());
        return personRepository.save(person);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    public Person patchPerson(Long id, Person personDetails) {
        Person person = personRepository.findById(id).orElseThrow();
        if (personDetails.getFirstName() != null) {
            person.setFirstName(personDetails.getFirstName());
        }
        if (personDetails.getLastName() != null) {
            person.setLastName(personDetails.getLastName());
        }
        if (personDetails.getAge() != 0) {
            person.setAge(personDetails.getAge());
        }
        return personRepository.save(person);
    }

}
