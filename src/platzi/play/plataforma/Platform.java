package platzi.play.plataforma;

import platzi.play.contenido.ContentSummary;
import platzi.play.contenido.Gender;
import platzi.play.contenido.Movie;
import platzi.play.exception.ExistingFilmException;
import platzi.play.util.FileUtils;

import java.util.*;

public class Platform {
    private String name;
    private List<Movie> content;
    private Map<Movie, Integer> numberOfViews;

    public Platform(String name) {
        this.name = name;
        this.content = new ArrayList<>();
        this.numberOfViews = new HashMap<>();
    }

    public void addMovie(Movie movie) {
        Movie doesMovieExist = this.searchByTitle(movie.getTitle());

        if (doesMovieExist != null) {
            throw new ExistingFilmException(movie.getTitle());
        }

        FileUtils.writeToFile(movie);
        this.content.add(movie);
    }

    public void playMovie (Movie movie) {
        int count = numberOfViews.getOrDefault(movie, 0);
        System.out.println(movie.getTitle() + " ha sido reproducido " + count + " veces.");

        this.countViews(movie);
        movie.reproduce();
    }

    private void countViews (Movie movie) {
        int currentCount = numberOfViews.getOrDefault(movie, 0);
        numberOfViews.put(movie, currentCount + 1);
    }

    public List<String> getTitles() {
        // for (Movie movie : content) {
            // System.out.println(movie.getTitle());
        // }

        // content.forEach(movie -> System.out.println(movie.getTitle())); // the foreach method is included in the List class / -> lamda expretion

        return content.stream()
                .map(Movie::getTitle)
                .toList();
    }

    public List<ContentSummary> getSummary () {
        return content.stream()
                .map(movie -> new ContentSummary(movie.getTitle(), movie.getDuration(), movie.getMovieGenre()))
                .toList();
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

    public List<Movie> searchByGender(Gender gender) {
        return content.stream()
                .filter(movie -> movie.getMovieGenre().equals(gender))
                .toList();
    }

    public List<Movie> getMostPopularOnes(int num) {
        return content.stream()
                .sorted(Comparator.comparingDouble(Movie::getRating).reversed()) // Reference method ::
                .limit(num)
                .toList();
    }

    public int totalDurationOfcontent() {
        return content.stream()
                .mapToInt(Movie::getDuration)
                .sum();
    }

    public String getName() {
        return name;
    }

    public List<Movie> getContent() {
        return content;
    }
}
