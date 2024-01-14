<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <link rel="stylesheet" href="css/home.css">
    </head>

    <body>
        <div class="auth-form">

            <div class="auth-form__header">
                <h1 class="auth-form__header">Hello admin: ${sessionScope.NAME}!</h1>
            </div>

            <form action="../Logout" method="post">
                <div class="auth-form__logout">
                    <button class="auth-form__logout" type="submit">Logout</button>
                </div>
            </form>

            <div class="auth-form__title">
                <h3 class="auth-form__title">All Staffs:</h3>

                <form action="add_staff" method="get">
                    <button class="auth-form__title" type="submit">Add Staff</button>
                </form>
            </div>

            <div class="auth-form__table">
                <table class="auth-form__table">
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
                                <div class="btn__remove">
                                    <button class="btn__remove" type="button"
                                            onclick="removeStaff('${staff.username}', '${staff.name}')">Remove</button>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>

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