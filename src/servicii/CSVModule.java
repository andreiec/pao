package servicii;

import java.io.*;
import java.util.Arrays;
import java.util.Vector;


public class CSVModule {

    private CSVModule() {}

    private static CSVModule instance = null;

    public static CSVModule getInstance() {
        if (instance == null) {
            instance = new CSVModule();
        }
        return instance;
    }

    public Vector<Vector<String>> readFromCSV(String file) {
        BufferedReader reader = null;
        String line = "";
        Vector<Vector<String>> values = new Vector<>();

        try {
            reader = new BufferedReader(new FileReader(file));
            String header = reader.readLine(); // skip first line

            while((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                Vector<String> rowVals = new Vector<>(Arrays.asList(row));
                values.add(rowVals);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return values;
    }

    public void saveToCSV(Vector<Vector<String>> lines, String file) {
        BufferedWriter writer = null;

        try {
            if (file.lastIndexOf ("/") != -1) {
                String path = file.substring(0, file.lastIndexOf("/"));
                File f = new File(path);
                if (!f.mkdir())
                    System.err.println ("Could not create file!");
            }

            writer = new BufferedWriter(new FileWriter(file));

            for (Vector<String> row : lines) {
                for (int i = 0; i < row.size(); i++) {
                    writer.write(row.get(i));
                    if (i != row.size() - 1) {
                        writer.write(",");
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
