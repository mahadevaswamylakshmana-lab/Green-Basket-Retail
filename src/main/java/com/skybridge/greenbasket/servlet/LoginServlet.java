package com.skybridge.greenbasket.servlet;

import com.skybridge.greenbasket.util.DBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            System.out.println("========== LOGIN REQUEST ==========");
            System.out.println("Username : " + username);

            con = DBConnection.getConnection();

            String sql = "SELECT * FROM users WHERE username=? AND password=?";

            ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("Login Successful.");

                HttpSession session = request.getSession();

                session.setAttribute("username", username);

                response.sendRedirect("dashboard.jsp");

            } else {

                System.out.println("Invalid Username or Password.");

                response.getWriter().println("<h2>Invalid Username or Password</h2>");
                response.getWriter().println("<br>");
                response.getWriter().println("<a href='index.jsp'>Back</a>");

            }

        } catch (Exception e) {

            System.out.println("========== LOGIN ERROR ==========");
            e.printStackTrace();

            response.getWriter().println("<h2>Application Error</h2>");
            response.getWriter().println("<pre>");
            e.printStackTrace(response.getWriter());
            response.getWriter().println("</pre>");

        } finally {

            try {
                if (rs != null)
                    rs.close();
            } catch (Exception ignored) {
            }

            try {
                if (ps != null)
                    ps.close();
            } catch (Exception ignored) {
            }

            try {
                if (con != null)
                    con.close();
            } catch (Exception ignored) {
            }

        }

    }

}