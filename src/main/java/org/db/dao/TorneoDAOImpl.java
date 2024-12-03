package org.db.dao;

import org.example.Torneo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TorneoDAOImpl implements TorneoDAO {
    private Connection connection;

    public TorneoDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crearTorneo(Torneo torneo) {
        String sql = "INSERT INTO Torneo (nombre, codRegion, puntosVictoria) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, torneo.getNombre());
            statement.setString(2, String.valueOf(torneo.getCodRegion()));
            statement.setFloat(3, torneo.getPuntosVictoria());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Torneo obtenerTorneoPorId(int id) {
        String sql = "SELECT * FROM Torneo WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                char codRegion = resultSet.getString("codRegion").charAt(0);
                float puntosVictoria = resultSet.getFloat("puntosVictoria");
                return new Torneo(nombre, codRegion, puntosVictoria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Torneo> obtenerTodosLosTorneos() {
        List<Torneo> torneos = new ArrayList<>();
        String sql = "SELECT * FROM Torneo";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                char codRegion = resultSet.getString("codRegion").charAt(0);
                float puntosVictoria = resultSet.getFloat("puntosVictoria");
                torneos.add(new Torneo(nombre, codRegion, puntosVictoria));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return torneos;
    }

    @Override
    public void actualizarTorneo(Torneo torneo) {
        String sql = "UPDATE Torneo SET nombre = ?, codRegion = ?, puntosVictoria = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, torneo.getNombre());
            statement.setString(2, String.valueOf(torneo.getCodRegion()));
            statement.setFloat(3, torneo.getPuntosVictoria());
            statement.setInt(4, Math.toIntExact(torneo.getId()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarTorneo(int id) {
        String sql = "DELETE FROM Torneo WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

