<!DOCTYPE html>
<html>
<head>
    <title>Record Expense</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="login-container">

    <h1>Green Basket Retail</h1>
    <p>Record Expense</p>

    <form action="ExpenseServlet" method="post">

    <label>Amount</label>

    <input type="number"
           name="amount"
           min="1"
           step="0.01"
           required>

    <label>Category</label>

    <select name="category" required>

        <option value="">-- Select Category --</option>

        <option>Supplier Payment</option>

        <option>Electricity Bill</option>

        <option>Transport</option>

        <option>Salary</option>

        <option>Maintenance</option>

        <option>Other Expense</option>

    </select>

    <label>Description</label>

    <input type="text"
           name="description"
           minlength="3"
           maxlength="100"
           required>

    <label>Payment Mode</label>

    <select name="paymentMode" required>

        <option value="">-- Select Payment Mode --</option>

        <option>Cash</option>

        <option>UPI</option>

        <option>Card</option>

    </select>

    <label>Date</label>

    <input type="date"
           name="date"
           required>

    <br><br>

    <button type="submit">Save Expense</button>

</form>

    <br>

    <a href="dashboard.jsp">Back to Dashboard</a>

</div>

</body>
</html>