package com.codegym.student.service;

import com.codegym.student.model.Student;

import java.util.List;

public interface IService<T> {
    List<T> findAll();

    T findById(Long id);

    void save(T model);

    void remove(Long id);
}
