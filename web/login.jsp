<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h2>Login Page</h2>
        <% String error = (String)session.getAttribute("InvalidUser");
        if (error != null && !error.isEmpty()) {
            session.removeAttribute("InvalidUser");
        %>
        <p id="errorMessage" style="color: red;"><%= error %></p>
        <% 
            } 
        %>

        <form action="login" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
            <br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
            <br>
            <button type="submit">Login</button>
        </form>

        <p>Don't have an account? <a href="register">Register here</a></p>
    </body>
</html>
