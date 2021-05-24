package servicii;

import clase.*;

import java.io.IOException;
import java.util.*;


public class BibliotecaService {
    private TreeSet<Sectiune> sectiuni = new TreeSet<>();
    private HashSet<Cititor> clienti = new HashSet<>();

    public TreeSet<Sectiune> getSectiuni() {
        return sectiuni;
    }

    public void setSectiuni(TreeSet<Sectiune> sectiuni) {
        this.sectiuni = sectiuni;
    }

    public HashSet<Cititor> getClienti() {
        return clienti;
    }

    public void setClienti(HashSet<Cititor> clienti) {
        this.clienti = clienti;
    }


    /* CLIENTI */
    public void addClient(Cititor cititor) throws IOException {
        log("Added Client");
        clienti.add(cititor);
    }

    public void removeClient(Cititor cititor) {
        clienti.remove(cititor);
    }

    public void addClient(String nume, String prenume, int varsta) {
        Cititor cititor = new Cititor(nume, prenume, varsta);
        clienti.add(cititor);
    }

    public void borrowBook(Cititor client, Sectiune sectiune, Carte carte) {
        if (clienti.contains(client)) {
            try {
                sectiune.lowerStoc(carte);
                client.addCartiImprumutate(carte);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Client not registered!");
        }
    }

    public void returnBook(Cititor client, Sectiune sectiune, Carte carte) {
        if (clienti.contains(client)) {
            sectiune.addStoc(carte);
            client.removeCartiImprumutate(carte);
        } else {
            System.out.println("Client not registered!");
        }
    }


    /* SECTIUNI */
    public void newSectiune(String nume) {
        Sectiune s = new Sectiune(nume);
        sectiuni.add(s);
    }

    public void removeSectiune(String nume) {
        sectiuni.removeIf(s -> s.getNume().equals(nume));
    }

    public Sectiune getSectiune(String nume) {
        for (Sectiune s : sectiuni) {
            if (s.getNume().equals(nume)) {
                return s;
            }
        }
        return null;
    }

    public TreeSet<Sectiune> getAllSectiuni() {
        return sectiuni;
    }

    public Set<Carte> getAllBooksFromSection(String nume) {
        for (Sectiune s : sectiuni) {
            if (s.getNume().equals(nume)){
                return s.getAllBooks();
            }
        }
        return null;
    }

    public Set<Carte> getAllBooksFromSection(Sectiune sectiune) {
        return sectiune.getAllBooks();
    }

    public void emptySectiune(String nume) {
        for (Sectiune s : sectiuni) {
            if (s.getNume().equals(nume)){
                s.setAllStoc(new HashMap<Carte, Integer>());
            }
        }
    }

    public void emptySectiune(Sectiune sectiune) {
        sectiune.setAllStoc(new HashMap<Carte, Integer>());
    }

    public void removeAllStockFromSectiune(String nume) {
        for (Sectiune s : sectiuni) {
            if (s.getNume().equals(nume)){
                for (Carte carte : s.getAllBooks()) {
                    s.setStoc(carte, 0);
                }
            }
        }
    }

    public void addStoc(Sectiune sectiune, Carte carte) {
        sectiune.addStoc(carte);
    }

    public void addStoc(Sectiune sectiune, Carte carte, int cantitate) {
        sectiune.addStoc(carte, cantitate);
    }

    public void addStoc(Sectiune sectiune, String nume) {
        for (Carte c : sectiune.getAllBooks()) {
            if (c.getNume().equals(nume)) {
                sectiune.addStoc(c);
            }
        }
    }

    public void addStoc(Sectiune sectiune, String nume, int cantitate) {
        for (Carte c : sectiune.getAllBooks()) {
            if (c.getNume().equals(nume)) {
                sectiune.addStoc(c, cantitate);
            }
        }
    }

    public void addStoc(String sectiune, String nume) {
        for (Sectiune s : sectiuni) {
            if (s.getNume().equals(sectiune)) {
                for (Carte c : s.getAllBooks()) {
                    if (c.getNume().equals(nume)) {
                        s.addStoc(c);
                    }
                }
            }
        }
    }

    public void addStoc(String sectiune, String nume, int cantitate) {
        for (Sectiune s : sectiuni) {
            if (s.getNume().equals(sectiune)) {
                for (Carte c : s.getAllBooks()) {
                    if (c.getNume().equals(nume)) {
                        s.addStoc(c, cantitate);
                    }
                }
            }
        }
    }

    public void lowerStoc(Sectiune sectiune, Carte carte) throws Exception {
        try {
            sectiune.lowerStoc(carte);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void lowerStoc(Sectiune sectiune, Carte carte, int cantitate) throws Exception {
        try {
            sectiune.lowerStoc(carte, cantitate);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    /* CARTI */
    public void newCarte(String nume, String sectiune, Autor autor, int anLansare) {
        Carte c = new Carte(nume, autor, anLansare);

        for (Sectiune s : sectiuni) {
            if (s.getNume().equals(sectiune)) {
                s.addStoc(c);
            }
        }
    }

    public void newCarte(String nume, Sectiune sectiune, Autor autor, int anLansare) {
        Carte c = new Carte(nume, autor, anLansare);
        sectiune.addStoc(c);
    }

    public void removeCarte(String nume) throws Exception {
        for (Sectiune s : sectiuni) {
            for (Carte c : s.getAllBooks()) {
                if (c.getNume().equals(nume)) {
                    s.removeStoc(c);
                    return;
                }
            }
        }
    }

    public void removeCarte(Carte c) throws Exception {
        for (Sectiune s : sectiuni) {
            try {
                s.removeStoc(c);
            } catch (Exception ignored) { }
        }
    }

    public Vector<Carte> getAllCarti() {
        Vector<Carte> carti = new Vector<>();
        
        for (Sectiune s : sectiuni) {
            carti.addAll(s.getAllBooks());
        }
        
        return carti;
    }

    public void addRecenzie(Carte c, Recenzie r) {
        c.addRecenzie(r);
    }

    /* LOGGING */
    public void log(String command) throws IOException {
        LoggingService.getInstance().newLine(command);
    }
}
