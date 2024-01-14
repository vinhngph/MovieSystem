<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <c:set var="schedule" value="${requestScope.SCHEDULE}"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ticket Amount Page</title>
        <link rel="stylesheet" href="css/ticketAmount.css">
    </head>
    <body>
        <div class="auth-form">
            <div class="auth-form__header">
                <h2>Schedule</h2>
            </div>
            <div class="auth-form__table">
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
            </div>
            <div class="auth-form__amount">
                <h2>Amount</h2>
                <form action="billing" method="post">
                    <div class="auth-form__submit">
                        <label for="amount">How many ticket you want to buy? ($50/1 ticket)</label>
                        <input type="number" id="amount" name="amount" required>
                        <button type="submit">Buy</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
