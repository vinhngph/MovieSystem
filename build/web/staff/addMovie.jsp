<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Add Movie</title>
    </head>
    <body>
        <h2>Add Movie</h2>
        <form action="/staff/add_movie" method="post">
            <label>Title:</label>
            <input type="text" name="title" required><br>

            <label>Director:</label>
            <input type="text" name="director" required><br>

            <label>Category:</label>
            <input type="text" name="category" required><br>

            <label>Age Requirement:</label>
            <input type="number" name="ageRequire" required><br>

            <label>Actors:</label>
            <select multiple="multiple" name="actors" size="5" required>
                <c:forEach var="actor" items="${requestScope.ACTORS}">
                    <option value="${actor.id}">${actor.name}</option>
                </c:forEach>
            </select><br>
            <input type="submit" value="Add Movie">
        </form>
    </body>
</html>
