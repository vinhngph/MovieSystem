package daos;

import dtos.BillingDetailDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

    public List<BillingDetailDTO> getBillByUsername(String username) {
        List<BillingDetailDTO> list = new ArrayList<>();
        String sql = """
                     SELECT
                         B.schedule_id,
                         M.title AS movie_title,
                         C.name AS cinema_name,
                         B.amount,
                         B.price
                     FROM
                         Billing B
                     JOIN
                         Schedule S ON B.schedule_id = S.id
                     JOIN
                         Movies M ON S.movie_id = M.id
                     JOIN
                         Cinemas C ON S.cinema_id = C.id
                     WHERE
                         B.username=?""";
        try {
            conn = DBConnect.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, username);

            rs = stm.executeQuery();
            while (rs.next()) {
                int schedule_id = rs.getInt("schedule_id");
                String movie_title = rs.getString("movie_title");
                String cinema_name = rs.getString("cinema_name");
                int amount = rs.getInt("amount");
                int price = rs.getInt("price");

                BillingDetailDTO bill = new BillingDetailDTO(schedule_id, movie_title, cinema_name, amount, price);
                list.add(bill);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
}
