package vn.spring.QLHS.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.spring.QLHS.repository.TeacherReponsitory;
import vn.spring.QLHS.entity.Teacher;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    private TeacherReponsitory teacherReponsitory;

    @Autowired
    public TeacherController(TeacherReponsitory teacherReponsitory) {
        this.teacherReponsitory = teacherReponsitory;
    }
    @GetMapping("/detail")
    public String teacherDetail(@RequestParam("id")Integer id, Model model){
        Teacher teacher = this.teacherReponsitory.teacherById(id);
        model.addAttribute("teacher",teacher);
        return "/teacher/teacherDetail";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("teacher") Teacher teacher){
        this.teacherReponsitory.updateTeacher(teacher);
        return "redirect:/teacher/detail?id=1";
    }
    @GetMapping("/update")
    public String update(@RequestParam("id") Integer id,Model model){
        Teacher teacher = this.teacherReponsitory.teacherById(id);
        model.addAttribute("teacher",teacher);
        return "/teacher/teacherForm";
    }
}
