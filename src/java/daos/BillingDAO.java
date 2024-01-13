package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.DBConnect;

public class BillingDAO {

    private Connection conn = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;

    public void addBill(int schedule_id, String username, int amount, int price) {
        String sql = "INSERT INTO Billing (schedule_id, username, amount, price) VALUES (?,?,?,?)";

        try {
            conn = DBConnect.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setInt(1, schedule_id);
            stm.setString(2, username);
            stm.setInt(3, amount);
            stm.setInt(4, price);

            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
