<%-- 
    Document   : brands
    Created on : 2023?3?28?, ??06:17:57
    Author     : amosa
--%>

<!DOCTYPE html>
<%@ page import="ict.bean.*, java.util.*" %>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
  </head>
  <body>
    <jsp:useBean
      id="locs"
      class="java.util.ArrayList<ict.bean.Location>"
      scope="request"
    />

    <% 
        for (int i = 0; i < locs.size(); i++) { 
            Location l = locs.get(i);
            out.println("<a href=\"getVenues?loc=" + l.getName() + "\">" + l.getName() + "</a><br/>");
        } 
    %>
  </body>
</html>
