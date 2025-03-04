<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.ResourceBundle, com.atm.util.LanguageUtil" %>
<%
    String lang = (String) session.getAttribute("lang");
    if (lang == null) lang = "en"; // Default to English
    ResourceBundle bundle = LanguageUtil.getBundle(lang);
%>
<html>
<head>
    <title><%= bundle.getString("title") %></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header bg-primary text-white">
                    <h3 class="card-title text-center"><%= bundle.getString("title") %></h3>
                </div>
                <div class="card-body">
                    <!-- Language Selection Form -->
                    <form action="login" method="get" class="mb-3">
                        <div class="mb-3">
                            <label for="language" class="form-label"><%= bundle.getString("language") %></label>
                            <select id="language" name="language" class="form-select" onchange="this.form.submit()">
                                <option value="en" <%= lang.equals("en") ? "selected" : "" %>>English</option>
                                <option value="es" <%= lang.equals("es") ? "selected" : "" %>>Español</option>
                                <option value="fr" <%= lang.equals("fr") ? "selected" : "" %>>Français</option>
                            </select>
                        </div>
                    </form>

                    <!-- Login Form -->
                    <form action="login" method="post">
                        <input type="hidden" name="language" value="<%= lang %>">
                        <div class="mb-3">
                            <label for="username" class="form-label"><%= bundle.getString("username") %></label>
                            <input type="text" id="username" name="username" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label"><%= bundle.getString("password") %></label>
                            <input type="password" id="password" name="password" class="form-control" required>
                        </div>
                        <div class="d-grid">
                            <button type="submit" class="btn btn-primary"><%= bundle.getString("login") %></button>
                        </div>
                    </form>
                    <% if (request.getAttribute("error") != null) { %>
                    <div class="alert alert-danger mt-3" role="alert">
                        <%= bundle.getString("error") %>
                    </div>
                    <% } %>
                    <div class="mt-3 text-center">
                        <a href="registerPage" class="text-decoration-none"><%= bundle.getString("register") %></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>