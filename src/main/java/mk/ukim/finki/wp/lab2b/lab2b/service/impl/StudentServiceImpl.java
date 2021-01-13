package mk.ukim.finki.wp.lab2b.lab2b.service.impl;

import mk.ukim.finki.wp.lab2b.lab2b.model.Student;
import mk.ukim.finki.wp.lab2b.lab2b.repository.StudentRepository;
import mk.ukim.finki.wp.lab2b.lab2b.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> listAll() {
        return studentRepository.findAllStudents();
    }

    @Override
    public List<Student> searchByNameOrSurname(String text) {
        return studentRepository.findAllByNameOrSurname(text);
    }

    @Override
    public Student save(String username, String password, String name, String surname) {
        return studentRepository.addStudentToList(new Student(username, password, name, surname));
    }

    @Override
    public Student findStudentByUsername(String username) {
        return studentRepository.findStudentByUsername(username);
    }
}
