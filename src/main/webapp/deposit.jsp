<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deposit Money</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header bg-warning text-white">
                    <h3 class="card-title text-center">Deposit Money</h3>
                </div>
                <div class="card-body">
                    <form action="DepositServlet" method="post">
                        <div class="mb-3">
                            <label for="amount" class="form-label">Amount:</label>
                            <input type="number" id="amount" name="amount" class="form-control" required>
                        </div>
                        <div class="d-grid">
                            <button type="submit" class="btn btn-warning">Deposit</button>
                        </div>
                    </form>

                    <% if (request.getParameter("error") != null) { %>
                    <div class="alert alert-danger mt-3" role="alert">
                        Deposit failed. Please try again!
                    </div>
                    <% } %>

                    <!-- Back to Dashboard Button -->
                    <div class="d-grid mt-3">
                        <a href="dashboard" class="btn btn-secondary">Back to Dashboard</a>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
