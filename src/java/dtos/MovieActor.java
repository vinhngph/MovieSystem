package dtos;

public class MovieActor {

    private int movie_id;
    private int actor_id;

    public MovieActor(int movie_id, int actor_id) {
        this.movie_id = movie_id;
        this.actor_id = actor_id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }
}
