package com.example.SimpleAPI.person;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    //    Optional<Person> findPersonByIdIs(Long id);
    @Query("SELECT new com.example.SimpleAPI.person.StatusDTO(count(p),AVG(p.age)) FROM persons p")
    StatusDTO getStat();

}
