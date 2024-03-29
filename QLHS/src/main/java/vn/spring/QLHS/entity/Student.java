package vn.spring.QLHS.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name="student")
public class Student {
    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String identifier;
    private String name;
    private Date date;
    private String genter;
    private String nation;
    private String phone;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name="class_id")
    private School school;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="teacher_detail_id")
    private StudentDetail studentDetail;
    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private List<SubjectDetail> subjectDetails;

    public Student() {
    }

    public StudentDetail getStudentDetail() {
        return studentDetail;
    }

    public void setStudentDetail(StudentDetail studentDetail) {
        this.studentDetail = studentDetail;
    }

    public List<SubjectDetail> getSubjectDetails() {
        return subjectDetails;
    }

    public void setSubjectDetails(List<SubjectDetail> subjectDetails) {
        this.subjectDetails = subjectDetails;
    }

    public Student(int id, String identifier, String name, Date date, String genter, String nation, String phone, School school) {
        this.id = id;
        this.identifier = identifier;
        this.name = name;
        this.date = date;
        this.genter = genter;
        this.nation = nation;
        this.phone = phone;
        this.school = school;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getGenter() {
        return genter;
    }

    public void setGenter(String genter) {
        this.genter = genter;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
