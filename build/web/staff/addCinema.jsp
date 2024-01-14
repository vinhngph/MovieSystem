<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Cinema</title>
        <link rel="stylesheet" href="css/addCinema.css">
    </head>
    <body>
        <div class="modal">
            <div class="modal__overlay"></div>
            <div class="modal__body">
                <div class="auth-form">
                    <h1>Add Cinema</h1>
                    <form action="add_cinema" method="post">
                        <div class="auth-form__input">
                            <label for="name">Cinema Name:</label>
                            <input type="text" id="name" name="name" required>
                        </div>
                        <div class="auth-form__input">
                            <label for="location">Location:</label>
                            <input type="text" id="location" name="location" required>
                        </div>
                        <div class="auth-form__submit">
                            <button class="auth-form__submit" type="submit">Add Cinema</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>      
    </body>
</html>
