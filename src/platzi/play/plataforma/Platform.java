package platzi.play.plataforma;

import platzi.play.contenido.Movie;

import java.util.ArrayList;
import java.util.List;

public class Platform {
    private String name;
    private List<Movie> content;

    public Platform(String name) {
        this.name = name;
        this.content = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        this.content.add(movie);
    }

    public void showTitles() {
        for (Movie movie : content) {
            System.out.println(movie.getTitle());
        }
    }

    public void removeMovie(Movie movie) {
        this.content.remove(movie);
    }

    public Movie searchByTitle(String title) {
        for (Movie movie : content) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie;
            }
        }

        return null;
    }

    public String getName() {
        return name;
    }

    public List<Movie> getContent() {
        return content;
    }
}
