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
        <form action="../Logout" method="post">
            <button type="submit">Logout</button>
        </form>
        <br>


        <h2>List of actors</h2>
        <% String error = (String)session.getAttribute("InMovie");
            if (error != null && !error.isEmpty()) {
                session.removeAttribute("InMovie");
        %>
        <p id="errorMessage" style="color: red;"><%= error %></p>
        <% 
            } 
        %>
        <form action="/staff/add_actor" method="get">
            <button type="submit">Add actor</button>
        </form>
        <table border="1px">
            <tr>
                <th>Actor ID</th>
                <th>Name</th>
                <th>Action</th>
            </tr>
            <c:forEach var="actor" items="${requestScope.ACTORS}">
                <tr>
                    <td>${actor.id}</td>
                    <td>${actor.name}</td>
                    <td>
                        <button type="button" onclick="removeActor('${actor.id}', '${actor.name}')">Remove</button>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <h2>List of movies</h2>
        <form action="/staff/add_movie">
            <button type="submit">Add movie</button>
        </form>
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
                        <button type="button" onclick="removeMovie('${movie.id}', '${movie.title}')">Remove</button>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <script>
            try {
                function removeActor(id, name) {
                    if (confirm("Remove actor: " + name + "?")) {
                        window.location = "/staff/remove_actor?actor_id=" + id;
                    }
                }

                function removeMovie(id, title) {
                    if (confirm("Remove movie: " + title + "?")) {
                        window.location = "/staff/remove_movie?movie_id=" + id;
                    }
                }
            } catch (e) {
                console.error(e);
            }
        </script>
    </body>
</html>
