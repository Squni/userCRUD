package pl.coderslab.users.servlets;

import pl.coderslab.users.entity.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users/list")
public class UserList extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        request.setAttribute("users", userDao.findAll());
        request.setAttribute("title", "Users list");
        getServletContext().getRequestDispatcher("/user/list.jsp")
                .forward(request, response);
    }
}
