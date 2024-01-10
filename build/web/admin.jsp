<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <h1>Hello admin: ${sessionScope.USER.username}!</h1>
        <form action="Logout" method="post">
            <button type="submit">Logout</button>
        </form>
        <br>
        <form action="/admin/add_staff" method="get">
            <button type="submit">Add Staff</button>
        </form>
    </body>
</html>
