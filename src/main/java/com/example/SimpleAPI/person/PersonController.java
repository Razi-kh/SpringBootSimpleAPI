package com.example.SimpleAPI.person;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/person")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(
            PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getPersons() {
        return personService.getPersons();

    }

    @PostMapping
    public Person registerNewPerson(
            @RequestBody Person person
    ) {
        return personService.addNewPerson(person);
    }

    @DeleteMapping(path = "{personId}")
    public void deletePerson(
            @PathVariable("personId") Long personId) {
        personService.deletePerson(personId);
    }

    @PutMapping(path = "{personId}")
    public void updatePerson(
            @PathVariable("personId") Long personId,
            @RequestBody Person person
    ) {
        personService.updatePerson(personId, person);
    }

//    @GetMapping(path = "count")
//    public int COUNT() {
//        return personService.CountPerson();
//    }
//
//    @GetMapping(path = "avg")
//    public int AverageAgePerson() {
//        return personService.AverageAgePerson();
//    }
    @GetMapping(path = "dto")
    public StatusDTO CountAndAvg() {
        return personService.CountAndAvg();
    }

    @GetMapping(path = "{field}")
    public List<Person> getPersonsWithSort(@PathVariable String field) {
        return personService.findPersonWithSorting(field);
    }

    @GetMapping(path = "pagination")
    public Page<Person> getPersonWithPagination(@RequestParam int page, @RequestParam int size) {
        return personService.findPersonWithPagination(page, size);
    }
}
