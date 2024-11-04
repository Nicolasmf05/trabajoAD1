package org.example;
import java.util.Date;

public class Carnet {
    private String id;
    private Date fechaExpedicion;
    private int puntos;
    private int campeonatosGanados;

    // Constructor
    public Carnet(String id, Date fechaExpedicion, int puntos, int campeonatosGanados) {
        this.id = id;
        this.fechaExpedicion = fechaExpedicion;
        this.puntos = puntos;
        this.campeonatosGanados = campeonatosGanados;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Date fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getCampeonatosGanados() {
        return campeonatosGanados;
    }

    public void setCampeonatosGanados(int campeonatosGanados) {
        this.campeonatosGanados = campeonatosGanados;
    }

    // toString() para impresión de datos del carnet
    @Override
    public String toString() {
        return "Carnet{" +
                "id='" + id + '\'' +
                ", fechaExpedicion=" + fechaExpedicion +
                ", puntos=" + puntos +
                ", campeonatosGanados=" + campeonatosGanados +
                '}';
    }
}

