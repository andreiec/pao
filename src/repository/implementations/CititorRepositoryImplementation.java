package repository.implementations;

import clase.Cititor;
import clase.Sectiune;
import repository.interfaces.CititorRepository;
import utils.JDBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CititorRepositoryImplementation implements CititorRepository {

    JDBConnection connection = JDBConnection.getInstance();

    @Override
    public void addCititor(Cititor cititor) {
        try {
            PreparedStatement preparedStatement = connection.getDBConnection().prepareStatement("INSERT INTO cititori (nume, prenume, varsta) VALUES ('" + cititor.getNume() + "', '" + cititor.getPrenume() + "', '"  + cititor.getVarsta() + "' )");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Insertion complete - Added: " + cititor.getNume() + " to CITITORI");
        }
    }

    @Override
    public ArrayList<Cititor> getCititori() {
        ArrayList<Cititor> arr = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.getDBConnection().prepareStatement("SELECT * FROM cititori");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                arr.add(new Cititor(resultSet.getString("nume"), resultSet.getString("prenume"), resultSet.getInt("varsta")));
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
    public Cititor getCititorByID(int cititorId) {
        try {
            PreparedStatement preparedStatement = connection.getDBConnection().prepareStatement("SELECT * FROM cititori WHERE id=" + cititorId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Cititor(resultSet.getString("nume"), resultSet.getString("prenume"), resultSet.getInt("varsta"));
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            System.out.println("Return complete - got ID: " + cititorId);
        }
    }

    @Override
    public void modifyCititorByID(int cititorId, Cititor cititor) {
        try {
            PreparedStatement preparedStatement = connection.getDBConnection().prepareStatement("UPDATE cititori SET nume=\"" + cititor.getNume() + "\", prenume=\"" + cititor.getPrenume() + "\", varsta=\"" + cititor.getVarsta() + "\" WHERE id=" + cititorId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Updated entry with ID: " + cititorId);
        }
    }

    @Override
    public void removeCititorbyID(int cititorId) {
        try {
            PreparedStatement preparedStatement = connection.getDBConnection().prepareStatement("DELETE FROM cititori WHERE id=" + cititorId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Removed row with ID: " + cititorId);
        }
    }
}
