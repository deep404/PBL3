package com.javatpoint;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    private int id;
    private String personName;
    private String personGender;
    private String personHealth;

    public Person() {
        super();
        this.id = 0;
        this.personName = "";
        this.personGender = "";
        this.personHealth = "";
    }
    public Person(int id, String personName, String personGender, String personHealth) {
        super();
        this.id = id;
        this.personName = personName;
        this.personGender = personGender;
        this.personHealth = personHealth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonGender() {
        return personGender;
    }

    public void setPersonGender(String personGender) {
        this.personGender = personGender;
    }

    public String getPersonHealth() {
        return personHealth;
    }

    public void setPersonHealth(String personHealth) {
        this.personHealth = personHealth;
    }
}
