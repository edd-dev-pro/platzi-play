package platzi.play.plataforma;

import platzi.play.contenido.Movie;

import java.time.LocalDateTime;

public class User {
    public String name;
    public String email;
    public LocalDateTime registrationDate;

    public void watchMovie(Movie movie) {
        System.out.println(name + " estás viendo...");
        movie.reproduce();
    }
}
