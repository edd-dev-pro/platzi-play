package platzi.play;

import platzi.play.contenido.Movie;
import platzi.play.plataforma.User;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        System.out.println("Platzi Play 🍿");

        Movie movie = new Movie();

        movie.title = "El Señor de los Anillos";
        movie.yearOfRelease = 2001;
        movie.movieGenre = "Fantasía";
        movie.rateMovie(4.7);

        User user = new User();
        user.name = "Eduardo";

        user.watchMovie(movie);


    }
}
