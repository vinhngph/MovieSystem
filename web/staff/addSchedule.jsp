<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Schedule Insert Page</title>
    </head>
    <body>
        <h1>Schedule Insert</h1>

        <form action="add_schedule" method="POST">
            <label for="movie_id">Movie:</label>
            <select id="movie_id" name="movie_id" required>
                <c:forEach var="movie" items="${requestScope.MOVIES}">
                    <option value="${movie.id}">${movie.title}</option>
                </c:forEach>
            </select>

            <label for="cinema_id">Cinema:</label>
            <select id="cinema_id" name="cinema_id" required>
                <c:forEach var="cinema" items="${requestScope.CINEMAS}">
                    <option value="${cinema.id}">${cinema.name}</option>
                </c:forEach>
            </select>

            <label for="date">Date:</label>
            <input type="date" id="date" name="date" required>

            <label for="quantity">Quantity:</label>
            <input type="number" id="quantity" name="quantity" required>

            <button type="submit">Insert Schedule</button>
        </form>
    </body>
</html>
