package org.example;

import java.time.LocalDate;

class Combate {
    private LocalDate fecha;
    private long id;
    private Entrenador entrenador;
    private Entrenador ganador;

    public Combate(LocalDate fecha, long id, Entrenador entrenador) {
        this.fecha = fecha;
        this.id = id;
        this.entrenador = entrenador;
    }

    public Entrenador getGanador() {
        return ganador;
    }
    public void setGanador(Entrenador ganador) {
        this.ganador = ganador;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public long getId() {
        return id;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }
}
