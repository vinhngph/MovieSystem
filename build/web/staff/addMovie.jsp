<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Add Movie</title>
        <link rel="stylesheet" href="css/addMovie.css">
    </head>
    <body>
        <div class="modal">
            <div class="modal__overlay"></div>
            <div class="modal__body">
                <div class="auth-form">
                    <h1>Add Movie</h1>
                    <form action="/staff/add_movie" method="post">
                        <div class="auth-form__input">
                            <label >Title:</label>
                            <input type="text" name="title" required>
                        </div>
                        <div class="auth-form__input">
                            <label>Director:</label>
                            <input type="text" name="director" required>
                        </div>
                        <div class="auth-form__input">
                            <label>Category:</label>
                            <input type="text" name="category" required>
                        </div>
                        <div class="auth-form__input">
                            <label>Age Require:</label>
                            <input type="number" name="ageRequire" required>
                        </div>
                        <div class="auth-form__input">
                            <label>Actors:</label>
                            <select multiple="multiple" name="actors" required>
                                <c:forEach var="actor" items="${requestScope.ACTORS}">
                                    <option value="${actor.id}">${actor.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="auth-form__submit">
                            <button class="auth-form__submit" type="submit">Add Movie</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
