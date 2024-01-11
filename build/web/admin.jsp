<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <h1>Hello admin: ${sessionScope.NAME}!</h1>
        <form action="Logout" method="post">
            <button type="submit">Logout</button>
        </form>
        <br>

        <h3>All Staffs</h3>
        <form action="/admin/add_staff" method="get">
            <button type="submit">Add Staff</button>
        </form>

        <table border="1px">
            <tr>
                <th>Username</th>
                <th>Name</th>
                <th>Department</th>
                <th>Salary</th>  
                <th>Action</th>
            </tr>
            <c:forEach var="staff" items="${requestScope.STAFFS}">
                <tr>
                    <td>${staff.username}</td>
                    <td>${staff.name}</td>
                    <td>${staff.department}</td>
                    <td>${staff.salary}</td>
                    <td>
                        <button type="button" onclick="removeStaff('${staff.username}', '${staff.name}')">Remove</button>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <script>
            try {
                function removeStaff(username, name) {
                    if (confirm("Remove staff: " + name + "?")) {
                        window.location = "/admin/remove_staff?username=" + username;
                    }
                }
            } catch (e) {
                console.error(e);
            }
        </script>
    </body>
</html>
