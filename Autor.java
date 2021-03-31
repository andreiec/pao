public class Autor extends Persoana{

    private int numarCarti;

    public Autor(String nume, String prenume, int varsta, int numarCarti) {
        super(nume, prenume, varsta);
        this.numarCarti = numarCarti;
    }

    public int getNumarCarti() {
        return numarCarti;
    }

    public void setNumarCarti(int numarCarti) {
        this.numarCarti = numarCarti;
    }
}
