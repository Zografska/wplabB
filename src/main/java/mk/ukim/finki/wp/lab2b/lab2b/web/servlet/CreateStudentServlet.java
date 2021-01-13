package mk.ukim.finki.wp.lab2b.lab2b.web.servlet;

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

@WebServlet(name = "create-student-servlet", urlPatterns = "/createStudent")
public class CreateStudentServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final StudentService studentService;
    private final CourseService courseService;

    public CreateStudentServlet(SpringTemplateEngine springTemplateEngine, StudentService studentService, CourseService courseService) {
        this.springTemplateEngine = springTemplateEngine;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext webContext = new WebContext(req,resp,req.getServletContext());
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String surname = req.getParameter("surname");
        String password = req.getParameter("password");
        studentService.save(username,password,name,surname);
        req.getSession().setAttribute("username",username);
        resp.sendRedirect("/addStudent");

    }

    //    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        WebContext webContext = new WebContext(req,resp,req.getServletContext());
//        springTemplateEngine.process("createStudent.html",webContext,resp.getWriter());
//    }
}
