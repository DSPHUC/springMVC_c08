package com.example.examplethymeleafspringmvc.controller;

import com.example.examplethymeleafspringmvc.model.Classroom;
import com.example.examplethymeleafspringmvc.service.classroom.IClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/classrooms")
public class ClassroomController {
    @Autowired
    private IClassroomService classroomService;

    @GetMapping
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("/classrooms/list");
        modelAndView.addObject("classrooms", classroomService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView save() {
        ModelAndView modelAndView = new ModelAndView("/classrooms/form");
        modelAndView.addObject("classroom", new Classroom());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView save(@Valid Classroom classroom, BindingResult bindingResult) {
        ModelAndView modelAndView;
        new Classroom().validate(classroom, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            modelAndView = new ModelAndView("/classrooms/form");

            return modelAndView;
        }
        modelAndView = new ModelAndView("redirect:/classrooms");
        classroomService.save(classroom);
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateGet(@PathVariable Long id) {
        Classroom classroom = classroomService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/classrooms/form");

        modelAndView.addObject("classroom", classroom);

        return modelAndView;
    }

    @PostMapping("/update/{id}")
    public String updatePost(@PathVariable Long id,
                             @ModelAttribute Classroom classroom) {
        classroom.setId(id);
        classroomService.save(classroom);
        return "redirect:/classrooms";
    }

}
