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

@WebServlet("/TransactionsServlet")
public class TransactionsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Daily Transactions</title>");
        out.println("<link rel='stylesheet' href='css/style.css'>");
        out.println("</head>");
        out.println("<body>");

        out.println("<div class='login-container'>");
        out.println("<h1>Green Basket Retail</h1>");
        out.println("<h2>Daily Transactions</h2>");

        out.println("<table border='1' width='100%' cellpadding='8'>");
        out.println("<tr>");
        out.println("<th>Date</th>");
        out.println("<th>Type</th>");
        out.println("<th>Category</th>");
        out.println("<th>Amount</th>");
        out.println("</tr>");

        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement()) {

            ResultSet income = stmt.executeQuery(
                    "SELECT income_date, category, amount FROM income ORDER BY income_date DESC");

            while (income.next()) {

                out.println("<tr>");
                out.println("<td>" + income.getDate("income_date") + "</td>");
                out.println("<td>Income</td>");
                out.println("<td>" + income.getString("category") + "</td>");
                out.println("<td>" + income.getDouble("amount") + "</td>");
                out.println("</tr>");
            }

            income.close();

            ResultSet expense = stmt.executeQuery(
                    "SELECT expense_date, category, amount FROM expense ORDER BY expense_date DESC");

            while (expense.next()) {

                out.println("<tr>");
                out.println("<td>" + expense.getDate("expense_date") + "</td>");
                out.println("<td>Expense</td>");
                out.println("<td>" + expense.getString("category") + "</td>");
                out.println("<td>" + expense.getDouble("amount") + "</td>");
                out.println("</tr>");
            }

            expense.close();

        } catch (Exception e) {

            out.println("<tr>");
            out.println("<td colspan='4'>");
            out.println(e.getMessage());
            out.println("</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("<br>");
        out.println("<a href='dashboard.jsp'>Back to Dashboard</a>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}