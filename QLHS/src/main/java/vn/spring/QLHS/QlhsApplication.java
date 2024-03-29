package vn.spring.QLHS;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.spring.QLHS.repository.SchoolReponsitory;
import vn.spring.QLHS.repository.StudentReponsitory;
import vn.spring.QLHS.repository.TeacherReponsitory;
import vn.spring.QLHS.entity.School;
import vn.spring.QLHS.entity.Student;
import vn.spring.QLHS.entity.SubjectDetail;

import java.util.List;

@SpringBootApplication
public class QlhsApplication {

	public static void main(String[] args) {
		SpringApplication.run(QlhsApplication.class, args
		);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentReponsitory studentReponsitory, TeacherReponsitory teacherReponsitory, SchoolReponsitory schoolReponsitory){
		return runner->{
			findStudentById(studentReponsitory);
			findSchoolById(schoolReponsitory);
		};
	}
	public void findStudentById(StudentReponsitory studentReponsitory){
		Student student = studentReponsitory.studentById(1);
		System.out.println(student.getStudentDetail());
	}
	public void findSchoolById(SchoolReponsitory schoolReponsitory){
		School school = schoolReponsitory.schoolById("1");
		List<Student> students = school.getStudents();
		for(Student student : students){
			System.out.println(student.getId());
			for(SubjectDetail subjectDetail: student.getSubjectDetails()){
				System.out.println(subjectDetail);
				System.out.println(subjectDetail.average());
			}
		}
	}
}
