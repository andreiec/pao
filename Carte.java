public class Carte {
    private String nume;
    private Autor autor;
    private int anLansare;

    public Carte(String nume, Autor autor, int anLansare) {
        this.nume = nume;
        this.autor = autor;
        this.anLansare = anLansare;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public int getAnLansare() {
        return anLansare;
    }

    public void setAnLansare(int anLansare) {
        this.anLansare = anLansare;
    }
}
