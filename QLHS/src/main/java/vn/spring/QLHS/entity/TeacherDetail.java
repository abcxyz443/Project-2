package vn.spring.QLHS.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="teacher_detail")
public class TeacherDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="identifier", length = 255)
    private String identifier;
    @Column(name="date")
    private Date date;
    @Column(name="no",length = 255)
    private String no;
    @Column(name="nation",length = 255)
    private String nation;
    @Column(name="address",length = 255)
    private String address;
    @Column(name="insurance",length = 255)
    private String insurance;

    public TeacherDetail() {
    }

    public TeacherDetail(int id, String identifier, Date date, String no, String nation, String address, String insurance) {
        this.id = id;
        this.identifier = identifier;
        this.date = date;
        this.no = no;
        this.nation = nation;
        this.address = address;
        this.insurance = insurance;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }
}
