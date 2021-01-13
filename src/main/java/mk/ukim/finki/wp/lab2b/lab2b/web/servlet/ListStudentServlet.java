package mk.ukim.finki.wp.lab2b.lab2b.web.servlet;

import mk.ukim.finki.wp.lab2b.lab2b.model.Student;
import mk.ukim.finki.wp.lab2b.lab2b.service.CourseService;
import mk.ukim.finki.wp.lab2b.lab2b.service.StudentService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "student-servlet", urlPatterns = "/addStudent")
public class ListStudentServlet extends HttpServlet {
    private final StudentService studentService;
    private final CourseService courseService;
    private final SpringTemplateEngine springTemplateEngine;

    public ListStudentServlet(StudentService studentService, CourseService courseService, SpringTemplateEngine springTemplateEngine) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long courseId = (Long)req.getSession().getAttribute("course");
        WebContext webContext = new WebContext(req,resp, req.getServletContext());
        List<Student> students = studentService.listAll();
        webContext.setVariable("students", students);
        webContext.setVariable("courseId",courseId);
        springTemplateEngine.process("listStudents.html",webContext,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long courseId = Long.parseLong(req.getParameter("course"));
        req.getSession().setAttribute("course",courseId);
        List<Student> students = studentService.listAll();
        WebContext webContext = new WebContext(req,resp, req.getServletContext());
        webContext.setVariable("students", students);
        webContext.setVariable("courseId",courseId);
        springTemplateEngine.process("listStudents.html",webContext,resp.getWriter());

    }
}
