<%-- Document : login Created on : Apr 24, 2023, 3:13:05 PM Author : user --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Document</title>
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            />
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
            rel="stylesheet"
            />
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>

        <link rel="stylesheet" href="./styles/login.css" />
    </head>
    <body>
        <div class="container" id="container">
            <div class="form-container sign-up-container">
                <form action="main" method="post">
                    <input type="hidden" name="action" value="register" />
                    <h1>Create Account</h1>
                    <br />
                    <input type="text" placeholder="Username" name="username" />
                    <input type="email" placeholder="Email" name="email" />
                    <input type="password" placeholder="Password" name="password" />
                    <button>Sign Up</button>
                </form>
            </div>
            <div class="form-container sign-in-container">
                <form action="main" method="post">
                    <input type="hidden" name="action" value="authenticate" />
                    <h1>Sign in</h1>
                    <br />
                    <input type="text" placeholder="Username" name="username" />
                    <input type="password" placeholder="Password" name="password" />
                    <a href="#">Forgot your password?</a>
                    <button>Sign In</button>
                </form>
            </div>

            <div class="overlay-container">
                <div class="overlay">
                    <div class="overlay-panel overlay-left">
                        <h1>Welcome Back!</h1>
                        <p>
                            To keep connected with us please login with your personal info
                        </p>
                        <button type="button" name="LoginSubmit" id="signIn" class="ghost">
                            Sign In
                        </button>
                        <a href="welcome.jsp" style="color: white;">Back Home</a>
                    </div>

                    <div class="overlay-panel overlay-right">
                        <h1>Hello, Friend!</h1>
                        <p>Enter your details and start journey with us</p>

                        <button
                            type="button"
                            name="RegisterSubmit"
                            id="signUp"
                            class="ghost"
                            >
                            Sign Up
                        </button>

                        <br />
                        <a href="welcome.jsp" style="color: white;">Back Home</a>
                    </div>
                </div>
            </div>
        </div>

        <script>
            const signUpButton = document.getElementById('signUp');
            const signInButton = document.getElementById('signIn');
            const container = document.getElementById('container');

            signUpButton.addEventListener('click', () => {
                container.classList.add('right-panel-active');
            });

            signInButton.addEventListener('click', () => {
                container.classList.remove('right-panel-active');
            });
        </script>
    </body>
</html>
