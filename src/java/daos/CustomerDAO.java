package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dtos.CustomerDTO;
import java.sql.SQLException;
import utils.DBConnect;

public class CustomerDAO {

    private Connection conn = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;

    public void addCustomer(CustomerDTO customer) {
        String sql = "INSERT INTO Customers VALUES (?,?,?,?)";

        String username = customer.getUsername();
        String name = customer.getName();
        int phoneNumber = customer.getPhone_number();
        int age = customer.getAge();

        try {
            conn = DBConnect.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, name);
            stm.setInt(3, phoneNumber);
            stm.setInt(4, age);

            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
