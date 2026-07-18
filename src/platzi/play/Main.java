package platzi.play;

import platzi.play.contenido.Movie;
import platzi.play.plataforma.Platform;
import platzi.play.plataforma.User;
import platzi.play.util.ScannerUtils;

public class Main {
    public static final String PLATFORM_NAME = "Platzi Play";
    public static final String VERSION = "1.0.0";

    public static final int ADD_MOVIE = 1;
    public static final int SHOW_CONTENT = 2;
    public static final int SEARCH_BY_TITLE = 3;
    public static final int REMOVE_MOVIE = 4;
    public static final int GO_OUT = 5;


    static void main(String[] args) {
        Platform platform = new Platform(PLATFORM_NAME);

        System.out.println(PLATFORM_NAME + " - " + VERSION);

        uploadMovies(platform);

        while (true) {
            int optionNumber = ScannerUtils.getNumber("""
                Ingrese una de las siguientes opciones: 
                1. Agregar película.
                2. Mostrar todo el catálogo.
                3. Buscar por título.
                4. Eliminar película.
                5. Salir.
            """);

            System.out.println("Opción elegida: " + optionNumber);

            switch (optionNumber) {
                case ADD_MOVIE -> {
                    String title = ScannerUtils.getText("Nombre del contenido");
                    String movieGenre = ScannerUtils.getText("Género del contenido");
                    int duration = ScannerUtils.getNumber("Duración del contenido");
                    double rating = ScannerUtils.getDecimal("Calificación del contenido");

                    platform.addMovie(new Movie(title, duration, movieGenre, rating));
                }
                case SHOW_CONTENT -> {
                    platform.showTitles();
                }
                case SEARCH_BY_TITLE -> {
                    String title = ScannerUtils.getText("¿Cuál titulo estás buscando?");
                    Movie movie = platform.searchByTitle(title);

                    if (movie != null) {
                        System.out.println(movie.getTechnicalSpecifications());
                    } else {
                        System.out.println(title + " no se encuentra en nuestro catálogo de " + platform.getName());
                    }
                }
                case REMOVE_MOVIE -> {
                    String title = ScannerUtils.getText("¿Cuál es el título que se eliminará?");
                    Movie movie = platform.searchByTitle(title);

                    if (movie != null) {
                        platform.removeMovie(movie);
                        System.out.println("El títlulo " + title + " se ha eliminado.");
                    } else {
                        System.out.println("El títlulo " + title + " no se encuentra en nuestro catálogo de " + platform.getName() + ", no se puede eliminar.");
                    }
                }
                case GO_OUT -> {
                    System.exit(0);
                }
            }
        }
    }

    private static void uploadMovies(Platform platform) {
        platform.addMovie(new Movie("Shrek", 90, "Animada"));
        platform.addMovie(new Movie("Inception", 148, "Ciencia Ficción"));
        platform.addMovie(new Movie("Titanic", 195, "Drama", 4.6));
        platform.addMovie(new Movie("John Wick", 101, "Acción"));
        platform.addMovie(new Movie("El Conjuro", 112, "Terror", 3.0));
        platform.addMovie(new Movie("Coco", 105, "Animada", 4.7));
        platform.addMovie(new Movie("Interstellar", 169, "Ciencia Ficción", 5));
        platform.addMovie(new Movie("Joker", 122, "Drama"));
        platform.addMovie(new Movie("Toy Story", 81, "Animada", 4.5));
        platform.addMovie(new Movie("Avengers: Endgame", 181, "Acción", 3.9));
    }
}
