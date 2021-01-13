package mk.ukim.finki.wp.lab2b.lab2b.service;

import mk.ukim.finki.wp.lab2b.lab2b.model.Course;
import mk.ukim.finki.wp.lab2b.lab2b.model.Student;

import java.util.List;

public interface CourseService{
    List<Student> listStudentsByCourse(Long courseId);
    Course addStudentInCourse(String username, Long courseId);
    List<Course> listAllCourses();
    String getNameById(Long courseId);

    Course addCourse(String name, String description, Long teacherId) throws Exception;

    void deleteCourse(Long id);

    Course getCourseById(Long id);
}