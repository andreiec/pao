package clase;

import java.util.Vector;

public class Carte {
    private String nume;
    private Autor autor;
    private int anLansare;
    private int sectiuneId;
    private int autorId;
    private Vector<Recenzie> recenzii;

    public Carte(String nume, Autor autor, int anLansare) {
        this.nume = nume;
        this.autor = autor;
        this.anLansare = anLansare;
    }

    public Carte(String nume, Autor autor, int anLansare, Vector<Recenzie> recenzii) {
        this.nume = nume;
        this.autor = autor;
        this.anLansare = anLansare;
        this.recenzii = recenzii;
    }

    public Carte(String nume, int anLansare, int autorId, int sectiuneId) {
        this.nume = nume;
        this.autorId = autorId;
        this.anLansare = anLansare;
        this.sectiuneId = sectiuneId;
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

    public Vector<Recenzie> getRecenzii() {
        return recenzii;
    }

    public void setRecenzii(Vector<Recenzie> recenzii) {
        this.recenzii = recenzii;
    }

    public void addRecenzie(Recenzie r) {
        recenzii.add(r);
    }

    public int getSectiuneId() {
        return sectiuneId;
    }

    public void setSectiuneId(int sectiuneId) {
        this.sectiuneId = sectiuneId;
    }

    public int getAutorId() {
        return autorId;
    }

    public void setAutorId(int autorId) {
        this.autorId = autorId;
    }

}
