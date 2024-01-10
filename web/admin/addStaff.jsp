<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Staff Page</title>
    </head>
    <body>
        <h1>Add Staff</h1>
        <% String error = (String)session.getAttribute("ExistedUser");
        if (error != null && !error.isEmpty()) {
            session.removeAttribute("ExistedUser");
        %>
        <p id="errorMessage" style="color: red;"><%= error %></p>
        <% 
            } 
        %>
        <form action="/admin/add_staff" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
            <br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
            <br>

            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
            <br>
            <label for="department">Department:</label>
            <input type="text" id="department" name="department" required>
            <br>
            <label for="salary">Salary:</label>
            <input type="number" id="salary" name="salary" required>
            <br>

            <button type="submit">Add Staff</button>
        </form>
    </body>
</html>
