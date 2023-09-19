package com.example.demo.model.vm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonVm {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private ERoleVm role;
}
