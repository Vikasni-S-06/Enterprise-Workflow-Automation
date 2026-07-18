<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Enterprise Workflow Automation | Login</title>

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<div class="login-container">

    <div class="login-box">

        <h1>Enterprise Workflow Automation</h1>

        <p class="subtitle">Sign in to continue</p>

        <form action="login" method="post">

            <div class="form-group">

                <label>Email</label>

                <input
                        type="email"
                        name="email"
                        placeholder="Enter your email"
                        required>

            </div>

            <div class="form-group">

                <label>Password</label>

                <input
                        type="password"
                        id="password"
                        name="password"
                        placeholder="Enter your password"
                        required>

            </div>

            <div class="options">

                <label>

                    <input type="checkbox"
                           onclick="togglePassword()">

                    Show Password

                </label>

            </div>

            <button type="submit">

                Login

            </button>

        </form>

    </div>

</div>

<script src="js/login.js"></script>

</body>
</html>