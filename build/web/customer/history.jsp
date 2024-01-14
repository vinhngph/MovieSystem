<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ticket History</title>
        <link rel="stylesheet" href="css/history.css">
    </head>
    <body>
        <div class="auth-form">
            <div class="auth-form__header">
                <h2>Ticket History</h2>
            </div>
            <div class="auth-form__table">
                <table border="1px">
                    <tr>
                        <th>Schedule ID</th>
                        <th>Movie Title</th>
                        <th>Cinema Name</th>
                        <th>Amount</th>
                        <th>Price</th>
                    </tr>
                    <c:forEach var="bill" items="${requestScope.BILLS}">
                        <tr>
                            <td>${bill.schedule_id}</td>
                            <td>${bill.movie_title}</td>
                            <td>${bill.cinema_name}</td>
                            <td>${bill.amount}</td>
                            <td>$${bill.price}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="auth-form__back">
                <form action="history" method="post">
                    <button type="submit">Back</button>
                </form>
            </div>
        </div>
    </body>
</html>