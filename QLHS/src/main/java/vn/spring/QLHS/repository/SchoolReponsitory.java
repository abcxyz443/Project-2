package vn.spring.QLHS.repository;

import vn.spring.QLHS.entity.School;
import vn.spring.QLHS.entity.Student;

import java.util.List;

public interface SchoolReponsitory {
    public School schoolById(String id);
    public List<Student> allStudent(String id);
}
