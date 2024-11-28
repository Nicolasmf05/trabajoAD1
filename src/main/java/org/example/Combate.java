package org.example;

import java.time.LocalDate;

/**
 * Representa un combate entre entrenadores.
 * Cada combate tiene una fecha, un identificador único, un entrenador y un ganador.
 */
class Combate {
    // Fecha en la que se realizó el combate
    private LocalDate fecha;
    // Identificador único del combate
    private long id;
    // Entrenador participante en el combate
    private Entrenador entrenador;
    // Entrenador que ganó el combate
    private Entrenador ganador;

    /**
     * Constructor de la clase Combate.
     *
     * @param fecha      Fecha del combate
     * @param id         Identificador único del combate
     * @param entrenador Entrenador participante en el combate
     */
    public Combate(LocalDate fecha, long id, Entrenador entrenador) {
        this.fecha = fecha;
        this.id = id;
        this.entrenador = entrenador;
    }

    /**
     * Obtiene el ganador del combate.
     *
     * @return El entrenador ganador del combate
     */
    public Entrenador getGanador() {
        return ganador;
    }

    /**
     * Establece el ganador del combate.
     *
     * @param ganador El entrenador ganador del combate
     */
    public void setGanador(Entrenador ganador) {
        this.ganador = ganador;
    }

    /**
     * Obtiene la fecha del combate.
     *
     * @return La fecha en la que se realizó el combate
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Obtiene el identificador del combate.
     *
     * @return El identificador único del combate
     */
    public long getId() {
        return id;
    }

    /**
     * Obtiene el entrenador participante en el combate.
     *
     * @return El entrenador que participó en el combate
     */
    public Entrenador getEntrenador() {
        return entrenador;
    }
}

