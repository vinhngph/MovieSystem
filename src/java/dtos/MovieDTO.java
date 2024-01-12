package dtos;

public class MovieDTO {

    private int id;
    private String title, director, category;
    private int age_require;

    public MovieDTO(int id, String title, String director, String category, int age_require) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.category = category;
        this.age_require = age_require;
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
}
