package com.codegym.student.controller;


import com.codegym.student.model.Classes;
import com.codegym.student.model.Student;
import com.codegym.student.service.classes.IClassesService;
import com.codegym.student.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
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

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView shownFomCreate() {
        ModelAndView mav = new ModelAndView("classes/newclass");
        mav.addObject("newClass", new Classes());
        return mav;
    }

    @RequestMapping(value = "/createClasses", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Classes createClasses(@RequestBody Classes classes) {
        classesService.save(classes);
        return classes;
    }

    @PostMapping("/create")
    public ResponseEntity<Classes> create(@RequestBody Classes classes) {
        classesService.save(classes);
        return new ResponseEntity<>(classes, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Classes> edit(@RequestBody Classes classes, @PathVariable Long id){
        Classes classesFind = classesService.findById(id);
        if(classesFind != null){
            classes.setId(id);
            classesService.save(classes);
            return new ResponseEntity<>(classes, HttpStatus.OK);
        }
        return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView("/classes/list");
        List<Classes> classes = classesService.findAll();
        modelAndView.addObject("list", classes);
        return modelAndView;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Classes> delete(@PathVariable Long id){
        Classes classesFind = classesService.findById(id);
        if(classesFind != null){
            classesService.remove(id);
            return new ResponseEntity<>(classesFind, HttpStatus.OK);
        }
        return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
    }






}
