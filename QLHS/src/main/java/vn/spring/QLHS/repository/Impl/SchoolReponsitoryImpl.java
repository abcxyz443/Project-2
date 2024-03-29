package vn.spring.QLHS.repository.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.spring.QLHS.entity.School;
import vn.spring.QLHS.entity.Student;
import vn.spring.QLHS.repository.SchoolReponsitory;

import java.util.List;

@Repository
public class SchoolReponsitoryImpl implements SchoolReponsitory {
    private EntityManager entityManager;

    @Autowired
    public SchoolReponsitoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public School schoolById(String id) {
        return this.entityManager.find(School.class, id);
    }

    @Override
    public List<Student> allStudent(String id) {
        String jpql = "Select s from Student s where s.school.id = :t";
        TypedQuery<Student> query = entityManager.createQuery(jpql,Student.class);
        query.setParameter("t",id);
        return query.getResultList();
    }
}
