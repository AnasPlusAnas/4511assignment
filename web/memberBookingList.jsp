<%-- 
    Document   : memberBookingList
    Created on : Apr 25, 2023, 9:57:33 PM
    Author     : dadwd
--%>

<%@page import="ict.bean.Booking"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ict.bean.Venue" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Bookings</title>
        <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
            />
    </head>
    <body>
        <jsp:useBean id="bookingList" class="java.util.ArrayList<Booking>" scope="request" />

            <div class="page-content page-container" id="page-content">
                <div class="padding">
                    <div class="container d-flex justify-content-center">
                        <div class="card">
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table id="htmltable" class="table">
                                        <thead class="text-center">
                                            <tr>
                                                <th>Name</th>
                                                <th>Image</th>
                                                <th>Description</th>
                                                <th>Availability</th>
                                                <th>Address</th>
                                                <th>Max Capacity</th>
                                                <th>Booking Price</th>
                                                <th>Charge Per Person</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                for (int i = 0; i < bookingList.size(); i++) {
                                                    Booking b = bookingList.get(i);
                                            %>
                                            <tr class="text-center">
                                                <td> <%= b.getName()%> </td>
                                                <td><img src="<%= v.getImg()%>" width="100" height="100" alt="location" /></td>
                                                <td><%= v.getDes() %> </td>
                                                <td><label class="badge <%= availableClass%>"> <%= availableText%></label></td> 
                                                <td><%= v.getAddress()%></td>
                                                <td><%= v.getCapacity() %> </td>
                                                <td>$<%= v.getBkFee()%></td>
                                                <td>$<%= v.getPersonCharge()%></td>
                                                
                                                <td>
                                                    <form action="bookingForm.jsp" method="post">
                                                        <input type="hidden" name="vname" value="<%= v.getName() %>" />
                                                        <input type="hidden" name="fee" value="<%= v.getBkFee() %>" />
                                                        <input type="submit" <%= bookableClass %> value="Book" />
                                                    </form>
                                                </td>
                                            </tr>
                                            <%
                                                }
                                            %>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    </body>
</html>
