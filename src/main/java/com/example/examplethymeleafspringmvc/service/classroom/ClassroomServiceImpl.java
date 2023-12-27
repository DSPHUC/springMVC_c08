package com.example.examplethymeleafspringmvc.service.classroom;

import com.example.examplethymeleafspringmvc.model.Classroom;
import com.example.examplethymeleafspringmvc.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClassroomServiceImpl implements IClassroomService{
    @Autowired
    private ClassroomRepository classroomRepository;
    @Override
    public List<Classroom> findAll() {
        return (List<Classroom>) classroomRepository.findAll();
    }

    @Override
    public Classroom findById(Long id) {
        return classroomRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Classroom classroom) {
        classroomRepository.save(classroom);
    }

    @Override
    public void delete(Long id) {
    }
}
