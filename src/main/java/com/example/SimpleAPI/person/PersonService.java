package com.example.SimpleAPI.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service

public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(
            PersonRepository personRepository
    ) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public Person addNewPerson(Person person) {
        // Optional<Person> personOptional = personRepository.findById(person.getId());
       return personRepository.save(person);
    }

    public void deletePerson(Long personId) {
        personRepository.findById(personId);
        boolean exists = personRepository.existsById(personId);
        if (!exists) {
            throw new IllegalStateException("student with id" + personId + "does not exists");
        }
        personRepository.deleteById(personId);
    }

    public void updatePerson(
            Long personId,
            Person person
    ) {

        Person oldperson = personRepository.findById(personId).orElseThrow(() -> new IllegalStateException("person with id" + personId + "does not exists"));

        if (person.getFname() != null && person.getFname().length() > 0 && !Objects.equals(oldperson.getFname(), person.getFname())) {
            oldperson.setFname(person.getFname());
        }
        if (person.getLname() != null && person.getLname().length() > 0 && !Objects.equals(oldperson.getLname(), person.getLname())) {
            oldperson.setLname(person.getLname());
        }
        if (person.getAge() > 0 && !Objects.equals(oldperson.getAge(), person.getAge())) {
            oldperson.setAge(person.getAge());
        }
        personRepository.save(oldperson);

    }

    public void AddPerson(){
        Person Razi = new Person( "Razi", "RAZ", 20);

        Person alex = new Person("Alex", "alex", 12);

        personRepository.save(Razi);
        personRepository.save(alex);
    }
}