package com.example.examplethymeleafspringmvc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.lang.annotation.Annotation;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "classrooms")
public class Classroom implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Classroom classroom = (Classroom) target;
        String name = classroom.getName();
        if (name.isEmpty()) {
            errors.rejectValue("name","name.isEmpty", "name not empty");
        }
        if (name.length() < 5) {
            errors.rejectValue("name","name.lengthMin","length nam must be greater than or equal to 4");
        }
    }


    //   @Override
    //    public boolean supports(Class<?> clazz) {
    //        return false;
    //    }
    //
    //    @Override
    //    public void validate(Object target, Errors errors) {
    //        Student student = (Student) target;
    //        int age = (student.getAge());
    //        if (age < 6) {
    //            errors.rejectValue("age","age.min");
    //        }
    //    }
}
