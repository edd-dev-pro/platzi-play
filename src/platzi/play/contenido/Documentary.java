package platzi.play.contenido;

public class Documentary extends Content implements Promotion {
    private String narrator;

    public Documentary(String title, int duration, Gender movieGenre) {
        super(title, duration, movieGenre);
    }

    public Documentary(String title, int duration, Gender movieGenre, double rating, String narrator) {
        super(title, duration, movieGenre, rating);
        this.narrator = narrator;
    }

    @Override
    public void reproduce() {
        System.out.println("Reproduciendo el documental " + getTitle() + " narrado por " + getNarrator() + "...");
    }

    @Override
    public String promote() {
        return "Descubre el documental " + this.getTitle() + " narrado por " + narrator + ". ¡Ahora en PlatziPlay!";
    }

    public String getNarrator() {
        return narrator;
    }
}
