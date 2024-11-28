package org.example;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Representa un torneo de entrenadores, con un nombre, región, puntos por victoria,
 * un responsable y una lista de participantes.
 */
public class Torneo implements Serializable {
    // ID único del torneo
    private int id;
    // Nombre del torneo
    private String nombre;
    // Código de la región a la que pertenece el torneo
    private char codRegion;
    // Puntos otorgados por cada victoria en el torneo
    private float puntosVictoria;
    // ID del entrenador responsable del torneo
    private long idResponsable;
    // Lista de entrenadores participantes en el torneo
    private ArrayList<Entrenador> participantes = new ArrayList<>();

    /**
     * Constructor de la clase Torneo.
     *
     * @param nombre         Nombre del torneo
     * @param codRegion      Código de la región del torneo
     * @param puntosVictoria Puntos asignados por cada victoria
     */
    public Torneo(String nombre, char codRegion, float puntosVictoria) {
        this.nombre = nombre;
        this.codRegion = codRegion;
        this.puntosVictoria = puntosVictoria;
    }

    /**
     * Inscribe un entrenador en el torneo.
     *
     * @param entrenador El entrenador a inscribir
     */
    public void inscribir(Entrenador entrenador) {
        participantes.add(entrenador);
    }

    /**
     * Obtiene el ID del torneo.
     *
     * @return ID único del torneo
     */
    public long getId() {
        return id;
    }

    /**
     * Establece el ID del torneo.
     *
     * @param id ID único del torneo
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Establece el ID del responsable del torneo.
     *
     * @param idResponsable ID del entrenador responsable del torneo
     */
    public void setIdResponsable(long idResponsable) {
        this.idResponsable = idResponsable;
    }

    /**
     * Obtiene la lista de participantes en el torneo.
     *
     * @return Lista de entrenadores participantes
     */
    public ArrayList<Entrenador> getParticipantes() {
        return participantes;
    }

    /**
     * Establece la lista de participantes en el torneo.
     *
     * @param participantes Lista de entrenadores participantes
     */
    public void setParticipantes(ArrayList<Entrenador> participantes) {
        this.participantes = participantes;
    }

    /**
     * Obtiene el nombre del torneo.
     *
     * @return Nombre del torneo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del torneo.
     *
     * @param nombre Nombre del torneo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el ID del responsable del torneo.
     *
     * @return ID del entrenador responsable del torneo
     */
    public long getIdResponsable() {
        return idResponsable;
    }

    /**
     * Obtiene el código de la región del torneo.
     *
     * @return Código de la región
     */
    public char getCodRegion() {
        return codRegion;
    }

    /**
     * Establece el código de la región del torneo.
     *
     * @param codRegion Código de la región
     */
    public void setCodRegion(char codRegion) {
        this.codRegion = codRegion;
    }

    /**
     * Obtiene los puntos asignados por cada victoria en el torneo.
     *
     * @return Puntos por victoria
     */
    public float getPuntosVictoria() {
        return puntosVictoria;
    }

    /**
     * Establece los puntos asignados por cada victoria en el torneo.
     *
     * @param puntosVictoria Puntos por victoria
     */
    public void setPuntosVictoria(float puntosVictoria) {
        this.puntosVictoria = puntosVictoria;
    }
}
