package repository.interfaces;

import clase.Autor;

import java.util.ArrayList;

public interface AutorRepository {
    void addAutor(Autor autor);
    ArrayList<Autor> getAutori();
    Autor getAutorByID(int autorId);
    void modifyAutorByID(int autorId, Autor autor);
    void removeAutorbyID(int autorId);
}
