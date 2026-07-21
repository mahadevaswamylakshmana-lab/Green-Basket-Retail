package com.skybridge.greenbasket.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/IncomeServlet")
public class IncomeServlet extends HttpServlet {

    @Override
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

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Income Saved</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h2>Income Saved Successfully</h2>");
        out.println("<hr>");

        out.println("<p><strong>Amount:</strong> " + amount + "</p>");
        out.println("<p><strong>Category:</strong> " + category + "</p>");
        out.println("<p><strong>Description:</strong> " + description + "</p>");
        out.println("<p><strong>Payment Mode:</strong> " + paymentMode + "</p>");
        out.println("<p><strong>Date:</strong> " + date + "</p>");

        out.println("<br>");
        out.println("<a href='dashboard.jsp'>Back to Dashboard</a>");

        out.println("</body>");
        out.println("</html>");
    }
}