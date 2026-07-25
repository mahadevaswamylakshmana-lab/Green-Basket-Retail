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

        String username=request.getParameter("username");
        String password=request.getParameter("password");

        response.setContentType("text/html;charset=UTF-8");

        try{

            Connection con=DBConnection.getConnection();

            String sql="SELECT * FROM users WHERE username=? AND password=?";

            PreparedStatement ps=con.prepareStatement(sql);

            ps.setString(1,username);

            ps.setString(2,password);

            ResultSet rs=ps.executeQuery();

            if(rs.next()){

                HttpSession session=request.getSession();

                session.setAttribute("username",username);

                response.sendRedirect("dashboard.jsp");

            }else{

                response.getWriter().println("<h2>Invalid Username or Password</h2>");
                response.getWriter().println("<br>");
                response.getWriter().println("<a href='index.jsp'>Back</a>");

            }

            rs.close();
            ps.close();
            con.close();

        }catch(Exception e){

            e.printStackTrace();

        }

    }

}