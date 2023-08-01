package org.shopping.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.shopping.connection.ConnectionDB;
import org.shopping.dao.UserDao;
import org.shopping.model.User;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user-login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String email = request.getParameter("login-email");
            String password = request.getParameter("login-password");

            UserDao userDao = new UserDao(ConnectionDB.getConnection());
            User user = userDao.userLogin(email, password);
            if (user != null) {
                out.print("User Login :)");
                request.getSession().setAttribute("auth", user);
                response.sendRedirect("index.jsp");
            } else {
                out.print("Wrong credentials!");
            }
        }
    }
}
