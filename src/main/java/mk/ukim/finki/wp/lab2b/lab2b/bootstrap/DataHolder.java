package mk.ukim.finki.wp.lab2b.lab2b.bootstrap;

import lombok.Getter;
import mk.ukim.finki.wp.lab2b.lab2b.model.Course;
import mk.ukim.finki.wp.lab2b.lab2b.model.Student;
import mk.ukim.finki.wp.lab2b.lab2b.model.Teacher;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
@Getter
public class DataHolder {
    public static List<Student> studentList = new ArrayList<>();
    public static List<Course> courseList = new ArrayList<>();
    public static List<Teacher> teacherList= new ArrayList<>();

    @PostConstruct
    public void init(){
Random random = new Random();
      Teacher teacher = new Teacher(random.nextLong(),"Medro","Koko");
      teacherList.add(teacher);
      Student student = new Student("ex23","ex","Smex","Smekerka");
      Student student1 =new Student("alex23","az","Aleksandra","Zografska");
    studentList.add(student);
    studentList.add(student1);
    studentList.add(new Student("grevka","gr","greshka","Smeshka"));
    Course course = new Course("Veshtacka Inteligencija","Voved vo veshtackata inteligencija", teacher);
    course.getStudents().add(student);
    course.getStudents().add(student1);
    courseList.add(course);
    courseList.add(new Course("Web Progamming","time for a little Java bud :P",teacher));
  }
}
