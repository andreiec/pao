package clase;

import java.util.HashSet;

public class Cititor extends Persoana{

    private HashSet<Carte> cartiImprumutate;

    public Cititor(String nume, String prenume, int varsta) {
        super(nume, prenume, varsta);
        this.cartiImprumutate = new HashSet<Carte>();
    }

    public Cititor(String nume, String prenume, int varsta, int numarCartiImprumutate, HashSet<Carte> cartiImprumutate) {
        super(nume, prenume, varsta);
        this.cartiImprumutate = cartiImprumutate;
    }

    public HashSet<Carte> getCartiImprumutate() {
        return cartiImprumutate;
    }

    public void setCartiImprumutate(HashSet<Carte> cartiImprumutate) {
        this.cartiImprumutate = cartiImprumutate;
    }

    public void addCartiImprumutate(Carte carte) {
        cartiImprumutate.add(carte);
    }

    public void removeCartiImprumutate(Carte carte) {
        cartiImprumutate.remove(carte);
    }
}
