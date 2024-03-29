package vn.spring.QLHS.repository.Impl;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.spring.QLHS.entity.Student;
import vn.spring.QLHS.repository.StudentReponsitory;

@Repository
public class StudentReponsitoryImpl implements StudentReponsitory {

    private EntityManager entityManager;

    @Autowired
    public StudentReponsitoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Student studentById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    @Transactional
    public Student updateStudent(Student student) {
        Student student1 = entityManager.find(Student.class, student.getId());
        student1.setName(student.getName());
        student1.setDate(student.getDate());
        student1.setGenter(student.getGenter());
        student1.setIdentifier(student.getIdentifier());
        student1.setPhone(student.getPhone());
        student1.setNation(student.getNation());
        student1.getStudentDetail().setNameFather(student.getStudentDetail().getNameFather());
        student1.getStudentDetail().setDateFather(student.getStudentDetail().getDateFather());
        student1.getStudentDetail().setJobFather(student.getStudentDetail().getJobFather());
        student1.getStudentDetail().setNameMother(student.getStudentDetail().getNameMother());
        student1.getStudentDetail().setDateMother(student.getStudentDetail().getDateMother());
        student1.getStudentDetail().setJobMother(student.getStudentDetail().getJobMother());
        entityManager.persist(student1);
        return student1;
    }
}
