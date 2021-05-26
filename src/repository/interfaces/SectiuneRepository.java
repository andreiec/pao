package repository.interfaces;

import clase.Sectiune;

import java.util.ArrayList;

public interface SectiuneRepository {
    void addSectiune(Sectiune sectiune);
    ArrayList<Sectiune> getSectiuni();
    Sectiune getSectiuneByID(int sectiuneId);
    void modifySectiuneByID(int sectiuneId, Sectiune sectiune);
    void removeSectiunebyID(int sectiuneId);

}
