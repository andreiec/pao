import clase.*;
import servicii.BibliotecaService;
import servicii.CSVModule;
import servicii.LoggingService;

import java.util.Vector;

public class Main {

    public static void main(String[] args) throws Exception {
        BibliotecaService b = new BibliotecaService();
        CSVModule csvModule = CSVModule.getInstance();

        /* Etapa 2 DEMO
        b.addClient(new Cititor("Macanache", "Deliric", 21));
        csvModule.readFromCSV("src\\date\\carti.csv");
        csvModule.saveToCSV(new Vector<Vector<String>>(), "src\\date\\csvModuleTest.csv");
         */

        LoggingService log = LoggingService.getInstance();
        log.closeFile();
    }

}
