package mk.ukim.finki.wp.lab2b.lab2b.service;

import mk.ukim.finki.wp.lab2b.lab2b.model.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    public List<Teacher> findAll();
    public Teacher findTeacher(Long id) throws Exception;
}
