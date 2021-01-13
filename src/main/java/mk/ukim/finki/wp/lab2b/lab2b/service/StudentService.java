package mk.ukim.finki.wp.lab2b.lab2b.service;

import mk.ukim.finki.wp.lab2b.lab2b.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> listAll();
    List<Student> searchByNameOrSurname(String text);
    Student save(String username, String password, String name, String surname);
    Student findStudentByUsername(String username);
}