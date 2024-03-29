package vn.spring.QLHS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.spring.QLHS.repository.StudentReponsitory;
import vn.spring.QLHS.entity.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
    private StudentReponsitory studentReponsitory;

    @Autowired
    public StudentController(StudentReponsitory studentReponsitory) {
        this.studentReponsitory = studentReponsitory;
    }
    @GetMapping("/detail")
    public String studentDetail(Model model, @RequestParam("id")Integer id){
        Student student = this.studentReponsitory.studentById(id);
        model.addAttribute("student",student);
        return "/student/studentDetail";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("student")Student student){
        this.studentReponsitory.updateStudent(student);
        return "redirect:/student/detail?id="+student.getId();
    }
    @GetMapping("/update")
    public String studentUpdate(Model model, @RequestParam("id")Integer id){
        Student student = this.studentReponsitory.studentById(id);
        model.addAttribute("student",student);
        return "/student/studentForm";
    }
    @GetMapping("/teacher")
    public String teacherDetail(Model model, @RequestParam("id")Integer id){
        Student student = this.studentReponsitory.studentById(id);
        model.addAttribute("student", student);
        return "/student/teacherDetail";
    }
}
