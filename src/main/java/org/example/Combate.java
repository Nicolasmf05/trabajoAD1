package org.example;

import java.util.Date;

public class Combate {
    private String id;
    private Date fecha;
    private Entrenador participante1;
    private Entrenador participante2;
    private Entrenador ganador;
    private Torneo torneo;

    // Constructor
    public Combate(String id, Date fecha, Entrenador participante1, Entrenador participante2, Torneo torneo) {
        this.id = id;
        this.fecha = fecha;
        this.participante1 = participante1;
        this.participante2 = participante2;
        this.torneo = torneo;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Entrenador getParticipante1() {
        return participante1;
    }

    public void setParticipante1(Entrenador participante1) {
        this.participante1 = participante1;
    }

    public Entrenador getParticipante2() {
        return participante2;
    }

    public void setParticipante2(Entrenador participante2) {
        this.participante2 = participante2;
    }

    public Entrenador getGanador() {
        return ganador;
    }

    public void setGanador(Entrenador ganador) {
        this.ganador = ganador;
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

}

