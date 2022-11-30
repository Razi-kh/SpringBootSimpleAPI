package com.example.SimpleAPI.configs.seeder;

import com.example.SimpleAPI.person.PersonService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseSeeder {
    private final PersonService personService;

    public DatabaseSeeder(PersonService personService) {
        this.personService = personService;
    }
    @Bean
    public void AddingPerson(){personService.AddPerson();}
}
