package platzi.play;

import platzi.play.contenido.Movie;
import platzi.play.plataforma.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    static void main(String[] args) {
        System.out.println("Platzi Play 🍿");

        Movie movie = new Movie();

        movie.title = "El Señor de los Anillos";
        movie.releaseDate = LocalDate.of(2018, 10, 15);
        movie.movieGenre = "Fantasía";
        movie.rateMovie(4.7);
        movie.duration = 120;

        long durationLong = movie.duration; // any whole number fits in a long string
        int ratingInt = (int) movie.rating; // (int) it refers to the data type of the destination
        // long numberOfPrizes = Long.parseLong("25");
        int numberOfPrizes = (int) Long.parseLong("25000000000"); // this prints a negative number, since an int type doesn't support such large numbers

        System.out.println("Duración Long: " + durationLong);
        System.out.println("Calificación Int: " + ratingInt);
        System.out.println("Numero de premios: " + numberOfPrizes);

        User user = new User();

        user.name = "Eduardo";
        user.registrationDate = LocalDateTime.of(2026, 7, 15, 19, 24, 12);

        System.out.println(user.registrationDate);

        user.watchMovie(movie);
    }
}
