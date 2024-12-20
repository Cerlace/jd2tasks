package cerlace.servlet;

import cerlace.dto.StudentDTO;
import cerlace.service.StudentService;
import cerlace.service.StudentServiceImpl;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "infoServlet", value = "/info")
public class InfoServlet extends HttpServlet {
    private static final String FIO = "fio";
    private static final String AGE = "age";
    private static final String STUDENTS = "students";
    private static final String STUDENTS_JSP = "/students.jsp";

    private StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fio = getParam(req, FIO);
        String age = getParam(req, AGE);

        final List<StudentDTO> studentDTOList = studentService.findAll(fio, age);

        req.setAttribute(STUDENTS, studentDTOList);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(STUDENTS_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = getParam(req, "id");
        String action = getParam(req, "action");

        if("delete".equals(action)) {
//            studentService.delete(id);
            System.out.println(id);
        }
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/example2.jsp");
        requestDispatcher.forward(req, resp);
    }

    private String getParam(HttpServletRequest req, String nameField) {
        return Optional.ofNullable(req.getParameter(nameField))
                .filter(StringUtils::isNotBlank)
                .orElse(null);
    }

}
