package mk.ukim.finki.wp.lab2b.lab2b.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class Course {
    Long courseId;
    String name;
    String description;
    Teacher teacher;
    List<Student> students;
    public Course(String name, String description, Teacher teacher)
    {
        this.name = name;
        this.description = description;
        Random r  = new Random();
        this.courseId = r.nextLong();
        this.students = new ArrayList<>();
    }
}

