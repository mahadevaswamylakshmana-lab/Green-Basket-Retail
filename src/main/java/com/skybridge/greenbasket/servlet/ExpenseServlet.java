package com.skybridge.greenbasket.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ExpenseServlet")
public class ExpenseServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String amount = request.getParameter("amount");
        String category = request.getParameter("category");
        String description = request.getParameter("description");
        String paymentMode = request.getParameter("paymentMode");
        String date = request.getParameter("date");

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Expense Saved Successfully</h2>");
        out.println("<hr>");
        out.println("<p>Amount : " + amount + "</p>");
        out.println("<p>Category : " + category + "</p>");
        out.println("<p>Description : " + description + "</p>");
        out.println("<p>Payment Mode : " + paymentMode + "</p>");
        out.println("<p>Date : " + date + "</p>");
        out.println("<br>");
        out.println("<a href='dashboard.jsp'>Back to Dashboard</a>");
        out.println("</body></html>");
    }
}