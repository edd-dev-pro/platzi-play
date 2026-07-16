package platzi.play.contenido;

public class Movie {
    public String title;
    public String description;
    public int duration;
    public String movieGenre;
    public int yearOfRelease;
    public double rating;
    public boolean available;

    public void reproduce() {
        System.out.println("Reproduciendo " + title);
    }

    public String getTechnicalSpecifications() {
        return title + " (" + yearOfRelease + ")\n" +
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
