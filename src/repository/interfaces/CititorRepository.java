package repository.interfaces;

import clase.Cititor;

import java.util.ArrayList;

public interface CititorRepository {
    void addCititor(Cititor cititor);
    ArrayList<Cititor> getCititori();
    Cititor getCititorByID(int cititorId);
    void modifyCititorByID(int cititorId, Cititor cititor);
    void removeCititorbyID(int cititorId);
}
