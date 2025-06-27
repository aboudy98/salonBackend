package com.vite.Model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    

    private String fullName;

    private String email;

    private String phone; 

    private String role;

    private LocalDate createdAt;

    private LocalDate updatedAt;
}
