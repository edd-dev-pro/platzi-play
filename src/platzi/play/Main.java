package platzi.play;

import platzi.play.contenido.Movie;
import platzi.play.plataforma.User;
import platzi.play.util.ScannerUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static final String PLATFORM_NAME = "Platzi Play";
    public static final String VERSION = "1.0.0";

    static void main(String[] args) {
        System.out.println(PLATFORM_NAME + " - " + VERSION);

        String title = ScannerUtils.getText("Nombre del contenido");
        String movieGenre = ScannerUtils.getText("Género del contenido");
        int duration = ScannerUtils.getNumber("Duración del contenido");
        double rating = ScannerUtils.getDecimal("Calificación del contenido");

        Movie movie = new Movie();
        movie.title = title;
        movie.releaseDate = LocalDate.of(2018, 10, 15);
        movie.movieGenre = movieGenre;
        movie.duration = duration;
        movie.rateMovie(rating);

        System.out.println(movie.getTechnicalSpecifications());

        User user = new User();
        user.name = "Eduardo";
        user.registrationDate = LocalDateTime.of(2026, 7, 15, 19, 24, 12);
        user.watchMovie(movie);
    }
}
