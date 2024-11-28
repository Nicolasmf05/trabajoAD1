package org.example;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Representa un carnet de entrenador, que contiene información sobre el entrenador,
 * la fecha de expedición, los puntos acumulados y el número de victorias.
 */
public class Carnet implements Serializable {
    // ID único del entrenador
    private long idEntrenador;
    // Fecha en la que se expidió el carnet
    private LocalDate fechaExpedicion;
    // Puntos acumulados por el entrenador
    private float puntos;
    // Número de victorias del entrenador
    private int numVictorias;

    /**
     * Constructor completo de la clase Carnet.
     *
     * @param idEntrenador   ID único del entrenador
     * @param fechaExpedicion Fecha de expedición del carnet
     * @param puntos         Puntos acumulados por el entrenador
     * @param numVictorias   Número de victorias del entrenador
     */
    public Carnet(long idEntrenador, LocalDate fechaExpedicion, float puntos, int numVictorias) {
        this.idEntrenador = idEntrenador;
        this.fechaExpedicion = fechaExpedicion;
        this.puntos = puntos;
        this.numVictorias = numVictorias;
    }

    /**
     * Constructor parcial de la clase Carnet, sin puntos ni victorias iniciales.
     *
     * @param idEntrenador   ID único del entrenador
     * @param fechaExpedicion Fecha de expedición del carnet
     */
    public Carnet(Long idEntrenador, LocalDate fechaExpedicion) {
        this.idEntrenador = idEntrenador;
        this.fechaExpedicion = fechaExpedicion;
    }

    /**
     * Obtiene el ID del entrenador.
     *
     * @return ID único del entrenador
     */
    public long getIdEntrenador() {
        return idEntrenador;
    }

    /**
     * Establece el ID del entrenador.
     *
     * @param idEntrenador ID único del entrenador
     */
    public void setIdEntrenador(long idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    /**
     * Obtiene la fecha de expedición del carnet.
     *
     * @return Fecha de expedición del carnet
     */
    public LocalDate getFechaExpedicion() {
        return fechaExpedicion;
    }

    /**
     * Establece la fecha de expedición del carnet.
     *
     * @param fechaExpedicion Fecha de expedición del carnet
     */
    public void setFechaExpedicion(LocalDate fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    /**
     * Obtiene los puntos acumulados por el entrenador.
     *
     * @return Puntos acumulados
     */
    public float getPuntos() {
        return puntos;
    }

    /**
     * Establece los puntos acumulados por el entrenador.
     *
     * @param puntos Puntos acumulados
     */
    public void setPuntos(float puntos) {
        this.puntos = puntos;
    }

    /**
     * Obtiene el número de victorias del entrenador.
     *
     * @return Número de victorias
     */
    public int getNumVictorias() {
        return numVictorias;
    }

    /**
     * Establece el número de victorias del entrenador.
     *
     * @param numVictorias Número de victorias
     */
    public void setNumVictorias(int numVictorias) {
        this.numVictorias = numVictorias;
    }
}



