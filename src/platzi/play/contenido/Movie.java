package platzi.play.contenido;

import java.time.LocalDate;

public class Movie {
    public String title;
    public String description;
    public int duration;
    public String movieGenre;
    public LocalDate releaseDate;
    public double rating;
    public boolean available;

    public Movie(String title, int duration, String movieGenre) {
        this.title = title;
        this.duration = duration;
        this.movieGenre = movieGenre;
        this.releaseDate = LocalDate.now();
        this.available = true;
    }

    public Movie(String title, int duration, String movieGenre, double rating) {
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
}
