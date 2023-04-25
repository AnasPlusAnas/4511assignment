/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.db;

import java.io.IOException;
import java.sql.*;
import ict.bean.User;
import java.util.ArrayList;

/**
 *
 * @author a1397
 */
public class UserDB extends DB {

    private String username = "";
    private String password = "";

    public UserDB() {
        createUserTable();
    }

    public void createUserTable() {
        Connection con = null;
        Statement statement = null;
        try {
            con = getConnection();
            statement = con.createStatement();
            String sql
                    = "CREATE TABLE IF NOT EXISTS users ("
                    + "username VARCHAR(50) NOT NULL,"
                    + "password VARCHAR(50) NOT NULL,"
                    + "email VARCHAR(50) NOT NULL, "
                    + "role VARCHAR(10) NOT NULL, "
                    + "PRIMARY KEY (username)"
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

    public boolean addRecord(String username, String password, String email) {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        boolean isSuccess = false;
        try {
            con = getConnection();
            String preQueryStatement = "INSERT INTO users (username, password, email, role) VALUES (?, ?, ?, 'abc')";
            preparedStatement = con.prepareStatement(preQueryStatement);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, email);

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

    public boolean isValidUser(String user, String password) {
        Connection con = null;
        PreparedStatement stmnt = null;
        ResultSet rs = null;

        try {
            con = super.getConnection();
            stmnt = con.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
            stmnt.setString(1, user);
            stmnt.setString(2, password);
            rs = stmnt.executeQuery();

            if (rs.next()) {
                return true;
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
        return false;
    }

    public boolean delRecord(String username, String role) {
        if (role.equals(MEMBER) == false) {
            throw new IllegalArgumentException("Invalid role: " + role);
        }

        boolean isSuccess = false;
        Connection con = null;
        PreparedStatement stmnt = null;

        try {
            con = getConnection();
            stmnt = con.prepareStatement("DELETE FROM user WHERE username = ?");

            stmnt.setString(1, username);

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

    public boolean updateRecord(Object role) {

        if (role instanceof User == false) {
            throw new IllegalArgumentException("Invalid role: " + role);
        }

        boolean isSuccess = false;
        Connection con = null;
        PreparedStatement stmnt = null;

        try {
            con = getConnection();
            stmnt = con.prepareStatement(
                    "UPDATE staff SET username = ?, password = ?, email = ? WHERE id = ?");

            User user = (User) role;

            stmnt.setString(1, user.getUsername());
            stmnt.setString(2, user.getPassword());
            stmnt.setString(3, user.getEmail());

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

    public ArrayList<User> getAllRecords(String role) {
        ArrayList<User> memberList = new ArrayList<User>();
        Connection con = null;
        PreparedStatement stmnt = null;
        ResultSet rs = null;

        if (role.equals(MEMBER) == false) {
            throw new IllegalArgumentException("Invalid role: " + role);
        }

        try {
            con = getConnection();
            stmnt = con.prepareStatement("SELECT * FROM member");

            rs = stmnt.executeQuery();

            while (rs.next()) {
                User member = new User();
                member.setUsername(rs.getString("username"));
                member.setPassword(rs.getString("password"));
                member.setEmail(rs.getString("email"));
                memberList.add(member);
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
        return memberList;
    }

    public String getUserRole(String user) {
        Connection con = null;
        PreparedStatement stmnt = null;
        ResultSet rs = null;
        String role = "";

        try {
            con = super.getConnection();
            stmnt = con.prepareStatement("SELECT role FROM users WHERE username = ?");
            stmnt.setString(1, user);
            rs = stmnt.executeQuery();

            if (rs.next()) {
                role = rs.getString("role");
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
        return role;
    }

}
