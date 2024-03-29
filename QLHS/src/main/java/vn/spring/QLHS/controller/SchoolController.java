package vn.spring.QLHS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.spring.QLHS.repository.SchoolReponsitory;
import vn.spring.QLHS.entity.School;

@Controller
@RequestMapping("/class")
public class SchoolController {

    private SchoolReponsitory schoolReponsitory;
    @Autowired
    public SchoolController(SchoolReponsitory schoolReponsitory) {
        this.schoolReponsitory = schoolReponsitory;
    }
    @GetMapping("/detail")
    public String classDetail(Model model, @RequestParam("id")String id){
        School school = this.schoolReponsitory.schoolById(id);
        model.addAttribute("class",school);
        return "class/classDetail";
    }
    @GetMapping("/listStudent")
    public String listStudent(Model model, @RequestParam("id")String id){
        School school = this.schoolReponsitory.schoolById(id);
        model.addAttribute("class",school );
        return "/class/listStudent";
    }
    @GetMapping("/manage")
    public String listStudent(@RequestParam("id")String id, Model model){
        School school = this.schoolReponsitory.schoolById(id);
        model.addAttribute("class",school);
        return "/class/pointManager";
    }
}
