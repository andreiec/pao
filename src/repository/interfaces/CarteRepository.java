package repository.interfaces;

import clase.Carte;

import java.util.ArrayList;

public interface CarteRepository {
    void addCarte(Carte carte);
    ArrayList<Carte> getCartiFromSectiuneByID(int sectiuneId);
    ArrayList<Carte> getCartiFromAutorByID(int autorId);
    Carte getCarteByID(int carteId);
    void modifyCarteByID(int carteId, Carte carte);
    void removeCarteByID(int carteId);
}
