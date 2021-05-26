package repository.interfaces;

import clase.Recenzie;

import java.util.ArrayList;

public interface RecenzieRepository {
    void addRecenzie(Recenzie recenzie);
    ArrayList<Recenzie> getRecenziiFromCarteByID(int carteId);
    Recenzie getRecenzieByID(int recenzieId);
    void modifyRecenzieByID(int recenzieId, Recenzie recenzie);
    void removeRecenzieID(int recenzieId);
}
