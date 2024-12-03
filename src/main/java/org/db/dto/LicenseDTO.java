package org.db.dto;

public class LicenseDTO {
    private int id;
    private String fechaDeExpedicion;
    private final float puntos;
    private final int nVictorias;

    public LicenseDTO(int id, String fechaDeExpedicion, float puntos, int nVictorias) {
        this.id = id;
        fechaDeExpedicion = fechaDeExpedicion;
        this.puntos = puntos;
        this.nVictorias = nVictorias;
    }

    public LicenseDTO (String fechaDeExpedicion, float puntos, int nVictorias) {
        fechaDeExpedicion = fechaDeExpedicion;
        this.puntos = puntos;
        this.nVictorias = nVictorias;
    }

    public int getId() {
        return id;
    }

    public String getExpedition_Date() {
        return fechaDeExpedicion;
    }

    public float getPuntos() {
        return puntos;
    }

    public int getnVictorias() {
        return nVictorias;
    }
}
