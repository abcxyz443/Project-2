package vn.spring.QLHS.entity;

import jakarta.persistence.*;

@Entity
@Table(name="subject_detail")
public class SubjectDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="point1")
    private float point1;
    @Column(name="point2")
    private float point2;
    @Column(name="point3")
    private float point3;
    @ManyToOne(cascade ={
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name="subject_id")
    private Subject subject;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name="student_id")
    private Student student;

    public SubjectDetail() {
    }

    public SubjectDetail(int id, float point1, float point2, float point3, Subject subject, Student student) {
        this.id = id;
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.subject = subject;
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPoint1() {
        return point1;
    }

    public void setPoint1(float point1) {
        this.point1 = point1;
    }

    public float getPoint2() {
        return point2;
    }

    public void setPoint2(float point2) {
        this.point2 = point2;
    }

    public float getPoint3() {
        return point3;
    }

    public void setPoint3(float point3) {
        this.point3 = point3;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    public float average(){
        return (point1+point2+point3*2)/4;
    }

    @Override
    public String toString() {
        return "SubjectDetail{" +
                "id=" + id +
                ", point1=" + point1 +
                ", point2=" + point2 +
                ", point3=" + point3 +
                '}';
    }
}
