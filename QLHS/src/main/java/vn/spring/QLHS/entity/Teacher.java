package vn.spring.QLHS.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="teacher")
public class Teacher {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name",length = 255)
    private String name;
    @Column(name="genter",length = 255)
    private String genter;

    @Column(name="phone",length = 255)
    private String phone;

    @Column(name="email",length = 255)
    private String email;

    @OneToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name="teacher_deatail_id")
    private TeacherDetail teacherDetail;
    @OneToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name="class_id")
    private School school;

    @OneToMany(mappedBy = "teacher")
    private List<Subject> subjectList;

    public Teacher() {
    }

    public Teacher(int id, String name, String genter, String phone, String email, TeacherDetail teacherDetail) {
        this.id = id;
        this.name = name;
        this.genter = genter;
        this.phone = phone;
        this.email = email;
        this.teacherDetail = teacherDetail;

    }

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

    public String getGenter() {
        return genter;
    }

    public void setGenter(String genter) {
        this.genter = genter;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TeacherDetail getTeacherDetail() {
        return teacherDetail;
    }

    public void setTeacherDetail(TeacherDetail teacherDetail) {
        this.teacherDetail = teacherDetail;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }
}
