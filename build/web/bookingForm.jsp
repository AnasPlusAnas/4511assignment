
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Booking</h1>
    <form>
      <table>
        <tr>
          <td>Venue</td>
          <td>
            <% String value = request.getParameter("vname"); %>
            <input type="text" name="venueshow" value="<%=value%>" readonly />
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
              <option value="12:00PM - 6:00PM" id="time3">
                12:00PM - 6:00PM
              </option>
              <option value="6:00PM - 12:00AM" id="time4">
                6:00PM - 12:00AM
              </option>
            </select>
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
