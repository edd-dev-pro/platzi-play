package platzi.play.exception;

public class ExistingFilmException extends RuntimeException { // class to create exceptions
    public ExistingFilmException(String title) {
        super("La contenido " + title + " ya existe.");
    }

}
