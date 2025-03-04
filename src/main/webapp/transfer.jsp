<%--
  Created by IntelliJ IDEA.
  User: nziza
  Date: 3/4/25
  Time: 9:14 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Transfer Money</title>
</head>
<body>
<h2>Transfer Money</h2>
<form action="TransferServlet" method="post">
    <label for="recipient">Recipient Account:</label>
    <input type="text" name="recipient" required><br>
    <label for="amount">Amount:</label>
    <input type="number" name="amount" required><br>
    <input type="submit" value="Transfer">
</form>
</body>
</html>
