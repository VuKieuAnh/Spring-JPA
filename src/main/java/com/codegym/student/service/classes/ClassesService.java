package com.codegym.student.service.classes;

import com.codegym.student.model.Classes;
import com.codegym.student.repository.student.IClassesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClassesService implements IClassesService {
    @Autowired
    private IClassesRepository classesRepository;

    @Override
    public List<Classes> findAll() {
        return classesRepository.findAll();
    }

    @Override
    public Classes findById(Long id) {
        return classesRepository.findOne(id);
    }

    @Override
    public void save(Classes model) {

    }

    @Override
    public void remove(Long id) {

    }
}
