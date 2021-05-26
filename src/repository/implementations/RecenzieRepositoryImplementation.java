package repository.implementations;

import clase.Autor;
import clase.Recenzie;
import repository.interfaces.RecenzieRepository;
import utils.JDBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecenzieRepositoryImplementation implements RecenzieRepository {

    JDBConnection connection = JDBConnection.getInstance();

    @Override
    public void addRecenzie(Recenzie recenzie) {
        try {
            PreparedStatement preparedStatement = connection.getDBConnection().prepareStatement("INSERT INTO recenzii (scor, autor, mesaj, id_carte) VALUES ('" + recenzie.getScor() + "', '" + recenzie.getAutor() + "', '"  + recenzie.getMesaj() + "', '"  + recenzie.getIdCarte() + "' )");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Insertion complete - Added: " + recenzie.getMesaj() + " to RECENZII");
        }
    }

    @Override
    public ArrayList<Recenzie> getRecenziiFromCarteByID(int carteId) {
        ArrayList<Recenzie> arr = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.getDBConnection().prepareStatement("SELECT * FROM recenzii WHERE id_carte=" + carteId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                arr.add(new Recenzie(resultSet.getInt("scor"), resultSet.getString("autor"), resultSet.getString("mesaj"), resultSet.getInt("id_carte")));
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
    public Recenzie getRecenzieByID(int recenzieId) {
        try {
            PreparedStatement preparedStatement = connection.getDBConnection().prepareStatement("SELECT * FROM recenzii WHERE id=" + recenzieId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Recenzie(resultSet.getInt("scor"), resultSet.getString("autor"), resultSet.getString("mesaj"), resultSet.getInt("id_carte"));
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            System.out.println("Return complete - got ID: " + recenzieId);
        }
    }

    @Override
    public void modifyRecenzieByID(int recenzieId, Recenzie recenzie) {
        try {
            PreparedStatement preparedStatement = connection.getDBConnection().prepareStatement("UPDATE recenzii SET scor=\"" + recenzie.getScor() + "\", autor=\"" + recenzie.getAutor() + "\", mesaj=\"" + recenzie.getMesaj() + "\", id_carte=\"" + recenzie.getIdCarte() + "\" WHERE id=" + recenzieId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Updated entry with ID: " + recenzieId);
        }
    }

    @Override
    public void removeRecenzieID(int recenzieId) {
        try {
            PreparedStatement preparedStatement = connection.getDBConnection().prepareStatement("DELETE FROM recenzii WHERE id=" + recenzieId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Removed row with ID: " + recenzieId);
        }
    }
}
