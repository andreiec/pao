package clase;

public class Recenzie {

    private int scor;
    private String autor;
    private String mesaj;

    public Recenzie(int scor, String autor, String mesaj) {
        this.scor = scor;
        this.autor = autor;
        this.mesaj = mesaj;
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
}
