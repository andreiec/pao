package servicii;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Vector;

public class LoggingService {

    private static LoggingService instance = null;
    private BufferedWriter writer;

    private LoggingService() throws IOException {
        writer = new BufferedWriter(new FileWriter("log.csv"));
        writer.write("nume_actiune,timestamp\n");
    }

    public static LoggingService getInstance() throws IOException {
        if (instance == null) {
            instance = new LoggingService();
        }
        return instance;
    }

    public void newLine(String line) throws IOException {
        Date date = new Date();
        writer.write(line + "," + new Timestamp(date.getTime()) + "\n");
    }

    public void closeFile() throws IOException {
        writer.close();
    }

}
