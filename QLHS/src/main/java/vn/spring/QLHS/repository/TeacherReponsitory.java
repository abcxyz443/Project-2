package vn.spring.QLHS.repository;


import vn.spring.QLHS.entity.Teacher;

public interface TeacherReponsitory {
    public Teacher teacherById(int id);
    public Teacher updateTeacher(Teacher teacher);
}
