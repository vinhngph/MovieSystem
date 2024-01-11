<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Staff Page</title>
    </head>
    <body>
        <h1>Good day ${sessionScope.NAME}</h1>
        <table border="1px">
            <tr>
                <th>Movie ID</th>
                <th>Title</th>
                <th>Director</th>
                <th>Category</th>  
                <th>Age Require</th>
                <th>Actors</th>
            </tr>
            <c:forEach var="movie" items="${requestScope.MOVIES}">
                <tr>
                    <td>${movie.id}</td>
                    <td>${movie.title}</td>
                    <td>${movie.director}</td>
                    <td>${movie.category}</td>
                    <td>${movie.age_require}</td>
                    <td>${movie.actor_names}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
