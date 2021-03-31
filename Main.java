import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws Exception {
        Biblioteca b = new Biblioteca("Biblioteca Matematica-Informatica");
        Autor a1 = new Autor("Petrescu", "Marcel", 24, 3);
        Autor a2 = new Autor("Gaina", "Radu", 23, 2);
        Autor a3 = new Autor("Jackson", "Michael", 44, 5);


        b.addClient("Constantinescu", "Andrei", 20);
        b.addClient("Filip", "Alexandru", 19);
        b.addClient("Tudose", "Adrian", 21);

        b.newSectiune("Fictiune");
        b.newSectiune("Sci-Fi");
        b.newSectiune("Istorie");
        b.newSectiune("Beletristica");
        b.newSectiune("Romanta");

        b.newCarte("Harry Potter", "Fictiune", a1, 2001);
        b.newCarte("Harry Potter 2", "Fictiune", a1, 2002);
        b.newCarte("Harry Potter 3", "Fictiune", a1, 2004);

        b.newCarte("Istoria Romaniei 1", "Istorie", a2, 1999);
        b.newCarte("Istoria Romaniei 2", "Istorie", a2, 2000);

        b.newCarte("Orasul", "Beletristica", a3,2013);
        b.newCarte("Dealuri Inalte", "Beletristica", a3,2014);
        b.newCarte("Orasul 2", "Beletristica", a3,2015);
        b.newCarte("Incercarea unui mit", "Beletristica", a3,2017);
        b.newCarte("Falsul", "Beletristica", a3,2019);

        for (Carte c : b.getAllBooksFromSection("Beletristica")) {
            System.out.println(c.getNume());
        }


        b.addStoc("Beletristica", "Orasul", 10);
        b.addStoc("Beletristica", "Dealuri Inalte", 7);
        for (Carte c : b.getSectiune("Beletristica").getAllStoc().keySet()) {
            System.out.println(b.getSectiune("Beletristica").getAllStoc().get(c));
        }


        b.removeCarte("Istoria Romaniei 1");
        for(Carte c : b.getSectiune("Istorie").getAllBooks()) {
            System.out.println(c.getNume());
        }
    }

}
