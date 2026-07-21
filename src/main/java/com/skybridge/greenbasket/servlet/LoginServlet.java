package com.skybridge.greenbasket.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
protected void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {

    String username = request.getParameter("username");
    String password = request.getParameter("password");

    response.setContentType("text/html");

    if ("admin".equals(username) && "admin123".equals(password)) {

        response.sendRedirect("dashboard.jsp");

    } else {

        response.getWriter().println("<h2>Login Failed</h2>");
        response.getWriter().println("<p>Invalid Username or Password</p>");

    }
}
}