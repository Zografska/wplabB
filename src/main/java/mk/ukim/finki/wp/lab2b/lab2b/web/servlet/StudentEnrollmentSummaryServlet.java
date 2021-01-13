package mk.ukim.finki.wp.lab2b.lab2b.web.servlet;

import mk.ukim.finki.wp.lab2b.lab2b.model.Course;
import mk.ukim.finki.wp.lab2b.lab2b.model.Student;
import mk.ukim.finki.wp.lab2b.lab2b.service.CourseService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "student-enrollment-servlet", urlPatterns = "/studentEnrollmentSummary")
public class StudentEnrollmentSummaryServlet extends HttpServlet {
    private final CourseService courseService;
    private final SpringTemplateEngine springTemplateEngine;


    public StudentEnrollmentSummaryServlet(CourseService courseService, SpringTemplateEngine springTemplateEngine) {
        this.courseService = courseService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long courseId = (Long)req.getSession().getAttribute("course");
        String username=req.getParameter("username");
        courseService.addStudentInCourse(username,courseId);
        WebContext webContext = new WebContext(req,resp, req.getServletContext());

        List<Student> students = courseService.listStudentsByCourse(courseId);
        webContext.setVariable("students", students);
        webContext.setVariable("courseName",courseService.getNameById(courseId));
        springTemplateEngine.process("studentsInCourse.html",webContext,resp.getWriter());
    }
}
