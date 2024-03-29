package vn.spring.QLHS.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="class")
public class School {
    @Id
    @Column(name="id")
    private String id;
    @Column(name="name", length = 255)
    private String name;

    @ManyToOne(cascade = {CascadeType.DETACH,
                          CascadeType.MERGE,
                          CascadeType.PERSIST,
                          CascadeType.REFRESH,
    })
    @JoinColumn(name="grade_id")
    private Grade grade;
    @OneToOne(mappedBy = "school")
    private Teacher teacher;
    @OneToMany(mappedBy = "school", fetch = FetchType.EAGER)
    private List<Student> students;
    public School() {
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public School(String id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
    public int studentNumber(){
        int n = this.getStudents().size();
        return n;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
