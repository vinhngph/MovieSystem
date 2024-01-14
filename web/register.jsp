<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Customer</title>
        <link rel="stylesheet" href="css/register.css">
    </head>

    <body>
        <div class="modal">
            <div class="modal__overlay"></div>

            <div class="modal__body">
                <div class="auth-form">
                    <div class="auth-form__header">
                        <h3 class="auth-form">Register Customer</h3>
                    </div>
                    <% String error = (String)session.getAttribute("ExistedUser");
                    if (error != null && !error.isEmpty()) {
                        session.removeAttribute("ExistedUser");
                    %>
                    <p id="errorMessage" style="color: red;"><%= error %></p>
                    <% 
                        } 
                    %>
                    <form action="register" method="post">
                        <div class="auth-form__form">
                            <div class="auth-form__group">
                                <label for="username">Username:</label>
                                <input type="text" class="auth-form__input" id="username" name="username" required >
                            </div>

                            <div class="auth-form__group">
                                <label for="password">Password:</label>
                                <input type="password" class="auth-form__input" id="password" name="password" required >
                            </div>
                        </div>

                        <div class="auth-form__submit">
                            <button class="btn">NEXT</button>
                        </div>
                    </form>
                    <div class="auth-form__aside">
                        <p class="auth-form__aside">Already have an account?</p> 
                        <a class="auth-form__aside" href="login">Login here</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
