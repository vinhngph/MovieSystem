package daos;

import dtos.StaffDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.DBConnect;

public class StaffDAO {

    private Connection conn = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;

    public void addStaff(StaffDTO staff) {
        String sql = "INSERT INTO Staffs VALUES (?,?,?,?)";

        String username = staff.getUsername();
        String name = staff.getName();
        String department = staff.getDepartment();
        int salary = staff.getSalary();

        try {
            conn = DBConnect.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, name);
            stm.setString(3, department);
            stm.setInt(4, salary);

            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
}
