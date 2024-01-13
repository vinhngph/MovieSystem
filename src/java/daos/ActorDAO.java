package daos;

import dtos.ActorDTO;
import dtos.MovieActorDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBConnect;

public class ActorDAO {

    private Connection conn = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;

    public List<ActorDTO> getAll() {
        List<ActorDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM Actors";

        try {
            conn = DBConnect.getConnection();
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                ActorDTO actor = new ActorDTO(rs.getInt("id"), rs.getString("name"));
                list.add(actor);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void addActor(String name) {
        String sql = "INSERT INTO Actors (name) VALUES (?)";

        try {
            conn = DBConnect.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, name);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public MovieActorDTO getMovie(int actor_id) {
        String sql = "SELECT * FROM MovieActor WHERE actor_id=?";
        try {
            conn = DBConnect.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setInt(1, actor_id);
            rs = stm.executeQuery();
            if (rs.next()) {
                MovieActorDTO actor = new MovieActorDTO(rs.getInt("movie_id"), rs.getInt("actor_id"));
                return actor;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void removeActor(int actor_id) {
        String sql1 = "DELETE FROM MovieActor WHERE actor_id=?";
        String sql2 = "DELETE FROM Actors WHERE id=?";

        try {
            conn = DBConnect.getConnection();
            stm = conn.prepareStatement(sql1);
            stm.setInt(1, actor_id);
            stm.executeUpdate();
            DBConnect.closeConnection(conn, stm, rs);

            conn = DBConnect.getConnection();
            stm = conn.prepareStatement(sql2);
            stm.setInt(1, actor_id);
            stm.executeUpdate();
            DBConnect.closeConnection(conn, stm, rs);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
