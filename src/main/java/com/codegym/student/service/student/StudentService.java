package com.codegym.student.service.student;

import com.codegym.student.model.Classes;
import com.codegym.student.model.Student;
import com.codegym.student.repository.student.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return null;
    }

    @Override
    public void save(Student student) {

    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public List<Student> getAllByClasses(Classes classes) {
        return studentRepository.getAllByClasses(classes);
    }
}

