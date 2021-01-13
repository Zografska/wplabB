package mk.ukim.finki.wp.lab2b.lab2b.repository;

import mk.ukim.finki.wp.lab2b.lab2b.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab2b.lab2b.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    public List<Student> findAllStudents(){
        return DataHolder.studentList;
    }
    public List<Student> findAllByNameOrSurname(String text){
        return findAllStudents().stream()
                .filter(student -> text.contains(student.getName())
                        || text.contains(student.getSurname()))
                .collect(Collectors.toList());
    }
    public Student findStudentByUsername(String username){
        return findAllStudents().stream()
                .filter(student -> student.getUsername().equals(username))
                .findFirst()
                .get();
    }
    public Student addStudentToList(Student student){
        findAllStudents().removeIf(student1 -> student1.getUsername().equals(student.getUsername()));
        findAllStudents().add(student);
        return student;
    }
}
