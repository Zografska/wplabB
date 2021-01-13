package mk.ukim.finki.wp.lab2b.lab2b.repository;

import mk.ukim.finki.wp.lab2b.lab2b.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab2b.lab2b.model.Course;
import mk.ukim.finki.wp.lab2b.lab2b.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepository {
    public List<Course> findAllCourses(){
        return DataHolder.courseList;
    }
    public Course findById(Long courseId){
        return findAllCourses()
                .stream()
                .filter(course -> course.getCourseId().equals(courseId))
                .findFirst()
                .get();
    }
    public List<Student> findAllStudentsByCourse(Long courseId){
        return findById(courseId).getStudents();
    }
        public Course addStudentToCourse(Student student, Course course){
            findAllCourses().removeIf(c-> c.getCourseId().equals(course.getCourseId()));
            course.getStudents().add(student);
            DataHolder.courseList.add(course);
            return course;
        }

    public Course save(Course course) {
        DataHolder.courseList.add(course);
        return course;
    }

    public void delete(Long id) {
        DataHolder.courseList.removeIf(course -> course.getCourseId().equals(id));
    }
}
