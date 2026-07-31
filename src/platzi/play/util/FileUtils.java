package platzi.play.util;

import platzi.play.contenido.Content;
import platzi.play.contenido.Gender;

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

    public static void writeToFile(Content content) {
       String line = String.join(
               SEPAEATOR,
               content.getTitle(),
               String.valueOf(content.getDuration()),
               content.getMovieGenre().name(),
               String.valueOf(content.getRating()),
               content.getReleaseDate().toString()
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

    public static List<Content> readFile() {
        List<Content> archiveContents = new ArrayList<>();

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

                    Content content = new Content(title, duration, gender, rating);
                    content.setReleaseDate(releaseDate);

                    archiveContents.add(content);
                }
            });
        } catch (IOException e) {
            System.out.println("Error leyendo el archivo. " + e.getMessage());
        }

        return archiveContents;
    }
}
