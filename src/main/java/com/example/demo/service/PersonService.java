package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;

import com.example.demo.model.dto.ERoleDto;
import com.example.demo.model.dto.GenderDto;
import com.example.demo.model.dto.PersonDto;
import com.example.demo.model.entity.ERole;
import com.example.demo.model.entity.Gender;
import com.example.demo.model.entity.Person;
import com.example.demo.model.vm.PersonVm;
import com.example.demo.repository.PersonRepository;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    ;
    @Autowired
    ModelMapper modelMapper;

    public Authentication getAuth() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth;
    }

    public Long addPerson(PersonDto personDto) {
        personDto.setPassword(passwordEncoder.encode(personDto.getPassword()));
        Person person = modelMapper.map(personDto, Person.class);

        ERoleDto roleDto = personDto.getRole();
        ERole role = modelMapper.map(roleDto, ERole.class);
        person.setRoles(role);

        GenderDto genderDto = personDto.getGender();
        Gender gender = modelMapper.map(genderDto, Gender.class);
        person.setGender(gender);

        person = personRepository.save(person);
        PersonVm personVm = modelMapper.map(person, PersonVm.class);
        return personVm.getId();
    }

    
}
