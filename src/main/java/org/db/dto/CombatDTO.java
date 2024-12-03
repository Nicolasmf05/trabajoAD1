package org.db.dto;

public class CombatDTO {
    private final String fecha;
    private final int entrenador1;
    private final int entrenador2;
    private final int ganador;

    public CombatDTO(String fecha, int entrenador1, int entrenador2, int ganador) {
        this.fecha = fecha;
        this.entrenador1 = entrenador1;
        this.entrenador2 = entrenador2;
        this.ganador = ganador;
    }

    public String getFecha() {
        return fecha;
    }

    public int getEntrenador1() {
        return entrenador1;
    }

    public int getEntrenador2() {
        return entrenador2;
    }

    public int getGanador() {
        return ganador;
    }
}
