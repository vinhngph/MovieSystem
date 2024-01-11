package daos;

import dtos.StaffDTO;
import dtos.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

//    public List<StaffDTO> getStaffByUsername(String username) {
//        List<StaffDTO> list = new ArrayList<>();
//        String sql = "SELECT * FROM Staffs WHERE username=?";
//        try {
//            conn = DBConnect.getConnection();
//            stm = conn.prepareStatement(sql);
//            stm.setString(1, username);
//
//            rs = stm.executeQuery();
//
//            while (rs.next()) {
//                String dbUsername = rs.getString("username");
//                String dbName = rs.getString("name");
//                String dbDeparment = rs.getString("department");
//                int dbSalary = rs.getInt("salary");
//
//                StaffDTO staff = new StaffDTO(dbUsername, dbName, dbDeparment, dbSalary);
//                list.add(staff);
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return list;
//    }
    public List<StaffDTO> getAll() {
        List<StaffDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM Staffs";
        try {
            conn = DBConnect.getConnection();
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                String dbUsername = rs.getString("username");
                String dbName = rs.getString("name");
                String dbDeparment = rs.getString("department");
                int dbSalary = rs.getInt("salary");

                StaffDTO staff = new StaffDTO(dbUsername, dbName, dbDeparment, dbSalary);
                list.add(staff);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void removeStaff(String username) {
        String sql = "DELETE FROM Staffs WHERE username=?";

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
