//package com.codegym.student.repository.student;
//
//import com.codegym.student.model.Student;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.util.List;
//import javax.persistence.TypedQuery;
//@Transactional
//public class StudentRepository implements IStudentRepository {
//    @PersistenceContext
//    private EntityManager em;
//
//    @Override
//    public List<Student> findAll() {
//        TypedQuery<Student> query = em.createQuery("select c from Student c", Student.class);
//        return query.getResultList();
//    }
//
//    @Override
//    public Student findById(Long id) {
//        return null;
//    }
//
//    @Override
//    public void save(Student model) {
//
//    }
//
//    @Override
//    public void remove(Long id) {
//
//    }
//}
