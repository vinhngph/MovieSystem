<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Staff Page</title>
        <link rel="stylesheet" href="css/addStaff.css">
    </head>
    <body>
        <div class="modal">
            <div class="modal__overlay"></div>

            <div class="modal__body">
                <div class="auth-form">
                    <div class="auth-form__header">
                        <h1 class="auth-form__header">Add Staff</h1>
                    </div>
                    <% String error = (String)session.getAttribute("ExistedUser");
                    if (error != null && !error.isEmpty()) {
                        session.removeAttribute("ExistedUser");
                    %>
                    <p id="errorMessage" style="color: red;"><%= error %></p>
                    <% 
                        } 
                    %>
                    <form action="/admin/add_staff" method="post">
                        <div class="auth-form__form">    
                            <label for="username">Username:</label>
                            <input type="text" id="username" name="username" required>

                            <label for="password">Password:</label>
                            <input type="password" id="password" name="password" required>

                            <label for="name">Name:</label>
                            <input type="text" id="name" name="name" required>

                            <label for="department">Department:</label>
                            <input type="text" id="department" name="department" required>

                            <label for="salary">Salary:</label>
                            <input type="number" id="salary" name="salary" required>
                        </div>
                        <div class="auth-form__submit">
                            <button type="submit">Add Staff</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
