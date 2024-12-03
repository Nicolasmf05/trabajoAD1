package org.db.dao;

import org.example.Entrenador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EntrenadorDAOImple implements EntrenadorDAO {
    private Connection connection;

    public EntrenadorDAOImple(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crearEntrenador(Entrenador entrenador) {
        String sql = "INSERT INTO Entrenador (nombre, nacionalidad, puntos, contraseña, fechaCreacion) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, entrenador.getNombre());
            statement.setString(2, entrenador.getNacionalidad());
            statement.setLong(3, entrenador.getPuntos());
            statement.setString(4, entrenador.getContraseña());
            statement.setDate(5, Date.valueOf(entrenador.getFechaCreacion()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Entrenador obtenerEntrenadorPorId(long id) {
        String sql = "SELECT * FROM Entrenador WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String nacionalidad = resultSet.getString("nacionalidad");
                long puntos = resultSet.getLong("puntos");
                String contraseña = resultSet.getString("contraseña");
                Date fechaCreacion = resultSet.getDate("fechaCreacion");

                Entrenador entrenador = new Entrenador(nombre, contraseña, nacionalidad, id);
                entrenador.setPuntos(puntos);
                entrenador.setFechaCreacion(fechaCreacion.toLocalDate());
                return entrenador;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Entrenador> obtenerTodosLosEntrenadores() {
        List<Entrenador> entrenadores = new ArrayList<>();
        String sql = "SELECT * FROM Entrenador";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String nombre = resultSet.getString("nombre");
                String nacionalidad = resultSet.getString("nacionalidad");
                long puntos = resultSet.getLong("puntos");
                String contraseña = resultSet.getString("contraseña");
                Date fechaCreacion = resultSet.getDate("fechaCreacion");

                Entrenador entrenador = new Entrenador(nombre, contraseña, nacionalidad, id);
                entrenador.setPuntos(puntos);
                entrenador.setFechaCreacion(fechaCreacion.toLocalDate());
                entrenadores.add(entrenador);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entrenadores;
    }

    @Override
    public void actualizarEntrenador(Entrenador entrenador) {
        String sql = "UPDATE Entrenador SET nombre = ?, nacionalidad = ?, puntos = ?, contraseña = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, entrenador.getNombre());
            statement.setString(2, entrenador.getNacionalidad());
            statement.setLong(3, entrenador.getPuntos());
            statement.setString(4, entrenador.getContraseña());
            statement.setLong(5, entrenador.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarEntrenador(long id) {
        String sql = "DELETE FROM Entrenador WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
