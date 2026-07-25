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
        // for (Movie movie : content) {
            // System.out.println(movie.getTitle());
        // }

        content.forEach(movie -> System.out.println(movie.getTitle())); // the foreach method is included in the List class / -> lamda expretion
    }

    public void removeMovie(Movie movie) {
        this.content.remove(movie);
    }

    public Movie searchByTitle(String title) {
        // for (Movie movie : content) {
            // if (movie.getTitle().equalsIgnoreCase(title)) {
                // return movie;
            // }
        // }

        // the stream allows us to iterate through the list
        return content.stream()
                .filter(movie -> movie.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    public List<Movie> SearchByMovieGenre (String gender) {
        return content.stream()
                .filter(movie -> movie.getMovieGenre().equalsIgnoreCase(gender))
                .toList();
    }

    public String getName() {
        return name;
    }

    public List<Movie> getContent() {
        return content;
    }
}
