<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <c:set var="schedule" value="${requestScope.SCHEDULE}"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ticket Amount Page</title>
    </head>
    <body>
        <h2>Schedule</h2>
        <table border="1px">
            <tr>
                <th>Schedule ID</th>
                <th>Movie</th>
                <th>Cinema</th>
                <th>Date</th>
                <th>Quantity</th>
            </tr>
            <tr>
                <td>${schedule.id}</td>
                <td>${schedule.movie_title}</td>
                <td>${schedule.cinema_name}</td>
                <td>${schedule.date}</td>
                <td>${schedule.quantity}</td>
            </tr>
        </table>

        <h2>Input Amount</h2>
        <form action="billing" method="post">
            <label for="amount">How many ticket you want to buy?</label>
            <input type="number" id="amount" name="amount" required>
            <br>

            <button type="submit">Buy</button>
        </form>
    </body>
</html>
