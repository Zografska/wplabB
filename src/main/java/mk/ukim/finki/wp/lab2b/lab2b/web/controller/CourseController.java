package mk.ukim.finki.wp.lab2b.lab2b.web.controller;

import mk.ukim.finki.wp.lab2b.lab2b.model.Course;
import mk.ukim.finki.wp.lab2b.lab2b.model.Student;
import mk.ukim.finki.wp.lab2b.lab2b.model.Teacher;
import mk.ukim.finki.wp.lab2b.lab2b.service.CourseService;
import mk.ukim.finki.wp.lab2b.lab2b.service.StudentService;
import mk.ukim.finki.wp.lab2b.lab2b.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value ="/courses")
public class CourseController {
    private final CourseService courseService;
    private final TeacherService teacherService;
    private final StudentService studentService;
    public CourseController(CourseService courseService, TeacherService teacherService, StudentService studentService) {
        this.courseService = courseService;
        this.teacherService = teacherService;
        this.studentService = studentService;
    }

    @GetMapping
    public String getCoursesPage(@RequestParam(required = false) String error, Model model){
        List<Course> courseList = courseService.listAllCourses();
        List<Teacher> teacherList = teacherService.findAll();

        model.addAttribute("teachers", teacherList);
        model.addAttribute("courses", courseList);
        return "listCourses.html";
    }
    @PostMapping("/add")
    public String saveCourse(@RequestParam String name, @RequestParam String description, @RequestParam Long teacherId) throws Exception {
        courseService.addCourse(name,description,teacherId);
    return "redirect:/courses";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id)
    {
        courseService.deleteCourse(id);
        return "redirect:/courses";
    }
    @GetMapping("/details/{id}")
    public String getCourseDetails(@PathVariable Long id, Model model)
    {
        Course course = courseService.getCourseById(id);
        List<Student> studentList = courseService.listStudentsByCourse(id);

        model.addAttribute("courseName", course.getName());
        model.addAttribute("students", studentList);
        return "studentsInCourse.html";
    }
}
