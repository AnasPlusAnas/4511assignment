<%-- 
    Document   : logout
    Created on : Apr 25, 2023, 12:05:33 AM
    Author     : dadwd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            session.removeAttribute("userInfo");
            session.invalidate();
        %>
        <jsp:forward page="welcome.jsp"/>
    </body>
</html>
