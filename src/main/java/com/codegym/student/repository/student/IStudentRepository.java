package com.codegym.student.repository.student;

import com.codegym.student.model.Classes;
import com.codegym.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
//    @Query("select c from Classes c where c.id:=?")
    List<Student> getAllByClasses(Classes classes);
}
