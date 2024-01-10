<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Customer</title>
    </head>
    <body>
        <h2>Register Customer</h2>
        <% String error = (String)session.getAttribute("ExistedUser");
        if (error != null && !error.isEmpty()) {
            session.removeAttribute("ExistedUser");
        %>
        <p id="errorMessage" style="color: red;"><%= error %></p>
        <% 
            } 
        %>

        <form action="register" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
            <br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
            <br>
            <button type="submit">Next</button>
        </form>

        <p>Already have an account? <a href="login">Login here</a></p>
    </body>
</html>
