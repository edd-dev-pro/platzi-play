package platzi.play.contenido;

public class Movie extends Content {
    public Movie(String title, int duration, Gender movieGenre, double rating) {
        super(title, duration, movieGenre, rating);
    }

    @Override
    public void reproduce() {
        System.out.println("Reproducionedo la película: " + getTitle());
    }
}
