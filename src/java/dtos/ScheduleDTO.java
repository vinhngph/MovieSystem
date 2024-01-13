package dtos;

import java.sql.Date;

public class ScheduleDTO {

    private int id, movie_id, cinema_id;
    private Date date;
    private int quantity;

    public ScheduleDTO(int id, int movie_id, int cinema_id, Date date, int quantity) {
        this.id = id;
        this.movie_id = movie_id;
        this.cinema_id = cinema_id;
        this.date = date;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public int getCinema_id() {
        return cinema_id;
    }

    public void setCinema_id(int cinema_id) {
        this.cinema_id = cinema_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
