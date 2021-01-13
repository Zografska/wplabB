package mk.ukim.finki.wp.lab2b.lab2b.service.impl;

import mk.ukim.finki.wp.lab2b.lab2b.model.Teacher;
import mk.ukim.finki.wp.lab2b.lab2b.repository.TeacherRepository;
import mk.ukim.finki.wp.lab2b.lab2b.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository repository;

    public TeacherServiceImpl(TeacherRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Teacher> findAll() {
        //TODO:
        return repository.listAll();
    }

    @Override
    public Teacher findTeacher(Long id) throws Exception {
        Optional<Teacher> teacher = repository.findById(id);
        if (teacher.isEmpty())
            throw new Exception("Teacher not found");
        return teacher.get();
    }
}
