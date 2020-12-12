package com.javatpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/api/persons")
    public List<Person> getAllNotes() {
        return (List<Person>) personRepository.findAll();
    }

    @PostMapping("api/persons")
    public Person createNote(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @GetMapping("/api/persons/{id}")
    public  Person getNoteById(@PathVariable(value = "id") int personId) throws PersonNotFoundException {
        return personRepository.findById(personId)
                .orElseThrow(() -> new PersonNotFoundException(personId));
    }

    @PutMapping("/api/persons/{id}")
    public Person updateNote(@PathVariable(value = "id") int personId, @RequestBody Person personDetails) throws PersonNotFoundException {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new PersonNotFoundException(personId));
        person.setPersonGender(personDetails.getPersonGender());
        person.setPersonHealth(personDetails.getPersonHealth());
        person.setPersonName(personDetails.getPersonName());

        Person updatedPerson = personRepository.save(person);

        return updatedPerson;
    }

    @DeleteMapping("/api/persons/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable(value = "id") int personId) throws PersonNotFoundException {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new PersonNotFoundException(personId));
        personRepository.delete(person);
        return ResponseEntity.ok().build();
    }
}
