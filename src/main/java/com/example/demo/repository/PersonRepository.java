package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    //Optional<Person> findByUsername(String username);
    Optional<Person> findByName(String name);

    Boolean existsByName(String name);

    Boolean existsByEmail(String email);

    // @Query("select c from User c")
    // List<Person> getAllUsers();

    Optional<Person> findById(int Id);
}
