<%-- Document : loginError Created on : 2023年3月28日, 下午10:00:58 Author :
User --%> <%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Login Error</title>

    <style>
      .page_404 {
        padding: 40px 0;
        background: #fff;
        font-family: 'Arvo', serif;
      }

      .page_404 img {
        width: 100%;
      }

      .four_zero_four_bg {
        background-image: url(https://cdn.dribbble.com/users/285475/screenshots/2083086/dribbble_1.gif);
        height: 400px;
        background-repeat: no-repeat;
        background-position: center;
      }

      h1 {
        font-size: 50px;
      }

      .four_zero_four_bg h3 {
        font-size: 80px;
      }

      .link_404 {
        color: #fff !important;
        padding: 10px 20px;
        background: #39ac31;
        margin: 20px 0;
        display: inline-block;
      }
      .contant_box_404 {
        margin-top: -50px;
      }

      .text-center {
        text-align: center;
      }
    </style>
  </head>
  <body>
    <section class="page_404">
      <div class="container">
        <div class="row">
          <div class="col-sm-12">
            <div class="col-sm-10 col-sm-offset-1 text-center">
              <h1 class="text-center">Wrong Email or Password</h1>
              <div class="four_zero_four_bg"></div>

              <div class="contant_box_404">
                <a href="login.jsp" class="link_404">Back To Login</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </body>
</html>
