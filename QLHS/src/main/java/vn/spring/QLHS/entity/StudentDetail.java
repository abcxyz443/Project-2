package vn.spring.QLHS.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="student_detail")
public class StudentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private int id;
    @Column(name="address", length = 255)
    private String address;
    @Column(name="father_name", length = 255)
    private String nameFather;
    @Column(name="date_father")
    private Date dateFather;
    @Column(name="job_father", length = 255)
    private String jobFather;
    @Column(name="mother_name", length = 255)
    private String nameMother;
    @Column(name="date_mother")
    private Date dateMother;
    @Column(name="job_mother", length = 255)
    private String jobMother;

    public StudentDetail() {
    }

    public StudentDetail(int id, String address, String nameFather, Date dateFather, String jobFather, String nameMother, Date dateMother, String jobMother) {
        this.id = id;
        this.address = address;
        this.nameFather = nameFather;
        this.dateFather = dateFather;
        this.jobFather = jobFather;
        this.nameMother = nameMother;
        this.dateMother = dateMother;
        this.jobMother = jobMother;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNameFather() {
        return nameFather;
    }

    public void setNameFather(String nameFather) {
        this.nameFather = nameFather;
    }

    public Date getDateFather() {
        return dateFather;
    }

    public void setDateFather(Date dateFather) {
        this.dateFather = dateFather;
    }

    public String getJobFather() {
        return jobFather;
    }

    public void setJobFather(String jobFather) {
        this.jobFather = jobFather;
    }

    public String getNameMother() {
        return nameMother;
    }

    public void setNameMother(String nameMother) {
        this.nameMother = nameMother;
    }

    public Date getDateMother() {
        return dateMother;
    }

    public void setDateMother(Date dateMother) {
        this.dateMother = dateMother;
    }

    public String getJobMother() {
        return jobMother;
    }

    public void setJobMother(String jobMother) {
        this.jobMother = jobMother;
    }

    @Override
    public String toString() {
        return "StudentDetail{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", nameFather='" + nameFather + '\'' +
                ", dateFather=" + dateFather +
                ", jobFather='" + jobFather + '\'' +
                ", nameMother='" + nameMother + '\'' +
                ", dateMother=" + dateMother +
                ", jobMother='" + jobMother + '\'' +
                '}';
    }
}
