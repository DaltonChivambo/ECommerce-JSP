package org.shopping.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/log-out")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try(PrintWriter out = response.getWriter()){
            if (request.getSession().getAttribute("auth") != null){
                request.getSession().removeAttribute("auth");
                response.sendRedirect("login.jsp");
            }else {
                response.sendRedirect("index.jsp");
            }
        }
    }

}
