package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.DBConnect;

public class RoleDAO {

    private int getRole(String username, String tableName) {
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM " + tableName + " WHERE username=?");
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return getRoleByTableName(tableName);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return -1;
    }

    private int getRoleByTableName(String tableName) {
        return switch (tableName) {
            case "Admin" ->
                1;
            case "Staffs" ->
                2;
            case "Customers" ->
                3;
            default ->
                -1;
        };
    }

    private int getAdmin(String username) {
        return getRole(username, "Admin");
    }

    private int getStaff(String username) {
        return getRole(username, "Staffs");
    }

    private int getCustomer(String username) {
        return getRole(username, "Customers");
    }

    public int getRoleByUserName(String username) {
        int check = getAdmin(username);
        if (check == -1) {
            check = getStaff(username);
            if (check == -1) {
                check = getCustomer(username);
            }
        }
        return check;
    }
}
