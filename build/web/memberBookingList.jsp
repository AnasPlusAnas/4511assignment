<%-- 
    Document   : memberBookingList
    Created on : Apr 25, 2023, 9:57:33 PM
    Author     : dadwd
--%>

<%@page import="ict.db.BookingDB"%>
<%@page import="java.util.ArrayList"%>
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

            <!-- jquery cdn -->
            <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
            <style>
                div#guestContainer {
                    margin-top: 10px;
                }
                div#page-content {
                    margin-top: 20px;
                    display: flex;
                    align-content: center;
                    justify-content: center;
                    align-items: center;
                }
            </style>
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
                                                <th>Venue</th>
                                                <th>Booking Date</th>
                                                <th>Time 1</th>
                                                <th>Time 2</th>
                                                <th>Time 3</th>
                                                <th>Time 4</th>
                                                <th>Guests</th>
                                                <th>Status</th>
                                                <th>Edit</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                BookingDB bookdb = new BookingDB();
                                                for (int i = 0; i < bookingList.size(); i++) {
                                                    Booking b = bookingList.get(i);
                                                    String numberOfGuests = "0";
                                                    String bookId = String.valueOf(b.getId());
                                                    ArrayList<String> guests = bookdb.getGuests(b.getId());
                                                    if (guests != null) {
                                                    int size = 0;
                                                        for (int j = 0; j < guests.size(); j++) {
                                                            if (guests.get(j).equals("")) {
                                                                continue;
                                                            } else {
                                                                size += 1;
                                                            }
                                                        }
                                                        numberOfGuests = String.valueOf(size);
                                                        
                                                    }
                                                    String availableClass = b.getStatus().equals("Approved") ? "badge-success" : b.getStatus().equals("Rejected") ? "badge-danger" : "badge-warning";
                                            %>
                                                    <tr>
                                                        <td><%= b.getVenue() %></td>
                                                        <td><%= b.getDate() %></td>
                                                        <td><%= b.getTime1() %></td>
                                                        <td><%= b.getTime2() %></td>
                                                        <td><%= b.getTime3() %></td>
                                                        <td><%= b.getTime4() %></td>
                                                        <!-- table data with a button and its value is numberOfGuests-->
                                                        <td>
                                                            <button type="button" class="btn btn-primary <%=bookId%>"><%= numberOfGuests %></button>
                                                        </td>
                                                        <td><label style='padding:10px;' class="badge <%= availableClass%>"> <%= b.getStatus() %></label></td> 
                                                        <td>
                                                            <form action="editBooking.jsp" method="get">
                                                                <input type="hidden" name="bookid" value="<%= b.getId()%>" />
                                                                <input type="submit" class='btn btn-info' value="Edit" />
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
                <div id="guestContainer"></div>
            </div>
                                        
            

            <!-- script to listen to button click according to the bookId, on click a hello world would be injected into the dom not alert -->
            <script>
                $(document).ready(function () {
                    <% for (int i = 0; i < bookingList.size(); i++) { %>
                        $(".<%=bookingList.get(i).getId()%>").click(function () {
                            // from the booking list, get the booking id and pass it to the getGuests function to get arraylist of guests, display each guest in the arraylist into the body, also keep track of the id that is being clicked, so that there are no duplicate guests of the same booking id
                            <% Booking b = bookingList.get(i); %>
                            <% String bookId = String.valueOf(b.getId()); %>
                            <% ArrayList<String> guests = bookdb.getGuests(b.getId()); %>
                            <% if (guests != null) { %>
                                $("#guestContainer").html('<div class="page-content page-container" id="page-content"><div class="padding"><div class="container d-flex justify-content-center"><div class="card"><div class="card-body"><div class="table-responsive"><table id="htmltable" class="table"><thead class="text-center"><tr><th>Guest Name</th><th></th></tr></thead><tbody><% for (int j = 0; j < guests.size(); j++) { %><tr><td><%= guests.get(j) %></td></tr><%}%></tbody></table></div></div></div></div></div></div>');
                            <% } %>
                        });
                    <% } %>
                });
            </script>
                            
    </body>
</html>
