package platzi.play.util;

import platzi.play.contenido.Content;
import platzi.play.contenido.Documentary;
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
    public static final String SEPARATOR = "|";

    public static void writeToFile(Content content) {
       String line = String.join(
               SEPARATOR,
               content.getTitle(),
               String.valueOf(content.getDuration()),
               content.getMovieGenre().name(),
               String.valueOf(content.getRating()),
               content.getReleaseDate().toString()
       );

       String finalLine;

       if(content instanceof Documentary documentary) { // pattern variable
           // Documentary documentary = (Documentary) content; // using the pattern variable, we can remove that line
           finalLine = "DOCUMENTAL" + SEPARATOR + line + SEPARATOR + documentary.getNarrator();
       } else {
           finalLine = "PELICULA" + SEPARATOR + line;
       }

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
                String [] data = line.split("\\" + SEPARATOR);

                String typeContent = data[0];

                if (("PELICULA".equals(typeContent) && data.length == 6) || ("DOCUMENTAL".equals(typeContent) && data.length == 7)) {
                    String title = data[1];
                    int duration = Integer.parseInt(data[2]);
                    Gender gender = Gender.valueOf(data[3].toUpperCase());
                    double rating = data[4].isBlank() ? 0 : Double.parseDouble(data[4]);
                    LocalDate releaseDate = LocalDate.parse(data[5]);

                    Content content;

                    if("PELICULA".equals(typeContent)) {
                        content = new Movie(title, duration, gender, rating);
                    } else {
                        String narrator = data[6];
                        content = new Documentary(title, duration, gender, rating, narrator);
                    }

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
