package platzi.play.contenido;

import java.time.LocalDate;

public class Content {
    private String title;
    private String description;
    private int duration;
    private Gender movieGenre;
    private LocalDate releaseDate;
    private double rating;
    private boolean available;

    public Content(String title, int duration, Gender movieGenre) {
        this.title = title;
        this.duration = duration;
        this.movieGenre = movieGenre;
        this.releaseDate = LocalDate.now();
        this.available = true;
    }

    public Content(String title, int duration, Gender movieGenre, double rating) {
        this(title, duration, movieGenre);
        this.rateMovie(rating);
    }

    public void reproduce() {
        System.out.println("Reproduciendo " + title);
    }

    public String getTechnicalSpecifications() {
        return title + " (" + releaseDate.getYear() + ")\n" +
                "Género: " + movieGenre + "\n" +
                "Calificación: " + rating + "/5";
    }

    public void rateMovie(double rating) {
        if (rating >= 0 && rating <= 5) {
            this.rating = rating;
        }
    }

    public boolean isItPopular() {
        return rating >= 4;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getDuration() {
        return duration;
    }

    public Gender getMovieGenre() {
        return movieGenre;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public double getRating() {
        return rating;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
