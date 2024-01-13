<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Cinema</title>
    </head>
    <body>
        <h1>Add Cinema</h1>

        <form action="add_cinema" method="post">
            <label for="name">Cinema Name:</label>
            <input type="text" id="name" name="name" required>
            <br>

            <label for="location">Location:</label>
            <input type="text" id="location" name="location" required>
            <br>

            <button type="submit">Add Cinema</button>
        </form>
    </body>
</html>
