package daos;

import dtos.CinemaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBConnect;

public class CinemaDAO {

    private Connection conn = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;

    public List<CinemaDTO> getAll() {
        List<CinemaDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM Cinemas";

        try {
            conn = DBConnect.getConnection();
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String location = rs.getString("location");

                CinemaDTO cinema = new CinemaDTO(id, name, location);
                list.add(cinema);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void addCinema(String name, String location) {
        String sql = "INSERT INTO Cinemas (name, location) VALUES (?,?)";

        try {
            conn = DBConnect.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, name);
            stm.setString(2, location);

            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void removeCinema(int id) {
        String sql = "DELETE FROM Cinemas WHERE id=?";

        try {
            conn = DBConnect.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setInt(1, id);

            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<CinemaDTO> getCinemasByMovieId(int movie_id) {
        List<CinemaDTO> list = new ArrayList<>();
        String sql = """
                     SELECT Cinemas.*
                     FROM Cinemas
                     JOIN Schedule ON Cinemas.id = Schedule.cinema_id
                     WHERE Schedule.movie_id = ?""";
        try {
            conn = DBConnect.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setInt(1, movie_id);

            rs = stm.executeQuery();
            while (rs.next()) {
                int cine_id = rs.getInt("id");
                String cine_name = rs.getString("name");
                String cine_location = rs.getString("location");

                CinemaDTO cinema = new CinemaDTO(cine_id, cine_name, cine_location);
                list.add(cinema);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
