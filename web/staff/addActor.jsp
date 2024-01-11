<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add actor</title>
    </head>
    <body>
        <h1>Add actor</h1>
        <form action="add_actor" method="post">
            <label>Name</label>
            <input type="text" name="name" required><br>

            <input type="submit" value="Add actor">
        </form>
    </body>
</html>
