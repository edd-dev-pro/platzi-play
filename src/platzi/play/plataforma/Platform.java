package platzi.play.plataforma;

import platzi.play.contenido.Content;
import platzi.play.contenido.ContentSummary;
import platzi.play.contenido.Gender;
import platzi.play.exception.ExistingFilmException;
import platzi.play.util.FileUtils;

import java.util.*;

public class Platform {
    private String name;
    private List<Content> content;
    private Map<Content, Integer> numberOfViews;

    public Platform(String name) {
        this.name = name;
        this.content = new ArrayList<>();
        this.numberOfViews = new HashMap<>();
    }

    public void addContent(Content content) {
        Content doesContentExist = this.searchByTitle(content.getTitle());

        if (doesContentExist != null) {
            throw new ExistingFilmException(content.getTitle());
        }

        FileUtils.writeToFile(content);
        this.content.add(content);
    }

    public void playMovie (Content content) {
        int count = numberOfViews.getOrDefault(content, 0);
        System.out.println(content.getTitle() + " ha sido reproducido " + count + " veces.");

        this.countViews(content);
        content.reproduce();
    }

    private void countViews (Content content) {
        int currentCount = numberOfViews.getOrDefault(content, 0);
        numberOfViews.put(content, currentCount + 1);
    }

    public List<String> getTitles() {
        // for (Content movie : content) {
            // System.out.println(movie.getTitle());
        // }

        // content.forEach(movie -> System.out.println(movie.getTitle())); // the foreach method is included in the List class / -> lamda expretion

        return content.stream()
                .map(Content::getTitle)
                .toList();
    }

    public List<ContentSummary> getSummary () {
        return content.stream()
                .map(movie -> new ContentSummary(movie.getTitle(), movie.getDuration(), movie.getMovieGenre()))
                .toList();
    }

    public void removeMovie(Content content) {
        this.content.remove(content);
    }

    public Content searchByTitle(String title) {
        // for (Content movie : content) {
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

    public List<Content> searchByGender(Gender gender) {
        return content.stream()
                .filter(movie -> movie.getMovieGenre().equals(gender))
                .toList();
    }

    public List<Content> getMostPopularOnes(int num) {
        return content.stream()
                .sorted(Comparator.comparingDouble(Content::getRating).reversed()) // Reference method ::
                .limit(num)
                .toList();
    }

    public int totalDurationOfcontent() {
        return content.stream()
                .mapToInt(Content::getDuration)
                .sum();
    }

    public String getName() {
        return name;
    }

    public List<Content> getContent() {
        return content;
    }
}
