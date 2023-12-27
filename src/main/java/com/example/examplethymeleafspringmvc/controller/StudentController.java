package com.example.examplethymeleafspringmvc.controller;

import com.example.examplethymeleafspringmvc.model.Classroom;
import com.example.examplethymeleafspringmvc.model.Enum.EGender;
import com.example.examplethymeleafspringmvc.model.Student;
import com.example.examplethymeleafspringmvc.service.classroom.IClassroomService;
import com.example.examplethymeleafspringmvc.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IClassroomService classroomService;

    @GetMapping
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("/students/list");
        modelAndView.addObject("students", studentService.findAll());
        return modelAndView;
    }

    @GetMapping("{id}/viewID")
    public ModelAndView viewId(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/students/IdView");
        modelAndView.addObject("students", studentService.findById(id));
        return modelAndView;
    }

    @GetMapping("/gender")
    public ModelAndView filter(@RequestParam("g") EGender gender) {
        ModelAndView modelAndView = new ModelAndView("/students/list");
        modelAndView.addObject("students", studentService.findAllByGender(gender));
        return modelAndView;
    }


    @GetMapping("/create")
    public ModelAndView save() {
        ModelAndView modelAndView = new ModelAndView("/students/form");
        modelAndView.addObject("student", new Student());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView save(@Valid @ModelAttribute Student student, BindingResult bindingResult) {
        ModelAndView modelAndView ;
        if (bindingResult.hasFieldErrors()) {
            modelAndView = new ModelAndView("/students/form");
            return modelAndView;
        }
        studentService.save(student);
        modelAndView = new ModelAndView("redirect:/students");
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateGet(@PathVariable Long id) {
        Student student = studentService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/students/form");

        modelAndView.addObject("student", student);

        return modelAndView;
    }

    @PostMapping("/update/{id}")
    public String updatePost(@PathVariable Long id,
                             @ModelAttribute Student student) {
        student.setId(id);
        studentService.save(student);
        return "redirect:/students";
    }

    @GetMapping("/sort")
    public ModelAndView sort() {
        ModelAndView modelAndView = new ModelAndView("/students/list");
        modelAndView.addObject("students", studentService.sortByAgeAsc());
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        studentService.delete(id);
        return "redirect:/students";
    }

    @ModelAttribute("classrooms")
    public Iterable<Classroom> listProvinces() {
        return classroomService.findAll();
    }
}
