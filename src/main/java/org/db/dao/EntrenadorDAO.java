package org.db.dao;

import org.example.Entrenador;

import java.util.List;

public interface EntrenadorDAO {
    // Crea un nuevo entrenador
    public void crearEntrenador(Entrenador entrenador);

    // Obtiene un entrenador por su ID
    public Entrenador obtenerEntrenadorPorId(long id);

    // Obtiene todos los entrenadores
    public List<Entrenador> obtenerTodosLosEntrenadores();

    // Actualiza un entrenador existente
    public void actualizarEntrenador(Entrenador entrenador);

    // Elimina un entrenador por su ID
    public void eliminarEntrenador(long id);
}
