package com.example.web.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id ;
    private  String firstname;
    private String lastName;

    private String email;


}
