package com.codegym.student.service.student;

import com.codegym.student.model.Classes;
import com.codegym.student.model.Student;
import com.codegym.student.service.IService;

import java.util.List;

public interface IStudentService extends IService<Student> {
    List<Student> getAllByClasses(Classes classes);
}
