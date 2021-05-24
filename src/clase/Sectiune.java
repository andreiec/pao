package clase;

import java.util.HashMap;
import java.util.Set;

public class Sectiune implements Comparable<Sectiune> {
    private String nume;
    private HashMap<Carte, Integer> stoc;

    public Sectiune(String nume) {
        this.nume = nume;
        this.stoc = new HashMap<Carte, Integer>();
    }

    public Sectiune(String nume, HashMap<Carte, Integer> carti) {
        this.nume = nume;
        this.stoc = carti;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public HashMap<Carte, Integer> getAllStoc() {
        return stoc;
    }

    public Set<Carte> getAllBooks() { return stoc.keySet(); }

    public void setAllStoc(HashMap<Carte, Integer> carti) {
        this.stoc = carti;
    }

    public void setStoc(Carte carte, int cantitate) {
        stoc.put(carte, cantitate);
    }

    public void addStoc(Carte carte) {
        if (stoc.containsKey(carte)) {
            stoc.put(carte, stoc.get(carte) + 1);
        } else {
            stoc.put(carte, 1);
        }
    }

    public void addStoc(Carte carte, int cantitate) {
        if (stoc.containsKey(carte)) {
            stoc.put(carte, stoc.get(carte) + cantitate);
        } else {
            stoc.put(carte, cantitate);
        }
    }

    public void removeStoc(Carte carte) throws Exception{
        if (stoc.containsKey(carte)) {
            stoc.remove(carte);
        } else {
            throw new Exception("Book not in stock!");
        }
    }

    public void lowerStoc(Carte carte) throws Exception{
        if (stoc.containsKey(carte)) {
            if (stoc.get(carte) - 1 >= 0) {
                stoc.put(carte, stoc.get(carte) - 1);
            } else {
                throw new Exception("Stock cannot be lower than 0!");
            }
        } else {
            throw new Exception("Book not in stock!");
        }
    }

    public void lowerStoc(Carte carte, int cantitate) throws Exception{
        if (stoc.containsKey(carte)) {
            if (stoc.get(carte) - cantitate >= 0) {
                stoc.put(carte, stoc.get(carte) - cantitate);
            } else {
                throw new Exception("Stock cannot be lower than 0!");
            }
        } else {
            throw new Exception("Book not in stock!");
        }
    }

    @Override
    public int compareTo(Sectiune o) {
        return nume.compareTo(o.getNume());
    }
}
