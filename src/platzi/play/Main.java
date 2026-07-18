package platzi.play;

import platzi.play.contenido.Movie;
import platzi.play.plataforma.Platform;
import platzi.play.plataforma.User;
import platzi.play.util.ScannerUtils;

public class Main {
    public static final String PLATFORM_NAME = "Platzi Play";
    public static final String VERSION = "1.0.0";

    static void main(String[] args) {
        Platform platform = new Platform(PLATFORM_NAME);

        System.out.println(PLATFORM_NAME + " - " + VERSION);

        String title = ScannerUtils.getText("Nombre del contenido");
        String movieGenre = ScannerUtils.getText("Género del contenido");
        int duration = ScannerUtils.getNumber("Duración del contenido");
        double rating = ScannerUtils.getDecimal("Calificación del contenido");

        Movie movie = new Movie(title, duration, movieGenre, rating);
        Movie movie_two = new Movie("El origen", duration, movieGenre, rating);

        platform.addMovie(movie);
        platform.addMovie(movie_two);

        System.out.println("Numero de elementos en la platafoma: " + platform.getContent().size());

        platform.removeMovie(movie_two);
        platform.showTitles();

        User user = new User("Eduardo", "eduardo@gmail.com");
        user.watchMovie(movie);
    }
}
