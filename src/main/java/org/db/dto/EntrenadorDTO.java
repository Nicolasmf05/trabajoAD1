package org.db.dto;

import org.example.Carnet;

import java.util.List;

public class EntrenadorDTO {
    private int id;
    private final String nombre;
    private final String nacionalidad;
    private final Carnet carnet;
    private final List<TournamentDTO> listaEntrenadoresTorneo;
    private final List<CombatDTO> listaEntrenadoresCombate;

    public EntrenadorDTO(final int id, final String nombre, final String nacionalidad, Carnet carnet, List<TournamentDTO> listaEntrenadoresTorneo, List<CombatDTO> listaEntrenadoresCombate) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.carnet = carnet;
        this.listaEntrenadoresTorneo = listaEntrenadoresTorneo;
        this.listaEntrenadoresCombate = listaEntrenadoresCombate;
    }

    public EntrenadorDTO(final String nombre, final String nacionalidad, final Carnet carnet, List<TournamentDTO> listaEntrenadoresTorneo, List<CombatDTO> listaEntrenadoresCombate) {
        this.nombre = nombre;
        this.carnet = carnet;
        this.nacionalidad = nacionalidad;
        this.listaEntrenadoresTorneo = listaEntrenadoresTorneo;
        this.listaEntrenadoresCombate = listaEntrenadoresCombate;
    }

    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return nombre;
    }


    public String getNacionalidad() {
        return nacionalidad;
    }

    public Carnet getCarnet() {
        return carnet;
    }

    public List<TournamentDTO> getListaEntrenadoresTorneo() {
        return listaEntrenadoresTorneo;
    }

    public List<CombatDTO> getListaEntrenadoresCombate() {
        return listaEntrenadoresCombate;
    }

    @Override
    public String toString() {
        return String.format(
                "TRUser{id=%d, username='%s', nombre='%s', nTorneos='%d', nCombates=%d}",
                id, getNombre(), nacionalidad, listaEntrenadoresTorneo.size(), listaEntrenadoresCombate.size()
        );
    }
}
