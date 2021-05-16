package org.loose.fis.sre.model;
import org.loose.fis.sre.services.UserModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AirlineApi {
    private static int userid_history;
    int userid_history = -1;

    public static int SelectFlight(String text, String plecareOrasText, String plecareAeroportText, String destTaraText, String destOrasText, String destAeroportText, int nr, int tip, String companieText) {
    }

    public List<FlightModel> GetFlights(Connection conn, String url, String user, String password) {
        List<FlightModel> flights=new ArrayList<FlightModel>();
        try {
            conn=DriverManager.getConnection(url,user,password);
            if(conn!=null) {
                String sql = "SELECT * FROM flights_view";

                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql);

                while (result.next()){
                    FlightModel flight=new FlightModel(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5),
                            result.getString(6), result.getString(7), result.getInt(8), result.getInt(9), result.getString(10), result.getString(11), result.getString(12),
                            result.getString(13), result.getString(14), result.getString(15), result.getDouble(16),  result.getString(17));
                    flights.add(flight);
                }
            }

        }catch (SQLException ex) {
            System.out.println("An error occured. Maybe user/password is invalid");
            ex.printStackTrace();
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return flights;
    }

    public List<FlightModel> GetHistory(Connection conn, String url, String user, String password) {
        List<FlightModel> flights=new ArrayList<FlightModel>();
        try {
            conn=DriverManager.getConnection(url,user,password);
            if(conn!=null) {
                String sql = "SELECT * FROM history_list";

                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql);

                while (result.next()){
                    FlightModel flight=new FlightModel(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5),
                            result.getString(6), result.getString(7), result.getInt(8), result.getInt(9), result.getString(10), result.getString(11), result.getString(12),
                            result.getString(13), result.getString(14), result.getString(15), result.getDouble(16),  result.getString(17));
                    flights.add(flight);
                }
            }

        }catch (SQLException ex) {
            System.out.println("An error occured. Maybe user/password is invalid");
            ex.printStackTrace();
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return flights;
    }

    public int AddHistory(Connection conn, String url, String user, String password, int users_id, int flights_id) {

        int count = 0;
        try {
            conn=DriverManager.getConnection(url,user,password);
            if(conn!=null) {
                String query = "INSERT INTO history ("
                        + " users_id,"
                        + " flights_id ) VALUES ("
                        + "?, ?)";

                // set all the preparedstatement parameters
                PreparedStatement st = conn.prepareStatement(query);
                st.setInt(1, users_id);
                st.setInt(2, flights_id);
                // execute the preparedstatement insert
                count = st.executeUpdate();
                st.close();
            }


        }catch (SQLException ex) {
            System.out.println("An error occured. Maybe user/password is invalid");
            ex.printStackTrace();
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return count;
    }


    public static int AddFlight(String url, String user, String password, String departure_country, String departure_city, String destination_country,
                                int number_seats, int one_way, String airline) {

        int count = 0;
        int result = -1;
        try {
            conn=DriverManager.getConnection(url,user,password);
            if(conn!=null) {
                String query = "INSERT INTO flights ("
                        + " departure_country,"
                        + " departure_city,"
                        + " departure_airport,"
                        + " destination_country,"
                        + " destination_city,"
                        + " destination_airport,"
                        + " number_seats,"
                        + " one_way,"
                        + " airline ) VALUES ("
                        + "?, ?, ?, ?, ?, ?, ?, ?, ?)";


                // set all the preparedstatement parameters
                PreparedStatement st = conn.prepareStatement(query);
                st.setString(1, departure_country);
                st.setString(2, departure_city);
                st.setString(3, departure_airport);
                st.setString(4, destination_country);
                st.setString(5, destination_city);
                st.setString(6, destination_airport);
                st.setInt(7, number_seats);
                st.setInt(8, one_way);
                st.setString(9, airline);

                // execute the preparedstatement insert
                count = st.executeUpdate();
                st.close();
                if(count > 0)
                {
                    int flights_id = SelectFlight(url, user, password, departure_country, departure_city, departure_airport, destination_country, destination_city, destination_airport, number_seats, one_way, airline);
                    result = AddHistory(url, user, password, userid_history, flights_id);
                }
            }


        }catch (SQLException ex) {
            System.out.println("An error occured. Maybe user/password is invalid");
            ex.printStackTrace();
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return result;
    }

    public static int SelectFlight(Connection conn, String url, String user, String password, String departure_country, String departure_city,
                                   String departure_airport, String destination_country, String destination_city, String destination_airport, int number_seats, int one_way, String airline) {

        int id = -1;
        try {
            conn=DriverManager.getConnection(url,user,password);
            if(conn!=null) {
                String query = "SELECT id FROM flights WHERE departure_country = ? AND departure_city = ? AND departure_airport = ? AND destination_country = ?"
                        + "AND destination_city = ? AND destination_airport = ? AND number_seats = ? AND one_way = ? AND airline = ?";

                // set all the preparedstatement parameters
                PreparedStatement st = conn.prepareStatement(query);
                st.setString(1, departure_country);
                st.setString(2, departure_city);
                st.setString(3, departure_airport);
                st.setString(4, destination_country);
                st.setString(5, destination_city);
                st.setString(6, destination_airport);
                st.setInt(7, number_seats);
                st.setInt(8, one_way);
                st.setString(9, airline);

                // execute the preparedstatement insert
                ResultSet result = st.executeQuery();
                while (result.next()){
                    id = result.getInt(1);
                }
                st.close();
            }


        }catch (SQLException ex) {
            System.out.println("An error occured. Maybe user/password is invalid");
            ex.printStackTrace();
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return id;
    }

    public static int AddDates(String url, String user, String password, String departure_date, int time, double price) {

        int count = 0;
        try {
            conn=DriverManager.getConnection(url,user,password);
            if(conn!=null) {
                String query = "INSERT INTO date_time ("
                        + " departure_date,"
                        + " departure_time,"
                        + " arriver_date,"
                        + " arriver_time,"
                        + " time,"
                        + " price ) VALUES ("
                        + "?, ?, ?, ?, ?, ?)";


                // set all the preparedstatement parameters
                PreparedStatement st = conn.prepareStatement(query);
                st.setString(1, departure_date);
                st.setString(2, departure_time);
                st.setString(3, arriver_date);
                st.setString(4, arriver_time);
                st.setInt(5, time);
                st.setDouble(6, price);

                // execute the preparedstatement insert
                count = st.executeUpdate();
                st.close();
            }


        }catch (SQLException ex) {
            System.out.println("An error occured. Maybe user/password is invalid");
            ex.printStackTrace();
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return count;
    }

    public static int SelectDate(String url, String user, String password, String departure_date, int time, double price) {

        int id = -1;
        try {
            conn=DriverManager.getConnection(url,user,password);
            if(conn!=null) {
                String query = "SELECT id FROM date_time WHERE departure_date = ? AND departure_time = ? AND arriver_date = ? AND arriver_time = ? AND time = ? AND price = ?";


                // set all the preparedstatement parameters
                PreparedStatement st = conn.prepareStatement(query);
                st.setString(1, departure_date);
                st.setString(2, departure_time);
                st.setString(3, arriver_date);
                st.setString(4, arriver_time);
                st.setInt(5, time);
                st.setDouble(6, price);

                // execute the preparedstatement insert
                ResultSet result = st.executeQuery();
                while (result.next()){
                    id = result.getInt(1);
                }
                st.close();
            }


        }catch (SQLException ex) {
            System.out.println("An error occured. Maybe user/password is invalid");
            ex.printStackTrace();
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return id;
    }

    public static int AddFlightDate(int flights_id, int date_time_id) {

        int count = 0;
        try {
            conn=DriverManager.getConnection(url,user,password);
            if(conn!=null) {
                String query = "INSERT INTO flights_has_date_time ("
                        + " flights_id,"
                        + " date_time_id ) VALUES ("
                        + "?, ?)";


                // set all the preparedstatement parameters
                PreparedStatement st = conn.prepareStatement(query);
                st.setInt(1, flights_id);
                st.setInt(2, date_time_id);

                // execute the preparedstatement insert
                count = st.executeUpdate();
                st.close();
            }


        }catch (SQLException ex) {
            System.out.println("An error occured. Maybe user/password is invalid");
            ex.printStackTrace();
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return count;
    }

    public List<FlightModel> GetFilteredFlights(Connection conn, String url, String user, String password, String departure_country, String departure_city,
                                                String departure_airport, String destination_country, String destination_city, String destination_airport, int one_way, String departure_date) {
        List<FlightModel> flights=new ArrayList<FlightModel>();
        try {
            conn=DriverManager.getConnection(url,user,password);
            if(conn!=null) {
                String sql = "SELECT * FROM flights_view WHERE departure_country = ? and departure_city = ? and departure_airport = ? and "
                        + "destination_country = ? and destination_city = ? and destination_airport = ? and one_way = ? and departure_date = ?";

                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, departure_country);
                ps.setString(2,  departure_city);
                ps.setString(3, departure_airport);
                ps.setString(4,  destination_country);
                ps.setString(5, destination_city);
                ps.setString(6,  destination_airport);
                ps.setInt(7, one_way);
                ps.setString(8,  departure_date);
                ResultSet result = ps.executeQuery();


                while (result.next()){
                    FlightModel flight=new FlightModel(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5),
                            result.getString(6), result.getString(7), result.getInt(8), result.getInt(9), result.getString(10), result.getString(11), result.getString(12),
                            result.getString(13), result.getString(14), result.getString(15), result.getDouble(16),  result.getString(17));
                    flights.add(flight);
                }
            }

        }catch (SQLException ex) {
            System.out.println("An error occured. Maybe user/password is invalid");
            ex.printStackTrace();
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return flights;
    }

    public static int GetUser(String url, String user) {
        int count = -1;
        try {
            conn=DriverManager.getConnection(url,user,password);
            if(conn!=null) {
                String sql = "SELECT permissions, id FROM users WHERE username = ? AND password = ?";

                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2,  pass);
                ResultSet result = ps.executeQuery();

                while (result.next()){
                    count = result.getInt(1);
                    userid_history = result.getInt(2);
                }
            }

        }catch (SQLException ex) {
            System.out.println("An error occured. Maybe user/password is invalid");
            ex.printStackTrace();
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return count;
    }

    public int AddUser(Connection conn, String url, String user, String password, UserModel User) {
        int count = 0;
        try {
            conn=DriverManager.getConnection(url,user,password);
            if(conn!=null) {

                Statement statement = conn.createStatement();
                String sql = "INSERT INTO airline.users (username, password, name, adress, phone, permissions) VALUES ( ?, ?, ?, ?, ?, ?)";
                try {
                    // set all the preparedstatement parameters
                    PreparedStatement st = conn.prepareStatement(sql);
                    UserModel addUser;
                    /*st.setString(1, addUser.username);
                    st.setString(2, addUser.password);
                    st.setString(3, addUser.name);
                    st.setString(4, addUser.adress);
                    st.setString(5, addUser.phone);
                    st.setInt(6,addUser.permissions);*/

                    // execute the preparedstatement insert
                    count = st.executeUpdate();
                    st.close();
                }
                catch (SQLException se)
                {
                    // log exception
                    throw se;
                }
            }

        }catch (SQLException ex) {
            System.out.println("An error occured. Maybe user/password is invalid");
            ex.printStackTrace();
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return count;
    }

    public int GetId(Connection conn, String url, String user, String password, int id) {
        int id_status= -1;
        try {
            conn=DriverManager.getConnection(url,user,password);
            if(conn!=null) {
                String sql = "SELECT id_for_status FROM flights_view WHERE id = ?";

                // set all the preparedstatement parameters
                PreparedStatement st = conn.prepareStatement(sql);
                st.setInt(1, id);

                // execute the preparedstatement insert
                ResultSet result = st.executeQuery();
                while (result.next()){
                    id_status = result.getInt(1);
                }
                st.close();
            }

        }catch (SQLException ex) {
            System.out.println("An error occured. Maybe user/password is invalid");
            ex.printStackTrace();
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return id_status;
    }

    public static int UpdateState(int id, String state) {
        int count = 0;
        int id_status = GetId(id);
        System.out.println("Id_status:" + id_status);
        try {
            conn=DriverManager.getConnection();
            if(conn!=null) {

                Statement statement = conn.createStatement();
                String sql = "UPDATE flights_has_date_time set flight_status = ? where id = ?";
                try {
                    // set all the preparedstatement parameters
                    PreparedStatement st = conn.prepareStatement(sql);
                    st.setString(1, state);
                    st.setInt(2, id_status);

                    // execute the preparedstatement insert
                    count = st.executeUpdate();
                    st.close();
                }
                catch (SQLException se)
                {
                    // log exception
                    throw se;
                }
            }

        }catch (SQLException ex) {
            System.out.println("An error occured. Maybe user/password is invalid");
            ex.printStackTrace();
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return count;
    }

    public int UpdateSeats(Connection conn, String url, String user, String password, int id, int number_seats) {
        int count = 0;
        try {
            conn=DriverManager.getConnection(url,user,password);
            if(conn!=null) {

                Statement statement = conn.createStatement();
                String sql = "UPDATE flights set number_seats = ? where id = ?";
                try {
                    // set all the preparedstatement parameters
                    PreparedStatement st = conn.prepareStatement(sql);
                    st.setInt(1, number_seats);
                    st.setInt(2, id);

                    // execute the preparedstatement insert
                    count = st.executeUpdate();
                    st.close();
                }
                catch (SQLException se)
                {
                    // log exception
                    throw se;
                }
            }

        }catch (SQLException ex) {
            System.out.println("An error occured. Maybe user/password is invalid");
            ex.printStackTrace();
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return count;
    }

    public static int DeleteFlight(int id) {
        int count = -1;
        try {
            conn=DriverManager.getConnection(url,user,password);
            if(conn!=null) {

                Statement statement = conn.createStatement();
                String sql = "DELETE from flights where id = ?";
                try {
                    // set all the preparedstatement parameters
                    PreparedStatement st = conn.prepareStatement(sql);
                    st.setInt(1, id);

                    // execute the preparedstatement insert
                    count = st.executeUpdate();

                }
                catch (SQLException se)
                {
                    // log exception
                    throw se;
                }
            }

        }catch (SQLException ex) {
            System.out.println("An error occured. Maybe user/password is invalid");
            ex.printStackTrace();
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return count;
    }
}


