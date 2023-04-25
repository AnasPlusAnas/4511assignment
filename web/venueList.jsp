<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@page import="ict.bean.Venue" %>
<%@page import="java.util.ArrayList" %>

<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Venue List</title>
</head>
<body>
    <table border="1">
        <jsp:useBean id="venueList" class="java.util.ArrayList<Venue>" scope="request" />

        <%
            for (int i = 0; i < venueList.size(); i++) {
                Venue v = venueList.get(i);
        %>
        <tr> 
            <td><%= v.getName()%></td> 
            <td><img src="<%= v.getImg()%>" width="100" height="100" alt="location" /></td> 
            <td><%= v.getAddress()%></td> 
            <td><%= v.getBkFee()%></td> 
            <td><%= v.getPersonCharge()%></td> 
            <td><a href="bookingForm.jsp?vname=<%= v.getName()%>">Book</a></td> 
        </tr> 
        <%
            }
        %> 
    </table>
</body>
</html>