package com.codegym.student.controller;


import com.codegym.student.model.Classes;
import com.codegym.student.model.Student;
import com.codegym.student.service.classes.IClassesService;
import com.codegym.student.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/classes")
public class ClassesController {
    @Autowired
    private IClassesService classesService;

    @Autowired
    private IStudentService studentService;

    @GetMapping("/{id}/students")
    public ModelAndView showStudentByClassId(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/classes/list");
        Classes classes = classesService.findById(id);
        List<Student> students = studentService.getAllByClasses(classes);
        modelAndView.addObject("list", students);
        return modelAndView;
    }
}
