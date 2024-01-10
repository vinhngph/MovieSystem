<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Customer Information</title>
    </head>
    <body>
        <h1>Hello ${sessionScope.USER.username}</h1>

        <form action="/customer/information" method="post">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
            <br>

            <label for="phone_number">Phone Number:</label>
            <input type="number" id="phone_number" name="phone_number" required>
            <br>

            <label for="age">Age:</label>
            <input type="number" id="age" name="age" required>
            <br>

            <button type="submit">Register</button>
        </form>
    </body>
</html>
