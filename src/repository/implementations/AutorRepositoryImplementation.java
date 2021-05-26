package repository.implementations;

import clase.Autor;
import clase.Cititor;
import repository.interfaces.AutorRepository;
import utils.JDBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AutorRepositoryImplementation implements AutorRepository {

    JDBConnection connection = JDBConnection.getInstance();

    @Override
    public void addAutor(Autor autor) {
        try {
            PreparedStatement preparedStatement = connection.getDBConnection().prepareStatement("INSERT INTO autori (nume, prenume, varsta, carti_scrise) VALUES ('" + autor.getNume() + "', '" + autor.getPrenume() + "', '"  + autor.getVarsta() + "', '"  + autor.getNumarCarti() + "' )");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Insertion complete - Added: " + autor.getNume() + " to AUTORI");
        }
    }

    @Override
    public ArrayList<Autor> getAutori() {
        ArrayList<Autor> arr = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.getDBConnection().prepareStatement("SELECT * FROM autori");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                arr.add(new Autor(resultSet.getString("nume"), resultSet.getString("prenume"), resultSet.getInt("varsta"), resultSet.getInt("carti_scrise")));
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
    public Autor getAutorByID(int autorId) {
        try {
            PreparedStatement preparedStatement = connection.getDBConnection().prepareStatement("SELECT * FROM autori WHERE id=" + autorId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Autor(resultSet.getString("nume"), resultSet.getString("prenume"), resultSet.getInt("varsta"), resultSet.getInt("carti_scrise"));
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            System.out.println("Return complete - got ID: " + autorId);
        }
    }

    @Override
    public void modifyAutorByID(int autorId, Autor autor) {
        try {
            PreparedStatement preparedStatement = connection.getDBConnection().prepareStatement("UPDATE autori SET nume=\"" + autor.getNume() + "\", prenume=\"" + autor.getPrenume() + "\", varsta=\"" + autor.getVarsta() + "\", carti_scrise=\"" + autor.getNumarCarti() + "\" WHERE id=" + autorId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Updated entry with ID: " + autorId);
        }
    }

    @Override
    public void removeAutorbyID(int autorId) {
        try {
            PreparedStatement preparedStatement = connection.getDBConnection().prepareStatement("DELETE FROM cititori WHERE id=" + autorId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Removed row with ID: " + autorId);
        }
    }
}
