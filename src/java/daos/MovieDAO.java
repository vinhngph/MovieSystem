package daos;

import dtos.MovieDetailDTO;
import dtos.MovieDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBConnect;

public class MovieDAO {

    private Connection conn = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;

    public List<MovieDetailDTO> getAll() {
        List<MovieDetailDTO> list = new ArrayList<>();
        String sql = """
                     SELECT 
                         Movies.id AS movie_id,
                         Movies.title AS movie_title,
                         Movies.director,
                         Movies.category,
                         Movies.age_require,
                         GROUP_CONCAT(Actors.name ORDER BY Actors.name ASC) AS actor_names
                     FROM 
                         Movies
                     LEFT JOIN MovieActor ON Movies.id = MovieActor.movie_id
                     LEFT JOIN Actors ON MovieActor.actor_id = Actors.id
                     GROUP BY
                         Movies.id, Movies.title, Movies.director, Movies.category, Movies.age_require;""";

        try {
            conn = DBConnect.getConnection();
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("movie_id");
                String title = rs.getString("movie_title");
                String director = rs.getString("director");
                String category = rs.getString("category");
                int age_require = rs.getInt("age_require");

                String actorNamesString = rs.getString("actor_names");
                List<String> actorNames = new ArrayList<>();
                if (actorNamesString != null) {
                    String[] actorNamesArray = actorNamesString.split(",");
                    for (String actorName : actorNamesArray) {
                        actorNames.add(actorName.trim());
                    }
                }

                MovieDetailDTO movie = new MovieDetailDTO(id, title, director, category, age_require, actorNames);
                list.add(movie);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void removeMovie(int movie_id) {
        String sql1 = "DELETE FROM MovieActor WHERE movie_id=?";
        String sql2 = "DELETE FROM Movies WHERE id=?";

        try {
            conn = DBConnect.getConnection();
            stm = conn.prepareStatement(sql1);
            stm.setInt(1, movie_id);
            stm.executeUpdate();
            DBConnect.closeConnection(conn, stm, rs);

            conn = DBConnect.getConnection();
            stm = conn.prepareStatement(sql2);
            stm.setInt(1, movie_id);
            stm.executeUpdate();
            DBConnect.closeConnection(conn, stm, rs);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public int addMovie(String title, String director, String category, int age_require) {
        String sql = "INSERT INTO Movies (title, director, category, age_require) VALUES (?,?,?,?)";

        try {
            conn = DBConnect.getConnection();
            stm = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            stm.setString(1, title);
            stm.setString(2, director);
            stm.setString(3, category);
            stm.setInt(4, age_require);

            int rowsAffected = stm.executeUpdate();

            if (rowsAffected == 0) {
                throw new SQLException("Creating movie failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stm.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1); // Return the generated ID
                } else {
                    throw new SQLException("Creating movie failed, no ID obtained.");
                }
            }

        } catch (SQLException e) {
        }
        return -1;
    }
}
