package com.example.examplethymeleafspringmvc.repository;

import com.example.examplethymeleafspringmvc.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ClassroomRepository extends JpaRepository<Classroom,Long> {
}
