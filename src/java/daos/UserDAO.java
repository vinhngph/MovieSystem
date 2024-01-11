package daos;

import dtos.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.DBConnect;

public class UserDAO {

    private Connection conn = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;

    public String getNameByUsername(String username) {
        String sql = """
                     SELECT name
                     FROM (
                         SELECT username, name FROM Staffs
                         UNION ALL
                         SELECT username, name FROM Customers
                         UNION ALL
                         SELECT username, name FROM Admin
                     ) AS CombinedData
                     WHERE username =?""";
        try {
            conn = DBConnect.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, username);
            rs = stm.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                return name;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public UserDTO getUserByUsername(String username_raw) {
        String sql = "SELECT * FROM Users WHERE username=?";
        try {
            conn = DBConnect.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, username_raw);

            rs = stm.executeQuery();
            if (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");

                UserDTO user = new UserDTO(username, password);

                return user;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public UserDTO checkLogin(String username, String password) {
        String sql = "SELECT * FROM Users WHERE username=? AND password=?";

        try {
            conn = DBConnect.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);

            rs = stm.executeQuery();

            if (rs.next()) {
                String dbUsername = rs.getString("username");
                String dbPassword = rs.getString("password");

                UserDTO user = new UserDTO(dbUsername, dbPassword);

                return user;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void addUser(UserDTO user) {
        String sql = "INSERT INTO Users (username, password) VALUES (?,?)";

        String username = user.getUsername();
        String password = user.getPassword();

        try {
            conn = DBConnect.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);

            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void removeUser(String username) {
        String sql = "DELETE FROM Users WHERE username=?";

        try {
            conn = DBConnect.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, username);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
