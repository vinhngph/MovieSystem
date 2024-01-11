package dtos;

import java.util.List;

public class ListMoviesDTO {

    private int id;
    private String title;
    private String director;
    private String category;
    private int age_require;
    private List<String> actor_names;

    public ListMoviesDTO(int id, String title, String director, String category, int age_require, List<String> actor_names) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.category = category;
        this.age_require = age_require;
        this.actor_names = actor_names;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAge_require() {
        return age_require;
    }

    public void setAge_require(int age_require) {
        this.age_require = age_require;
    }

    public List<String> getActor_names() {
        return actor_names;
    }

    public void setActor_names(List<String> actor_names) {
        this.actor_names = actor_names;
    }
}
