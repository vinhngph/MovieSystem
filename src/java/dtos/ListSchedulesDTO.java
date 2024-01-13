package dtos;

import java.sql.Date;

public class ListSchedulesDTO {

    private int id;
    private String movie_title, cinema_name;
    private Date date;
    private int quantity;

    public ListSchedulesDTO(int id, String movie_title, String cinema_name, Date date, int quantity) {
        this.id = id;
        this.movie_title = movie_title;
        this.cinema_name = cinema_name;
        this.date = date;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovie_title() {
        return movie_title;
    }

    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    public String getCinema_name() {
        return cinema_name;
    }

    public void setCinema_name(String cinema_name) {
        this.cinema_name = cinema_name;
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
