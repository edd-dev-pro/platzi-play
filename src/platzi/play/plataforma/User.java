package platzi.play.plataforma;

import platzi.play.contenido.Movie;

public class User {
    public String name;
    public String email;

    public void watchMovie(Movie movie) {
        System.out.println(name + " estás viendo...");
        movie.reproduce();
    }
}
