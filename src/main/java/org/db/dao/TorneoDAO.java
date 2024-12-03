package org.db.dao;

import org.example.Torneo;

import java.util.List;

public interface TorneoDAO {
    // Crea un nuevo torneo
    public void crearTorneo(Torneo torneo);

    // Obtiene un torneo por su ID
    public Torneo obtenerTorneoPorId(int id);

    // Obtiene todos los torneos
    public List<Torneo> obtenerTodosLosTorneos();

    // Actualiza un torneo existente
    public void actualizarTorneo(Torneo torneo);

    // Elimina un torneo por su ID
    public void eliminarTorneo(int id);
}
