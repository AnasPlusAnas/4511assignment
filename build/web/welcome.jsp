<%-- 
    Document   : welcome
    Created on : Apr 24, 2023, 3:15:25 PM
    Author     : user
--%>

<%@page import="ict.bean.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Welcome</title>
    <link rel="stylesheet" href="./styles/welcome.css"/>
  </head>
  <body>
      
    <%
        User user = (User) session.getAttribute("userInfo");
        String buttonContent = user == null ? "Log In" : "Log Out";
        String hrefLocation = buttonContent.equals("Log In") ? "login.jsp" : "logout.jsp";
        String profileVisible = buttonContent.equals("Log In") ? "" : "Profile";
    %>
   <header>
      <nav class="navbar">
        <a class="navbar-logo" href="#">EPL Venues</a>
        <ul class="navbar-menu">
          <li class="navbar-item"><a class="navbar-link" href="#">Home</a></li>
          <li class="navbar-item"><a class="navbar-link" href="#">About</a></li>
          <li class="navbar-item"><a class="navbar-link" href="VenueController?action=list">Venues</a></li>
          <li class="navbar-item">
            <a class="navbar-link" href="#">Contact</a>
          </li>
          <li class="navbar-item"><a class="navbar-link" href="#"><%= profileVisible %></a></li>
        </ul>
        <a class="navbar-profile" href="<%= hrefLocation %>"><%= buttonContent %></a>
      </nav>
    </header>
    
  </body>
</html>
