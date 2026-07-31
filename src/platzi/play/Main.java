package platzi.play;

import platzi.play.contenido.ContentSummary;
import platzi.play.contenido.Gender;
import platzi.play.contenido.Movie;
import platzi.play.exception.ExistingFilmException;
import platzi.play.plataforma.Platform;
import platzi.play.util.FileUtils;
import platzi.play.util.ScannerUtils;

import java.util.List;

public class Main {
    public static final String PLATFORM_NAME = "Platzi Play";
    public static final String VERSION = "1.0.0";

    public static final int ADD_MOVIE = 1;
    public static final int SHOW_CONTENT = 2;
    public static final int SEARCH_BY_TITLE = 3;
    public static final int SEARCH_BY_GENDER = 4;
    public static final int MOST_POPULAR_ONES = 5;
    public static final int PLAY_MOVIE = 6;
    public static final int REMOVE_MOVIE = 8;
    public static final int GO_OUT = 9;


    static void main(String[] args) {
        Platform platform = new Platform(PLATFORM_NAME);

        System.out.println(PLATFORM_NAME + " - v" + VERSION + "\n");

        uploadMovies(platform);

        System.out.println("Más de " + platform.totalDurationOfcontent() + " minutos de contenido \n");

        while (true) {
            int optionNumber = ScannerUtils.getNumber("""
                Ingrese una de las siguientes opciones: 
                1. Agregar película.
                2. Mostrar todo el catálogo.
                3. Buscar por título.
                4. Buscar por género.
                5. Ver los más populares.
                6. Reproducir.
                8. Eliminar película.
                9. Salir.
            """);

            System.out.println("Opción elegida: " + optionNumber);

            switch (optionNumber) {
                case ADD_MOVIE -> {
                    String title = ScannerUtils.getText("Nombre del contenido");
                    Gender movieGenre = ScannerUtils.getGender("Género del contenido");
                    int duration = ScannerUtils.getNumber("Duración del contenido");
                    double rating = ScannerUtils.getDecimal("Calificación del contenido");

                    try {
                        platform.addMovie(new Movie(title, duration, movieGenre, rating));
                    } catch (ExistingFilmException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case SHOW_CONTENT -> {
                    // List<String> titles = platform.getTitles();
                    // titles.forEach(System.out::println);

                    List<ContentSummary> summaries = platform.getSummary();
                    summaries.forEach(contentSummary -> System.out.println(contentSummary.toString()));
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
                case SEARCH_BY_GENDER -> {
                    Gender gender = ScannerUtils.getGender("Género del contenido a buscar");
                    List<Movie> content = platform.searchByGender(gender);

                    System.out.println(content.size() + " resutado(s) encontrados para el género " + gender);
                    content.forEach(movie -> System.out.println(movie.getTechnicalSpecifications() + "\n"));
                }
                case MOST_POPULAR_ONES -> {
                    int num = ScannerUtils.getNumber("Cantidad de resultados a mostrar");
                    List<Movie> popularMovies = platform.getMostPopularOnes(num);
                    popularMovies.forEach(movie -> System.out.println(movie.getTechnicalSpecifications() + "\n"));
                }
                case PLAY_MOVIE -> {
                    String name = ScannerUtils.getText("Nombre del contenido a reproducir");
                    Movie movie = platform.searchByTitle(name);

                    if (movie != null) {
                        platform.playMovie(movie);
                    } else {
                        System.out.println(name + " no existe.");
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

    // private static void uploadMovies(Platform platform) throws IOException { // question
    private static void uploadMovies(Platform platform) {
        platform.getContent().addAll(FileUtils.readFile());
    }
}
