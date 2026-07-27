package platzi.play.util;

import platzi.play.contenido.Gender;
import platzi.play.contenido.Movie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static final String FILE_NAME = "content.txt";
    public static final String SEPAEATOR = "|";

    public static void writeToFile(Movie movie) {
       String line = String.join(
               SEPAEATOR,
               movie.getTitle(),
               String.valueOf(movie.getDuration()),
               movie.getMovieGenre().name(),
               String.valueOf(movie.getRating()),
               movie.getReleaseDate().toString()
       );

       try {
           Files.writeString(
                   Paths.get(FILE_NAME),
                   line + System.lineSeparator(),
                   StandardOpenOption.CREATE,
                   StandardOpenOption.APPEND
           );
       } catch (IOException e) {
           System.out.println("Error escribiendo el archivo. " + e.getMessage());
        }
    }

    public static List<Movie> readFile() {
        List<Movie> archiveMovies = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(FILE_NAME));
            System.out.println("¿Qué se guarda en líneas? " + lines);

            lines.forEach(line -> {
                String [] datas = line.split("\\" +SEPAEATOR);

                if (datas.length == 5) {
                    String title = datas[0];
                    int duration = Integer.parseInt(datas[1]);
                    Gender gender = Gender.valueOf(datas[2].toUpperCase());
                    double rating = datas[3].isBlank() ? 0 : Double.parseDouble(datas[3]);
                    LocalDate releaseDate = LocalDate.parse(datas[4]);

                    Movie movie = new Movie(title, duration, gender, rating);
                    movie.setReleaseDate(releaseDate);

                    archiveMovies.add(movie);
                }
            });
        } catch (IOException e) {
            System.out.println("Error leyendo el archivo. " + e.getMessage());
        }

        return archiveMovies;
    }
}
