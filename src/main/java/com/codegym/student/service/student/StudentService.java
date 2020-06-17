package com.codegym.student.service.student;

import com.codegym.student.model.Classes;
import com.codegym.student.model.Student;
import com.codegym.student.repository.IStudentRepository;
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
        Student student = studentRepository.findOne(id);
        if (student != null){
            return student;
        }
        throw new RuntimeException("Không tìm thấy HV có id là "+ id);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void remove(Long id) {
        studentRepository.delete(id);
    }

    @Override
    public List<Student> getAllByClasses(Classes classes) {
        return studentRepository.getAllByClasses(classes);
    }
}

