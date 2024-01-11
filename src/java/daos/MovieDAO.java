package daos;

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

    public List<MovieDTO> getAll() {
        List<MovieDTO> list = new ArrayList<>();
        String sql = "SELECT \n"
                + "    Movies.id AS movie_id,\n"
                + "    Movies.title AS movie_title,\n"
                + "    Movies.director,\n"
                + "    Movies.category,\n"
                + "    Movies.age_require,\n"
                + "    GROUP_CONCAT(Actors.name ORDER BY Actors.name ASC) AS actor_names\n"
                + "FROM \n"
                + "    Movies\n"
                + "LEFT JOIN MovieActor ON Movies.id = MovieActor.movie_id\n"
                + "LEFT JOIN Actors ON MovieActor.actor_id = Actors.id\n"
                + "GROUP BY\n"
                + "    Movies.id, Movies.title, Movies.director, Movies.category, Movies.age_require;";

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

                MovieDTO movie = new MovieDTO(id, title, director, category, age_require, actorNames);
                list.add(movie);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
