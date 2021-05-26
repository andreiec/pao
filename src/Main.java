import clase.*;
import repository.implementations.CititorRepositoryImplementation;
import repository.implementations.SectiuneRepositoryImplementation;
import repository.interfaces.CititorRepository;
import repository.interfaces.SectiuneRepository;
import servicii.BibliotecaService;
import servicii.CSVModule;
import servicii.LoggingService;
import utils.JDBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class Main {

    private static SectiuneRepository sectiuneRepository = new SectiuneRepositoryImplementation();
    private static CititorRepository cititorRepository = new CititorRepositoryImplementation();

    public static void main(String[] args) throws Exception {
        BibliotecaService b = new BibliotecaService();
        CSVModule csvModule = CSVModule.getInstance();

        /* Etapa 2

        #### DEMO ####

        b.addClient(new Cititor("Macanache", "Deliric", 21));
        csvModule.readFromCSV("src\\date\\carti.csv");
        csvModule.saveToCSV(new Vector<Vector<String>>(), "src\\date\\csvModuleTest.csv");

         */


        /* Etapa 3

        #### DEMO 1 ####

        ~ Testare conexiune
        Connection con = JDBConnection.getInstance().getDBConnection();
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from carti");

        while(resultSet.next()) {
            System.out.println(resultSet.getNume());
        }

        ~ Create
        sectiuneRepository.addSectiune(new Sectiune("Carti de desenat"));

        ~ Read
        ArrayList<Sectiune> sect = sectiuneRepository.getSectiuni();

        for (Sectiune s : sect) {
            System.out.println(s.getNume());
        }

        ~ Read by ID
        System.out.println(sectiuneRepository.getSectiuneByID(2).getNume());

        ~ Update
        sectiuneRepository.modifySectiuneByID(8, new Sectiune("Novele"));

        ~ Delete
        sectiuneRepository.addSectiune(new Sectiune("Testare Stergere 10000"));
        sectiuneRepository.removeSectiunebyID(10);



        #### DEMO 2 ####

        ~ Create
        cititorRepository.addCititor(new Cititor("Constantinescu", "Dembele", 13));

        ~ Read
        ArrayList<Cititor> citi = cititorRepository.getCititori();

        for (Cititor c : citi) {
            System.out.println(c.getNume() + " " + c.getPrenume() + " " + c.getVarsta());
        }

        ~ Read by ID
        System.out.println(cititorRepository.getCititorByID(2).getNume());

        ~ Update
        cititorRepository.modifyCititorByID(6, new Cititor("Cociobanu", "Victor", 22));

        ~ Delete
        cititorRepository.addCititor(new Cititor("Testare", "Stergere", 1000));
        sectiuneRepository.removeSectiunebyID(7);

        */


        LoggingService log = LoggingService.getInstance();
        log.closeFile();
    }

}
