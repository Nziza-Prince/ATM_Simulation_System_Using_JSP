<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    if (session.getAttribute("user") == null) {
        response.sendRedirect("index.jsp"); // Redirect to login if not logged in
    }
    // Prevent caching
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Expires", "0");
%>
<html>
<head>
    <title>ATM Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card">
                <div class="card-header bg-info text-white">
                    <h3 class="card-title text-center">Welcome to ATM</h3>
                </div>
                <div class="card-body">
                    <h1 class="text-center">Hello, ${sessionScope.user.username}!</h1>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item"><a href="withdrawPage" class="text-decoration-none">Withdraw Money</a></li>
                        <li class="list-group-item"><a href="depositPage" class="text-decoration-none">Deposit Money</a></li>
                        <li class="list-group-item"><a href="balance" class="text-decoration-none">Check Balance</a></li>
                    </ul>
                    <div class="d-grid mt-3">
                        <a href="logout" class="btn btn-danger" onclick="return confirm('Are you sure you want to logout?');">Logout</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script>
    (function() {
        window.history.forward();
    })();

    window.onload = function() {
        if (window.history.replaceState) {
            window.history.replaceState(null, null, window.location.href);
        }
    };
</script>

</body>
</html>