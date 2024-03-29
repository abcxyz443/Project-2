package vn.spring.QLHS.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name", length = 255)
    private String name;
    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name="teacher_id")
    private Teacher teacher;
    @OneToMany(mappedBy = "subject")
    private List<SubjectDetail> subjectDetails;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<SubjectDetail> getSubjectDetails() {
        return subjectDetails;
    }

    public void setSubjectDetails(List<SubjectDetail> subjectDetails) {
        this.subjectDetails = subjectDetails;
    }
}
