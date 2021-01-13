package mk.ukim.finki.wp.lab2b.lab2b.repository;


import mk.ukim.finki.wp.lab2b.lab2b.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab2b.lab2b.model.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TeacherRepository {
    public List<Teacher> listAll(){
        return DataHolder.teacherList;
    }

    public Optional<Teacher> findById(Long id) {
        return DataHolder.teacherList.stream().filter(teacher -> teacher.getId().equals(id)).findFirst();
    }
}
