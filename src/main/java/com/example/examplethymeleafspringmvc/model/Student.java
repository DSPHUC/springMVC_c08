package com.example.examplethymeleafspringmvc.model;

import com.example.examplethymeleafspringmvc.model.Enum.EGender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    private String name;
    private EGender gender;

    @Min(value = 6)
    @Max(value = 65, message = "khong lon hon 65")
    private int age;

    private String address;

    @ManyToOne
    @JoinColumn(name = "id_classroom")
    private Classroom classroom;




}
