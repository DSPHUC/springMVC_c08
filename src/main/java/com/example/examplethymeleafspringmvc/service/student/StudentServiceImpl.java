package com.example.examplethymeleafspringmvc.service.student;

import com.example.examplethymeleafspringmvc.model.Enum.EGender;
import com.example.examplethymeleafspringmvc.model.Student;
import com.example.examplethymeleafspringmvc.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public List<Student> findAll() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return  studentRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }



    @Override
    public void delete(Long id) {
        Student student = findById(id);
        studentRepository.delete(student);
    }

    @Override
    public List<Student> findAllByGender(EGender gender) {
        return studentRepository.findStudentByGender(gender);
    }

    @Override
    public List<Student> sortByAgeAsc() {
        return studentRepository.findAllOrderByAgeAsc();
    }
}
