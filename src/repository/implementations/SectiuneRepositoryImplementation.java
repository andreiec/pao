package repository.implementations;

import clase.Sectiune;
import repository.interfaces.SectiuneRepository;
import utils.JDBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SectiuneRepositoryImplementation implements SectiuneRepository {

    JDBConnection connection = JDBConnection.getInstance();

    @Override
    public void addSectiune(Sectiune sectiune) {
        try {
            PreparedStatement preparedStatement = connection.getDBConnection().prepareStatement("INSERT INTO sectiuni (nume) VALUES ('" + sectiune.getNume() + "')");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Insertion complete - Added: " + sectiune.getNume() + " to SECTIUNI");
        }
    }

    @Override
    public ArrayList<Sectiune> getSectiuni() {
        ArrayList<Sectiune> arr = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.getDBConnection().prepareStatement("SELECT * FROM sectiuni");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                arr.add(new Sectiune(resultSet.getString("nume")));
            }
            return arr;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            System.out.println("Return complete - got " + arr.size() + " items");
        }
    }

    @Override
    public Sectiune getSectiuneByID(int sectiuneId) {
        try {
            PreparedStatement preparedStatement = connection.getDBConnection().prepareStatement("SELECT * FROM sectiuni WHERE id=" + sectiuneId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Sectiune(resultSet.getString("nume"));
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            System.out.println("Return complete - got ID: " + sectiuneId);
        }
    }

    @Override
    public void modifySectiuneByID(int sectiuneId, Sectiune sectiune) {
        try {
            PreparedStatement preparedStatement = connection.getDBConnection().prepareStatement("UPDATE sectiuni SET nume=\"" + sectiune.getNume() + "\" WHERE id=" + sectiuneId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Updated entry with ID: " + sectiuneId);
        }
    }

    @Override
    public void removeSectiunebyID(int sectiuneId) {
        try {
            PreparedStatement preparedStatement = connection.getDBConnection().prepareStatement("DELETE FROM sectiuni WHERE id=" + sectiuneId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Removed row with ID: " + sectiuneId);
        }
    }

}
