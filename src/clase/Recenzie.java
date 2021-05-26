package clase;

public class Recenzie {

    private int scor;
    private String autor;
    private String mesaj;
    private int id_carte;


    public Recenzie(int scor, String autor, String mesaj, int id_carte) {
        this.scor = scor;
        this.autor = autor;
        this.mesaj = mesaj;
        this.id_carte = id_carte;
    }

    public int getScor() {
        return scor;
    }

    public void setScor(int scor) {
        this.scor = scor;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public int getIdCarte() {
        return id_carte;
    }

    public void setIdCarte(int id_carte) {
        this.id_carte = id_carte;
    }
}
