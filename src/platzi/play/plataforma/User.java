package platzi.play.plataforma;

import platzi.play.contenido.Content;

import java.time.LocalDateTime;

public class User {
    public String name;
    public String email;
    public LocalDateTime registrationDate;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.registrationDate = LocalDateTime.now();
    }

    public void watchMovie(Content content) {
        System.out.println(name + " estás viendo...");
        content.reproduce();
    }
}
