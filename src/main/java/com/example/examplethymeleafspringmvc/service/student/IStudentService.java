package com.example.examplethymeleafspringmvc.service.student;

import com.example.examplethymeleafspringmvc.model.Enum.EGender;
import com.example.examplethymeleafspringmvc.model.Student;
import com.example.examplethymeleafspringmvc.service.IGeneralService;

import java.util.List;

public interface IStudentService extends IGeneralService<Student, Long> {
    List<Student> findAllByGender(EGender nameGender);

    List<Student> sortByAgeAsc();
}
