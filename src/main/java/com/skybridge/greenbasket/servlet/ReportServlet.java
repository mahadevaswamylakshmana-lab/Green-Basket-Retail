package com.skybridge.greenbasket.servlet;

import com.skybridge.greenbasket.util.DBConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        double totalIncome = 0;
        double totalExpense = 0;

        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT IFNULL(SUM(amount),0) FROM income");

            if (rs.next()) {
                totalIncome = rs.getDouble(1);
            }

            rs.close();

            rs = stmt.executeQuery("SELECT IFNULL(SUM(amount),0) FROM expense");

            if (rs.next()) {
                totalExpense = rs.getDouble(1);
            }

            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        double balance = totalIncome - totalExpense;

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Daily Report</title>");
        out.println("<link rel='stylesheet' href='css/style.css'>");
        out.println("</head>");
        out.println("<body>");

        out.println("<div class='login-container'>");

        out.println("<h1>Green Basket Retail</h1>");
        out.println("<h2>Today's Report</h2>");
        out.println("<hr>");

        out.println("<h3>Total Income : ₹ " + totalIncome + "</h3>");
        out.println("<h3>Total Expense : ₹ " + totalExpense + "</h3>");
        out.println("<h3>Balance : ₹ " + balance + "</h3>");

        out.println("<hr>");
        out.println("<a href='dashboard.jsp'>Back to Dashboard</a>");

        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}