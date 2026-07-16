package platzi.play;

import platzi.play.contenido.Movie;
import platzi.play.plataforma.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        System.out.println("Platzi Play 🍿");

        Movie movie = new Movie();

        movie.title = "El Señor de los Anillos";
        movie.releaseDate = LocalDate.of(2018, 10, 15);
        movie.movieGenre = "Fantasía";
        movie.rateMovie(4.7);

        User user = new User();

        user.name = "Eduardo";
        user.registrationDate = LocalDateTime.of(2026, 7, 15, 19, 24, 12);

        System.out.println(user.registrationDate);

        user.watchMovie(movie);
    }
}
