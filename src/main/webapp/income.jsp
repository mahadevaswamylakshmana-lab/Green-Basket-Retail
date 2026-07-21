<!DOCTYPE html>
<html>
<head>
    <title>Green Basket Retail - Record Income</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="login-container">

    <h1>Green Basket Retail</h1>
    <p>Record Income</p>

    <form action="IncomeServlet" method="post">

        <label>Amount</label>
        <input type="number"
               name="amount"
               placeholder="Enter Amount"
               required>

        <label>Category</label>
        <select name="category" required>
            <option value="">-- Select Category --</option>
            <option value="Milk Sales">Milk Sales</option>
            <option value="Vegetable Sales">Vegetable Sales</option>
            <option value="Grocery Sales">Grocery Sales</option>
            <option value="Other Income">Other Income</option>
        </select>

        <label>Description</label>
        <input type="text"
               name="description"
               placeholder="Enter Description"
               required>

        <label>Payment Mode</label>
        <select name="paymentMode" required>
            <option value="">-- Select Payment Mode --</option>
            <option value="Cash">Cash</option>
            <option value="UPI">UPI</option>
            <option value="Card">Card</option>
        </select>

        <label>Date</label>
        <input type="date"
               name="date"
               required>

        <br><br>

        <button type="submit">Save Income</button>

    </form>

    <br>

    <a href="dashboard.jsp">Back to Dashboard</a>

</div>

</body>
</html>