package ict.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import ict.bean.Booking;

public class BookingDB extends DB {

    public BookingDB() {
        createBookingTable();
    }

    public void createBookingTable() {
        Connection con = null;
        Statement statement = null;
        try {
            con = getConnection();
            statement = con.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS Booking ("
                    + "id INT PRIMARY KEY AUTO_INCREMENT,"
                    + "venue VARCHAR(20) NOT NULL,"
                    + "username VARCHAR(50) NOT NULL,"
                    + "booking_date DATE NOT NULL,"
                    + "time1 VARCHAR(20) NULL,"
                    + "time2 VARCHAR(20) NULL,"
                    + "time3 VARCHAR(20) NULL,"
                    + "time4 VARCHAR(20) NULL,"
                    + "fee INT NOT NULL,"
                    + "guest1 VARCHAR(50) NULL,"
                    + "guest2 VARCHAR(50) NULL,"
                    + "guest3 VARCHAR(50) NULL,"
                    + "guest4 VARCHAR(50) NULL,"
                    + "guest5 VARCHAR(50) NULL,"
                    + "guest6 VARCHAR(50) NULL,"
                    + "guest7 VARCHAR(50) NULL,"
                    + "guest8 VARCHAR(50) NULL,"
                    + "guest9 VARCHAR(50) NULL,"
                    + "guest10 VARCHAR(50) NULL,"
                    + "Status VARCHAR(25) NOT NULL,"
                    + "FOREIGN KEY(username) REFERENCES users(username)"
                    + ")";

            statement.execute(sql);
            statement.close();
            con.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public boolean addBooking(String venue, String username, String booking_date, String time1, String time2, String time3, String time4, int fee, String guest1, String guest2, String guest3, String guest4, String guest5, String guest6, String guest7, String guest8, String guest9, String guest10) {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        boolean isSuccess = false;

        String status = "Waiting";
        try {
            con = getConnection();
            String preQueryStatement = "INSERT INTO Booking (venue, username, booking_date, time1, time2, time3, time4, fee, guest1, guest2, guest3, guest4, guest5, guest6, guest7, guest8, guest9, guest10,status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            preparedStatement = con.prepareStatement(preQueryStatement);

            preparedStatement.setString(1, venue);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, booking_date);
            preparedStatement.setString(4, time1);
            preparedStatement.setString(5, time2);
            preparedStatement.setString(6, time3);
            preparedStatement.setString(7, time4);
            preparedStatement.setInt(8, fee);
            preparedStatement.setString(9, guest1);
            preparedStatement.setString(10, guest2);
            preparedStatement.setString(11, guest3);
            preparedStatement.setString(12, guest4);
            preparedStatement.setString(13, guest5);
            preparedStatement.setString(14, guest6);
            preparedStatement.setString(15, guest7);
            preparedStatement.setString(16, guest8);
            preparedStatement.setString(17, guest9);
            preparedStatement.setString(18, guest10);
            preparedStatement.setString(19, status);

            int rowCount = preparedStatement.executeUpdate();
            if (rowCount >= 1) {
                isSuccess = true;
            }

            preparedStatement.close();
            con.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }

    // Other methods for getting, updating, and deleting bookings would go here
    public boolean delBooking(int bookingId, String role) {
        if (role.equals(MEMBER) == false) {
            throw new IllegalArgumentException("Invalid role: " + role);
        }

        boolean isSuccess = false;
        Connection con = null;
        PreparedStatement stmnt = null;

        try {
            con = getConnection();
            stmnt = con.prepareStatement("DELETE FROM Booking WHERE bookingId = ?");

            stmnt.setInt(1, bookingId);

            int rowCount = stmnt.executeUpdate();
            isSuccess = rowCount > 0;
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmnt != null) {
                    stmnt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isSuccess;
    }

    public boolean approving(int bookingId, String role) {

        boolean isSuccess = false;
        Connection con = null;
        PreparedStatement stmnt = null;

        try {
            con = getConnection();
            stmnt = con.prepareStatement("UPDATE Booking SET status = 'successful' WHERE bookingId = ?");

            stmnt.setInt(1, bookingId);

            int rowCount = stmnt.executeUpdate();
            isSuccess = rowCount > 0;
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmnt != null) {
                    stmnt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isSuccess;
    }

    public ArrayList<Booking> listWaiting() {
        ArrayList<Booking> bookingList = new ArrayList<>();
        Connection con = null;
        PreparedStatement stmnt = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            stmnt = con.prepareStatement("SELECT * FROM Booking WHERE status = 'Waiting'");

            rs = stmnt.executeQuery();

            while (rs.next()) {
                Booking booking = new Booking();
                booking.setId(rs.getInt("id"));
                booking.setVenue(rs.getString("venue"));
                booking.setUserName(rs.getString("username"));
                booking.setDate(rs.getString("booking_date"));
                booking.setTime1(rs.getString("time1"));
                booking.setTime2(rs.getString("time2"));
                booking.setTime3(rs.getString("time3"));
                booking.setTime4(rs.getString("time4"));
                booking.setFee(rs.getInt("fee"));
                booking.setGuest1(rs.getString("guest1"));
                booking.setGuest2(rs.getString("guest2"));
                booking.setGuest3(rs.getString("guest3"));
                booking.setGuest4(rs.getString("guest4"));
                booking.setGuest5(rs.getString("guest5"));
                booking.setGuest6(rs.getString("guest6"));
                booking.setGuest7(rs.getString("guest7"));
                booking.setGuest8(rs.getString("guest8"));
                booking.setGuest9(rs.getString("guest9"));
                booking.setGuest10(rs.getString("guest10"));
                booking.setStatus(rs.getString("status"));
                bookingList.add(booking);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmnt != null) {
                    stmnt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return bookingList;
    }
}
