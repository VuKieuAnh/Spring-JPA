package com.codegym.student.controller;


import com.codegym.student.model.Student;
import com.codegym.student.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/student")
public class HomeController {

    @Autowired
    private IStudentService studentService;

    @GetMapping()
    public ModelAndView home(){
        List<Student> studentList = studentService.findAll();
        return new ModelAndView("home", "list", studentList);
    }
}
