package vn.spring.QLHS.repository;


import org.springframework.stereotype.Repository;
import vn.spring.QLHS.entity.Student;

@Repository
public interface StudentReponsitory {
    public Student studentById(int id);
    public Student updateStudent(Student student);
}
