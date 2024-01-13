package daos;

import dtos.ListSchedulesDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utils.DBConnect;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDAO {

    private Connection conn = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;

    public boolean addSchedule(int movie_id, int cinema_id, Date date, int quantity) {
        String sql = "INSERT INTO Schedule (movie_id, cinema_id, date, quantity) VALUES (?, ?, ?, ?)";

        try {
            conn = DBConnect.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setInt(1, movie_id);  // Set movie_id parameter
            stm.setInt(2, cinema_id); // Set cinema_id parameter
            stm.setDate(3, date);     // Set date parameter
            stm.setInt(4, quantity);   // Set quantity parameter

            int rowsAffected = stm.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public List<ListSchedulesDTO> getAll() {
        List<ListSchedulesDTO> list = new ArrayList<>();
        String sql = """
                     SELECT Schedule.id, Movies.title AS movie_title, Cinemas.name AS cinema_name, Schedule.date, Schedule.quantity
                     FROM Schedule
                     JOIN Movies ON Schedule.movie_id = Movies.id
                     JOIN Cinemas ON Schedule.cinema_id = Cinemas.id""";

        try {
            conn = DBConnect.getConnection();
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String movie_title = rs.getString("movie_title");
                String cinema_name = rs.getString("cinema_name");
                Date date = rs.getDate("date");
                int quantity = rs.getInt("quantity");

                ListSchedulesDTO schedule = new ListSchedulesDTO(id, movie_title, cinema_name, date, quantity);
                list.add(schedule);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public void removeSchedule(int schedule_id) {
        String sql = "DELETE FROM Schedule WHERE id=?";

        try {
            conn = DBConnect.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setInt(1, schedule_id);

            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<ListSchedulesDTO> getSchedules(int movie_id, int cinema_id) {
        String sql = """
                     SELECT 
                       Schedule.id, 
                       Movies.title AS movie_title, 
                       Cinemas.name AS cinema_name, 
                       Schedule.date, 
                       Schedule.quantity
                     FROM 
                       Schedule
                       JOIN Movies ON Schedule.movie_id = Movies.id
                       JOIN Cinemas ON Schedule.cinema_id = Cinemas.id
                     WHERE 
                       Schedule.movie_id=?
                       AND Schedule.cinema_id=?;""";
        List<ListSchedulesDTO> list = new ArrayList<>();

        try {
            conn = DBConnect.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setInt(1, movie_id);
            stm.setInt(2, cinema_id);

            rs = stm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String movie_title = rs.getString("movie_title");
                String cinema_name = rs.getString("cinema_name");
                Date date = rs.getDate("date");
                int quantity = rs.getInt("quantity");

                ListSchedulesDTO schedule = new ListSchedulesDTO(id, movie_title, cinema_name, date, quantity);
                list.add(schedule);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public ListSchedulesDTO getScheduleById(int id) {
        ListSchedulesDTO schedule = null;
        String sql = """
                     SELECT 
                       Schedule.id AS schedule_id,
                       Movies.title AS movie_title,
                       Cinemas.name AS cinema_name,
                       Schedule.date,
                       Schedule.quantity
                     FROM 
                       Schedule
                       JOIN Movies ON Schedule.movie_id = Movies.id
                       JOIN Cinemas ON Schedule.cinema_id = Cinemas.id
                     WHERE 
                       Schedule.id=?""";
        try {
            conn = DBConnect.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setInt(1, id);

            rs = stm.executeQuery();
            if (rs.next()) {
                int scheduleId = rs.getInt("schedule_id");
                String movieTitle = rs.getString("movie_title");
                String cinemaName = rs.getString("cinema_name");
                Date date = rs.getDate("date");
                int quantity = rs.getInt("quantity");

                schedule = new ListSchedulesDTO(scheduleId, movieTitle, cinemaName, date, quantity);
            }
            return schedule;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public void updateQuantity(int amount, int id) {
        String sql = "UPDATE Schedule SET quantity = ? WHERE id = ?";

        try {
            conn = DBConnect.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setInt(1, amount);
            stm.setInt(2, id);

            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
