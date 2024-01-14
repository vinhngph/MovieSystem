<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Home Page</title>
        <link rel="stylesheet" href="css/home.css">
    </head>
    <body>
        <div class="auth-form">
            <div class="auth-form__header">
                <h1 class="auth-form__header">Hello ${sessionScope.NAME}</h1>
            </div>

            <div class="auth-form__logout">
                <form action="../Logout" method="post">
                    <button class="auth-form__logout" type="submit">Logout</button>
                </form>
                <form action="history" method="get">
                    <button class="auth-form__logout" type="submit">History</button>
                </form>
            </div>

            <div class="auth-form__table">
                <h2 class="auth-form__table">List of movies</h2>
                <form action="home" method="post">
                    <table border="1px">
                        <tr>
                            <th>Movie ID</th>
                            <th>Title</th>
                            <th>Director</th>
                            <th>Category</th>  
                            <th>Age Require</th>
                            <th>Actors</th>
                            <th>Action</th>
                        </tr>
                        <c:forEach var="movie" items="${requestScope.MOVIES}">
                            <tr>
                                <td>${movie.id}</td>
                                <td>${movie.title}</td>
                                <td>${movie.director}</td>
                                <td>${movie.category}</td>
                                <td>${movie.age_require}</td>
                                <td>${movie.actor_names}</td>
                                <td>
                                    <button class="auth-form__table" type="submit" value="${movie.id}" name="movie_id">Choose</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </form>

                <h2 class ="auth-form__table">List of cinemas</h2>
                <form action="home" method="post">
                    <table border="1px">
                        <tr>
                            <th>Cinema ID</th>
                            <th>Name</th>
                            <th>Location</th>
                            <th>Action</th>
                        </tr>
                        <c:forEach var="cinema" items="${requestScope.CINEMAS}">
                            <tr>
                                <td>${cinema.id}</td>
                                <td>${cinema.name}</td>
                                <td>${cinema.location}</td>
                                <td>
                                    <button class="auth-form__table" type="submit" value="${cinema.id}" name="cinema_id">Choose</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </form>

                <h2 class="auth-form__table">List of schedules</h2>
                <form action="home" method="post">
                    <table border="1px">
                        <tr>
                            <th>Schedule ID</th>
                            <th>Movie</th>
                            <th>Cinema</th>
                            <th>Date</th>
                            <th>Quantity</th>
                            <th>Action</th>
                        </tr>
                        <c:forEach var="schedule" items="${requestScope.SCHEDULES}">
                            <tr>
                                <td>${schedule.id}</td>
                                <td>${schedule.movie_title}</td>
                                <td>${schedule.cinema_name}</td>
                                <td>${schedule.date}</td>
                                <td>${schedule.quantity}</td>
                                <td>
                                    <button class="auth-form__table" type="submit" value="${schedule.id}" name="schedule_id">Choose</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </form>
            </div>
    </body>
</html>
