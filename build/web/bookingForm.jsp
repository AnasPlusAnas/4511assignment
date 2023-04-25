<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ict.bean.User" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Booking</h1>
    <form action="BookingController" method="POST">
      <table>
        <tr>
           <td>Your Member Name:</td>
          <td>
            <% 
          
            User user = (User) session.getAttribute("userInfo");
             String username="";
             if (user != null) {
                  username = user.getUsername();
              }

            %>
            <input type="text" name="yourname" value="<%=username%>" readonly />
          </td>
        </tr>
        <tr>
          <td>Venue</td>
          <td>
            <% String value = request.getParameter("vname"); %>
            <input type="text" name="vname" value="<%=value%>" readonly />
            <!--bug-->
          </td>
        </tr>
        
        <tr>
            <td>Fee</td>
            <td>
              <% String fee = request.getParameter("fee"); %>
              <input type="text" name="fee" value="<%= fee %>" readonly />
            </td>
        </tr>

        <tr>
          <td>Date</td>
          <td>
            <input type="date" name="bkdate" />
          </td>
        </tr>

        <tr>
          <td>Booking time</td>
          <td>
            <!--disabled-->
            <select name="bkTime">
              <option value="12:00AM - 6:00AM" id="time1">
                12:00AM - 6:00AM
              </option>
              <option value="6:00AM - 12:00PM" id="time2">
                6:00AM - 12:00PM
              </option>
              <option value="12:00PM - 18:00PM" id="time3">
                12:00PM - 18:00PM
              </option>
              <option value="18:00PM - 24:00PM" id="time4">
                18:00PM - 24:00PM
              </option>
            </select>
          </td>
        </tr>
        
        <tr>
            <td>Guest 1 Name:</td>   
            <td>
                <input type="text" name="guest1" id="guest1" />
            </td>
        </tr>
        <tr>
            <td>Guest 2 Name:</td>   
            <td>
                <input type="text" name="guest2" id="guest2" />
            </td>
        </tr>
        <tr>
            <td>Guest 3 Name:</td>   
            <td>
                <input type="text" name="guest3" id="guest3" />
            </td>
        </tr>
        <tr>
            <td>Guest 4 Name:</td>   
            <td>
                <input type="text" name="guest4" id="guest4" />
            </td>
        </tr>
        <tr>
            <td>Guest 5 Name:</td>   
            <td>
                <input type="text" name="guest5" id="guest5" />
            </td>
        </tr>
        <tr>
            <td>Guest 6 Name:</td>   
            <td>
                <input type="text" name="guest6" id="guest6" />
            </td>
        </tr>
        <tr>
            <td>Guest 7 Name:</td>   
            <td>
                <input type="text" name="guest7" id="guest7" />
            </td>
        </tr>
        <tr>
            <td>Guest 8 Name:</td>   
            <td>
                <input type="text" name="guest8" id="guest8" />
            </td>
        </tr>
        <tr>
            <td>Guest 9 Name:</td>   
            <td>
                <input type="text" name="guest9" id="guest9" />
            </td>
        </tr>
        <tr>
            <td>Guest 10 Name:</td>   
            <td>
                <input type="text" name="guest10" id="guest10" />
            </td>
        </tr>
       
        
        
        <tr>
          <td>
            <input type="submit" name="bookingSubBtn" />
          </td>
        </tr>
      </table>
    </form>
  </body>
</html>