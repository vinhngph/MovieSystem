package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import utils.DBConnect;

public class MovieActorDAO {

    private Connection conn = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;

    public void addActorsToMovie(int movie_id, List<Integer> actorIds) {
        String sql = "INSERT INTO MovieActor (movie_id, actor_id) VALUES (?,?)";

        try {
            conn = DBConnect.getConnection();
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                for (Integer actorId : actorIds) {
                    statement.setInt(1, movie_id);
                    statement.setInt(2, actorId);
                    statement.addBatch();
                }
                statement.executeBatch();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
