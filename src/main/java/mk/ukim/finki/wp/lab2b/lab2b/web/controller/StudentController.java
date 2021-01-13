package mk.ukim.finki.wp.lab2b.lab2b.web.controller;

import mk.ukim.finki.wp.lab2b.lab2b.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    String getStudentsPage(Model model){
        model.addAttribute("students",studentService.listAll());
        return "listStudents.html";
    }
}
/*
TODO:
 -Create student
 -List students
 -Add Student to a course
 */