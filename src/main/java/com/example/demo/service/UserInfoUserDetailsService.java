package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.config.UserInfoUserDetails;
import com.example.demo.model.entity.Person;
import com.example.demo.repository.PersonRepository;

@Component
public class UserInfoUserDetailsService implements UserDetailsService{
    @Autowired
    private PersonRepository repository;

    //Database'den gelen sınıf null değilse oluşturduğum sınıfa maple. null ise hata fırlat.
    //Optional null olabilir. Null olma ihtimali olan nesnelerde optional kullanılır.
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        //repositor'de tanımladığım findByName ile database'den ismi çekiyoruz.
        //Bu nesne varsa tipini döndür yoksa kullanıcı bulunamadı hatası döndür.
        Optional<Person> userInfo = repository.findByName(name);
        return userInfo.map(UserInfoUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("User not found" + name));
    }
}
