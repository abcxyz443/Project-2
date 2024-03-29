package vn.spring.QLHS.repository.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.spring.QLHS.entity.Teacher;
import vn.spring.QLHS.repository.TeacherReponsitory;

@Repository
public class TeacherReponsitoryImpl implements TeacherReponsitory {
    private EntityManager entityManager;
    @Autowired
    public TeacherReponsitoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Teacher teacherById(int id) {
        String jpql = "Select s from Teacher s where s.id = :t";
        TypedQuery<Teacher> query = this.entityManager.createQuery(jpql, Teacher.class);
        query.setParameter("t", id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public Teacher updateTeacher(Teacher teacher) {
        Teacher teacher1 = entityManager.find(Teacher.class,teacher.getId());
        teacher1.setEmail(teacher.getEmail());
        teacher1.setGenter(teacher.getGenter());
        teacher1.setName(teacher.getName());
        teacher1.setPhone(teacher.getPhone());
        teacher1.getTeacherDetail().setDate(teacher.getTeacherDetail().getDate());
        teacher1.getTeacherDetail().setIdentifier(teacher.getTeacherDetail().getIdentifier());
        teacher1.getTeacherDetail().setInsurance(teacher.getTeacherDetail().getInsurance());
        teacher1.getTeacherDetail().setInsurance(teacher.getTeacherDetail().getNo());
        this.entityManager.persist(teacher1);
        return teacher1;
    }




}
