<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@page import="ict.bean.Venue" %> 
<%@page import="java.util.ArrayList" %>

    <html>
        <head>
            <meta charset="UTF-8" />
            <meta http-equiv="X-UA-Compatible" content="IE=edge" />
            <meta name="viewport" content="width=device-width, initial-scale=1.0" />
            <title>Venue List</title>
            <link rel="stylesheet" href="./styles/bookingList.css" />
            <link
                rel="stylesheet"
                href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
                />
        </head>
        <body>
            <jsp:useBean id="venueList" class="java.util.ArrayList<Venue>" scope="request" />

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
                                                for (int i = 0; i < venueList.size(); i++) {
                                                    Venue v = venueList.get(i);
                                                    String availableClass = v.getAvailability().equals("yes") ? "badge-success" : "badge-danger";
                                                    String availableText = v.getAvailability().equals("yes") ? "Available" : "Not Available";
                                                    String bookableClass = v.getAvailability().equals("yes") ? "" : "disabled style=\"color:red;\"";

                                            %>
                                            <tr class="text-center">
                                                <td> <%= v.getName()%> </td>
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
