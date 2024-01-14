<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Customer Information</title>
        <link rel="stylesheet" href="css/information.css">
    </head>
    <body>
        <div class="modal">
            <div class="modal__overlay">
            </div>
            <div class="modal__body">
                <div class="auth-form">
                    <div class="auth-form__header">
                        <h1 class="auth-form__header">Hello ${sessionScope.USER.username}</h1>
                        <h3 class="auth-form__header">Please enter your information!</h3>
                    </div>

                    <form action="/customer/information" method="post">
                        <div class="auth-form__form">
                            <label for="name">Name:</label>
                            <input type="text" id="name" name="name" required>
                            <br>

                            <label for="phone_number">Phone Number:</label>
                            <input type="number" id="phone_number" name="phone_number" required>
                            <br>

                            <label for="age">Age:</label>
                            <input type="number" id="age" name="age" required>
                            <br>

                        </div>
                        <div class="auth-form__submit">
                            <button type="submit">Register</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>