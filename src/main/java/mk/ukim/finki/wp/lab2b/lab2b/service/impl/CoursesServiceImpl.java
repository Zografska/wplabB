package mk.ukim.finki.wp.lab2b.lab2b.service.impl;

import mk.ukim.finki.wp.lab2b.lab2b.model.Course;
import mk.ukim.finki.wp.lab2b.lab2b.model.Student;
import mk.ukim.finki.wp.lab2b.lab2b.model.Teacher;
import mk.ukim.finki.wp.lab2b.lab2b.repository.CourseRepository;
import mk.ukim.finki.wp.lab2b.lab2b.service.CourseService;
import mk.ukim.finki.wp.lab2b.lab2b.service.StudentService;
import mk.ukim.finki.wp.lab2b.lab2b.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final StudentService studentService;
    private final TeacherService teacherService;

    public CoursesServiceImpl(CourseRepository courseRepository,
                              StudentService studentService, TeacherService teacherService) {
        this.courseRepository = courseRepository;
        this.studentService = studentService;

        this.teacherService = teacherService;
    }

    @Override
    public List<Student> listStudentsByCourse(Long courseId) {
        return courseRepository.findAllStudentsByCourse(courseId);
    }

    @Override
    public Course addStudentInCourse(String username, Long courseId) {
        return courseRepository
                .addStudentToCourse(studentService.findStudentByUsername(username)
                        ,courseRepository.findById(courseId));
    }

    @Override
    public List<Course> listAllCourses() {
        return courseRepository.findAllCourses();
    }

    @Override
    public String getNameById(Long courseId) {
        return listAllCourses().stream().filter(course1 -> course1.getCourseId().equals(courseId)).findFirst().get().getName();
    }

    @Override
    public Course addCourse(String name, String description, Long teacherId) throws Exception {
        Teacher teacher = teacherService.findTeacher(teacherId);
        Course course = new Course(name, description,teacher);
        courseRepository.save(course);
        return course;
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.delete(id);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id);
    }
}
