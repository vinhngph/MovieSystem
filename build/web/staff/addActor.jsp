<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add actor</title>
        <link rel="stylesheet" href="css/addActor.css">
    </head>
    <body>
        <div class="modal">
            <div class="modal__overlay"></div>
            <div class="modal__body">
                <div class="auth-form">
                    <h1>Add actor</h1>
                    <form action="add_actor" method="post">
                        <div class="auth-form__input">
                            <label>Actor's name: </label>
                            <input type="text" name="name" required><br>
                        </div>
                        <div class="auth-form__submit">
                            <button class="auth-form__submit" type="submit">Add Actor</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

