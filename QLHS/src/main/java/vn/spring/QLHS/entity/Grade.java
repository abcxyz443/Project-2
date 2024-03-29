package vn.spring.QLHS.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="grade")
public class Grade {
    @Id
    @Column(name="id")
    private String id;
    @Column(name="name", length = 255)
    private String name;

    @OneToMany(mappedBy = "grade")
    private List<School> schools;


    public Grade() {
    }

    public Grade(String id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
