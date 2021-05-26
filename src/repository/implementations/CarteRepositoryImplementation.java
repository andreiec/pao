package repository.implementations;

import clase.Carte;
import clase.Recenzie;
import repository.interfaces.CarteRepository;
import utils.JDBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarteRepositoryImplementation implements CarteRepository {

    JDBConnection connection = JDBConnection.getInstance();

    @Override
    public void addCarte(Carte carte) {
        try {
            PreparedStatement preparedStatement = connection.getDBConnection().prepareStatement("INSERT INTO carti (nume, an_lansare, autor_id, sectiune_id) VALUES ('" + carte.getNume() + "', '" + carte.getAnLansare() + "', '"  + carte.getAutorId() + "', '"  + carte.getSectiuneId() + "' )");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Insertion complete - Added: " + carte.getNume() + " to CARTI");
        }
    }

    @Override
    public ArrayList<Carte> getCartiFromSectiuneByID(int sectiuneId) {
        ArrayList<Carte> arr = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.getDBConnection().prepareStatement("SELECT * FROM carti WHERE sectiune_id=" + sectiuneId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                arr.add(new Carte(resultSet.getString("nume"), resultSet.getInt("an_lansare"), resultSet.getInt("autor_id"), resultSet.getInt("sectiune_id")));
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
    public ArrayList<Carte> getCartiFromAutorByID(int autorId) {
        ArrayList<Carte> arr = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.getDBConnection().prepareStatement("SELECT * FROM carti WHERE autor_id=" + autorId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                arr.add(new Carte(resultSet.getString("nume"), resultSet.getInt("an_lansare"), resultSet.getInt("autor_id"), resultSet.getInt("sectiune_id")));
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
    public Carte getCarteByID(int carteId) {
        try {
            PreparedStatement preparedStatement = connection.getDBConnection().prepareStatement("SELECT * FROM carti WHERE id=" + carteId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Carte(resultSet.getString("nume"), resultSet.getInt("an_lansare"), resultSet.getInt("autor_id"), resultSet.getInt("sectiune_id"));
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            System.out.println("Return complete - got ID: " + carteId);
        }
    }

    @Override
    public void modifyCarteByID(int carteId, Carte carte) {
        try {
            PreparedStatement preparedStatement = connection.getDBConnection().prepareStatement("UPDATE carti SET nume=\"" + carte.getNume() + "\", an_lansare=\"" + carte.getAnLansare() + "\", autor_id=\"" + carte.getAutorId() + "\", sectiune_id=\"" + carte.getSectiuneId() + "\" WHERE id=" + carteId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Updated entry with ID: " + carteId);
        }
    }

    @Override
    public void removeCarteByID(int carteId) {
        try {
            PreparedStatement preparedStatement = connection.getDBConnection().prepareStatement("DELETE FROM carti WHERE id=" + carteId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Removed row with ID: " + carteId);
        }
    }
}
