package com.skybridge.greenbasket.servlet;

import com.skybridge.greenbasket.util.DBConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ExpenseServlet")
public class ExpenseServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String amount = request.getParameter("amount");
        String category = request.getParameter("category");
        String description = request.getParameter("description");
        String paymentMode = request.getParameter("paymentMode");
        String date = request.getParameter("date");

        // ===============================
        // Server Side Validation
        // ===============================

        if (amount == null || amount.isBlank()
                || category == null || category.isBlank()
                || description == null || description.isBlank()
                || paymentMode == null || paymentMode.isBlank()
                || date == null || date.isBlank()) {

            response.getWriter().println("<h2>Invalid Input!</h2>");
            response.getWriter().println("<p>All fields are required.</p>");
            response.getWriter().println("<br>");
            response.getWriter().println("<a href='expense.jsp'>Go Back</a>");
            return;
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PrintWriter out = response.getWriter();

        try {

            connection = DBConnection.getConnection();

            String sql = "INSERT INTO expense(amount, category, description, payment_mode, expense_date) VALUES (?, ?, ?, ?, ?)";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setDouble(1, Double.parseDouble(amount));
            preparedStatement.setString(2, category);
            preparedStatement.setString(3, description);
            preparedStatement.setString(4, paymentMode);
            preparedStatement.setString(5, date);

            int rowsInserted = preparedStatement.executeUpdate();

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Expense Saved</title>");
            out.println("</head>");
            out.println("<body>");

            if (rowsInserted > 0) {

                out.println("<h2>Expense Saved Successfully!</h2>");

            } else {

                out.println("<h2>Failed to Save Expense!</h2>");

            }

            out.println("<br><br>");
            out.println("<a href='expense.jsp'>Add Another Expense</a>");
            out.println("<br><br>");
            out.println("<a href='dashboard.jsp'>Back to Dashboard</a>");

            out.println("</body>");
            out.println("</html>");

        } catch (Exception e) {

            e.printStackTrace();

            out.println("<h2>Error : " + e.getMessage() + "</h2>");

        } finally {

            try {

                if (preparedStatement != null)
                    preparedStatement.close();

                if (connection != null)
                    connection.close();

            } catch (Exception e) {

                e.printStackTrace();

            }

        }
    }
}