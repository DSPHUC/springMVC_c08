package com.example.examplethymeleafspringmvc.repository;

import com.example.examplethymeleafspringmvc.model.Enum.EGender;
import com.example.examplethymeleafspringmvc.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findStudentByGender(EGender gender);

    @Query(value = "SELECT s FROM Student s ORDER BY s.age ASC ")
    List<Student> findAllOrderByAgeAsc();

}
