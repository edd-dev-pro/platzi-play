package platzi.play;

import platzi.play.contenido.Movie;
import platzi.play.plataforma.User;
import platzi.play.util.ScannerUtils;

public class Main {
    public static final String PLATFORM_NAME = "Platzi Play";
    public static final String VERSION = "1.0.0";

    static void main(String[] args) {
        System.out.println(PLATFORM_NAME + " - " + VERSION);

        String title = ScannerUtils.getText("Nombre del contenido");
        String movieGenre = ScannerUtils.getText("Género del contenido");
        int duration = ScannerUtils.getNumber("Duración del contenido");
        double rating = ScannerUtils.getDecimal("Calificación del contenido");

        Movie movie = new Movie(title, duration, movieGenre, rating);
        movie.rateMovie(rating);

        System.out.println(movie.getTechnicalSpecifications());

        User user = new User("Eduardo", "eduardo@gmail.com");
        user.watchMovie(movie);
    }
}
