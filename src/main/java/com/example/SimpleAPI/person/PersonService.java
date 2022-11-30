package com.example.SimpleAPI.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service

public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
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

    public void updatePerson(Long personId, Person person) {

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

    public void AddPerson() {
        Person Razi = new Person("Razi", "RAZ", 20);

        Person alex = new Person("Alex", "alex", 12);

        personRepository.save(Razi);
        personRepository.save(alex);
    }

    //    public int CountPerson() {
//        return personRepository.findAll().size();
//    }
//
//    public int AverageAgePerson() {
//        List<Person> personList = personRepository.findAll();
//        int Avg_age = 0;
//        for (Person person : personList) {
//            Avg_age += person.getAge();
//        }
//        return Avg_age / personList.size();
//    }
    //   public StatusDTO CountAndAvg() {
//        List<Person> personList = personRepository.findAll();
//        Double Avg_age = 0.0;
//        for (Person person : personList) {
//            Avg_age += person.getAge();
//        }
//        Long personsize= Long.valueOf(personRepository.findAll().size());
//        StatusDTO statusDT = new StatusDTO(personsize, (Avg_age / personList.size()));
//        return statusDT;
//    }
    public StatusDTO CountAndAvg() {
        return personRepository.getStat();
    }

    public List<Person> findPersonWithSorting(String name) {
        return personRepository.findAll(Sort.by(Sort.Direction.ASC, name));
    }

    public Page<Person> findPersonWithPagination(int page, int size) {
        return personRepository.findAll(PageRequest.of(page, size));

    }

    public Page<Person> findPersonWithPaginationAndSorting(int offset, int pageSize, String field) {

        Page<Person> persons = personRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
        return persons;
    }

}
