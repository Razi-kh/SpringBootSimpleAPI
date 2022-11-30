package com.example.SimpleAPI.person;

import javax.persistence.*;

@Entity(name = "persons")
public class Person {
    @Id
    @SequenceGenerator(name = "person_sequence", sequenceName = "person_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_sequence")
    private Long id;
    private String fname;
    private String lname;
    private Integer age;

    public Person(Long id, String fname, String lname, Integer age) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
    }

    public Person() {
    }

    public Person(String fname, String lname, Integer age) {
        this.fname = fname;
        this.lname = lname;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", Fname=" + fname + ", Lname=" + lname + ", age=" + age + '}';
    }

}
