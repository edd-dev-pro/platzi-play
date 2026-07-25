package platzi.play.exception;

public class ExistingFilmException extends RuntimeException { // class to create exceptions
    public ExistingFilmException(String title) {
        super("La película " + title + " ya existe.");
    }

}
