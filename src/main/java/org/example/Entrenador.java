package org.example;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Representa a un entrenador, con atributos como su nombre, nacionalidad, puntos acumulados,
 * una contraseña para autenticación, un carnet de entrenador, la fecha de creación de su perfil
 * y una lista de torneos en los que ha participado.
 */
public class Entrenador implements Serializable {
    // ID único del entrenador
    private long id;
    // Nombre del entrenador
    private String nombre;
    // Nacionalidad del entrenador
    private String nacionalidad;
    // Puntos acumulados por el entrenador
    private long puntos;
    // Contraseña del entrenador para autenticación
    private String contraseña;
    // Carnet de identificación del entrenador
    private Carnet carnet;
    // Fecha de creación del perfil del entrenador
    private LocalDate fechaCreacion = LocalDate.now();
    // Lista de torneos en los que el entrenador ha participado
    private ArrayList<Torneo> torneos = new ArrayList<>();

    /**
     * Constructor de la clase Entrenador.
     *
     * @param nombre       Nombre del entrenador
     * @param contraseña   Contraseña del entrenador
     * @param nacionalidad Nacionalidad del entrenador
     * @param id           ID único del entrenador
     */
    public Entrenador(String nombre, String contraseña, String nacionalidad, long id) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.nacionalidad = nacionalidad;
        this.id = id;
        this.carnet = new Carnet(id, fechaCreacion);
    }

    /**
     * Añade un torneo a la lista de torneos en los que ha participado el entrenador.
     *
     * @param torneo El torneo a añadir
     */
    public void añadirTorneo(Torneo torneo) {
        torneos.add(torneo);
    }

    /**
     * Obtiene la lista de torneos en los que ha participado el entrenador.
     *
     * @return Lista de torneos
     */
    public ArrayList<Torneo> getTorneos() {
        return torneos;
    }

    /**
     * Establece la lista de torneos en los que ha participado el entrenador.
     *
     * @param torneos Lista de torneos
     */
    public void setTorneos(ArrayList<Torneo> torneos) {
        this.torneos = torneos;
    }

    /**
     * Obtiene el ID del entrenador.
     *
     * @return ID único del entrenador
     */
    public long getId() {
        return id;
    }

    /**
     * Establece el ID del entrenador.
     *
     * @param id ID único del entrenador
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Obtiene el carnet del entrenador.
     *
     * @return Carnet del entrenador
     */
    public Carnet getCarnet() {
        return carnet;
    }

    /**
     * Establece el carnet del entrenador.
     *
     * @param carnet Carnet del entrenador
     */
    public void setCarnet(Carnet carnet) {
        this.carnet = carnet;
    }

    /**
     * Obtiene la fecha de creación del perfil del entrenador.
     *
     * @return Fecha de creación
     */
    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Establece la fecha de creación del perfil del entrenador.
     *
     * @param fechaCreacion Fecha de creación
     */
    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * Obtiene el nombre del entrenador.
     *
     * @return Nombre del entrenador
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del entrenador.
     *
     * @param nombre Nombre del entrenador
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la nacionalidad del entrenador.
     *
     * @return Nacionalidad del entrenador
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * Establece la nacionalidad del entrenador.
     *
     * @param nacionalidad Nacionalidad del entrenador
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /**
     * Obtiene los puntos acumulados por el entrenador.
     *
     * @return Puntos acumulados
     */
    public long getPuntos() {
        return puntos;
    }

    /**
     * Establece los puntos acumulados por el entrenador.
     *
     * @param puntos Puntos acumulados
     */
    public void setPuntos(long puntos) {
        this.puntos = puntos;
    }

    /**
     * Obtiene la contraseña del entrenador.
     *
     * @return Contraseña del entrenador
     */
    public String getContraseña() {
        return contraseña;
    }
}
