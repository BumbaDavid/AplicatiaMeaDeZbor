package org.loose.fis.sre.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AirlineApi {
    public AirlineApi() {
    }

    public void GetFlights(Connection conn, String url, String user, String password) {
        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                String sql = "SELECT * FROM flights_airline_view";
                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql);

                while(result.next()) {
                    Flight flight = new Flight(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7), result.getString(8), result.getInt(9), result.getInt(10), result.getString(11), result.getString(12), result.getString(13), result.getString(14), result.getString(15), result.getDouble(16), result.getString(17));
                    System.out.printf("%s \n", flight.airline);
                }
            }
        } catch (SQLException var17) {
            System.out.println("An error occured. Maybe user/password is invalid");
            var17.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException var16) {
                    var16.printStackTrace();
                }
            }

        }

    }

    public int GetUser(Connection conn, String url, String user, String password, String username, String pass) {
        int count = -1;

        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                String sql = "SELECT permissions FROM users WHERE username = ? AND password = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, pass);

                for(ResultSet result = ps.executeQuery(); result.next(); count = result.getInt(1)) {
                }
            }
        } catch (SQLException var19) {
            System.out.println("An error occured. Maybe user/password is invalid");
            var19.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException var18) {
                    var18.printStackTrace();
                }
            }

        }

        return count;
    }

    public int AddUser(Connection conn, String url, String user, String password, User User) {
        int count = 0;

        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                Statement statement = conn.createStatement();
                String sql = "INSERT INTO airline.users (username, password, name, adress, phone, permissions) VALUES ( ?, ?, ?, ?, ?, ?)";

                try {
                    PreparedStatement st = conn.prepareStatement(sql);
                    st.setString(1, User.username);
                    st.setString(2, User.password);
                    st.setString(3, User.name);
                    st.setString(4, User.adress);
                    st.setString(5, User.phone);
                    st.setInt(6, User.permissions);
                    count = st.executeUpdate();
                    st.close();
                } catch (SQLException var19) {
                    throw var19;
                }
            }
        } catch (SQLException var20) {
            System.out.println("An error occured. Maybe user/password is invalid");
            var20.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException var18) {
                    var18.printStackTrace();
                }
            }

        }

        return count;
    }
}

