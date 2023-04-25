package ict.db;

import java.sql.*;
import ict.bean.Venue;
import static ict.db.DB.MEMBER;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author a1397
 */
public class VenueDB extends DB {

//    create venue table if not exisit
    public VenueDB() {

        createLocationTable();
    }

    public void createLocationTable() {
        Connection con = null;
        Statement statement = null;
        try {
            con = getConnection();
            statement = con.createStatement();
            String sql
                    = "CREATE TABLE IF NOT EXISTS Venue ("
                    + "id INT(5) AUTO_INCREMENT NOT NULL,"
                    + "name VARCHAR(25) NOT NULL,"
                    + "address VARCHAR(25) NOT NULL,"
                    + "img VARCHAR(50) NOT NULL, "
                    + "capacity VARCHAR(50) NOT NULL,"
                    + "description TEXT(400) NOT NULL,"
                    + "booking_fee INT(5) NOT NULL,"
                    + "personCharge INT(5) NOT NULL,"
                    + "PRIMARY KEY (id)"
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

    public boolean addVenue(String name, String img, String address, String capacity, String description, int booking_fee, int personCharge) {

        Connection con = null;
        PreparedStatement preparedStatement = null;
        boolean isSuccess = false;
        try {
            con = getConnection();
            String preQueryStatement = "INSERT INTO Venue VALUES (?,?,?,?,?,?,?,?)";
            preparedStatement = con.prepareStatement(preQueryStatement);

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, img);
            preparedStatement.setString(3, address);
            preparedStatement.setString(4, capacity);
            preparedStatement.setString(5, description);
            preparedStatement.setInt(6, booking_fee);
            preparedStatement.setInt(7, personCharge);

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

    public boolean delVenue(String name, String role) {
        if (role.equals(MEMBER) == false) {
            throw new IllegalArgumentException("Invalid role: " + role);
        }

        boolean isSuccess = false;
        Connection con = null;
        PreparedStatement stmnt = null;

        try {
            con = getConnection();
            stmnt = con.prepareStatement("DELETE FROM Venue WHERE name = ?");

            stmnt.setString(1, name);

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

    public boolean updateRecord(Object thevenue) {

        boolean isSuccess = false;
        Connection con = null;
        PreparedStatement stmnt = null;

        try {
            con = getConnection();
            stmnt = con.prepareStatement(
                    "UPDATE Venue SET name = ?, img = ?, address = ?, capacity = ?,  description = ?, booking_fee = ?, personCarge = ? WHERE id = ?");

            Venue v = (Venue) thevenue;

            stmnt.setString(1, v.getName());
            stmnt.setString(2, v.getImg());
            stmnt.setString(3, v.getAddress());
            stmnt.setString(4, v.getCapacity());
            stmnt.setString(5, v.getDes());
            stmnt.setInt(6, v.getBkFee());
            stmnt.setInt(7, v.getPersonCharge());

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

    public ArrayList<Venue> getAllRecords() {
        ArrayList<Venue> venueList = new ArrayList<Venue>();
        Connection con = null;
        PreparedStatement stmnt = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            stmnt = con.prepareStatement("SELECT * FROM Venue");

            rs = stmnt.executeQuery();

            while (rs.next()) {
                Venue v = new Venue();
                v.setID(rs.getInt("id"));

                v.setName(rs.getString("name"));

                v.setAddress(rs.getString("address"));

                v.setImg(rs.getString("img"));

                v.setCapacity(rs.getString("capacity"));

                v.setDes(rs.getString("description"));

                v.setBkFee(rs.getInt("booking_fee"));

                v.setPersonCharge(rs.getInt("personCharge"));

                v.setAvailability(rs.getString("available"));

                venueList.add(v);
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
        return venueList;
    }

}
