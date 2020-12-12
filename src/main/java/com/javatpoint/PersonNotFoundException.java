package com.javatpoint;

public class PersonNotFoundException extends Exception {
    private int person_id;
    public PersonNotFoundException(int person_id) {
        super(String.format("Person is not found with id: '%s'", person_id));
    }
}
