package dtos;

public class BillingDetailDTO {

    private int schedule_id;
    private String movie_title, cinema_name;
    private int amount, price;

    public BillingDetailDTO(int schedule_id, String movie_title, String cinema_name, int amount, int price) {
        this.schedule_id = schedule_id;
        this.movie_title = movie_title;
        this.cinema_name = cinema_name;
        this.amount = amount;
        this.price = price;
    }

    public int getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
