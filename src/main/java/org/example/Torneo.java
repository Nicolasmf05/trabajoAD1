package org.example;
import java.util.ArrayList;
import java.util.List;

public class Torneo {
    private String id;
    private String nombre;
    private char region;
    private int puntosVictoria;
    private List<Entrenador> participantes;
    private Entrenador ganador;

    // Constructor
    public Torneo(String id, String nombre, char region, int puntosVictoria) {
        this.id = id;
        this.nombre = nombre;
        this.region = region;
        this.puntosVictoria = puntosVictoria;
        this.participantes = new ArrayList<>();  // Inicializamos la lista de participantes vacía
    }

    // Método para agregar un participante al torneo
    public boolean agregarParticipante(Entrenador entrenador) {
        if (participantes.size() < 6) {  // Límite de 6 participantes
            participantes.add(entrenador);
            return true;  // Participante añadido con éxito
        } else {
            System.out.println("El torneo ya tiene el máximo de participantes.");
            return false;  // No se pudo añadir por límite de participantes
        }
    }

    // Método para asignar un ganador
    public void asignarGanador(Entrenador entrenador) {
        if (participantes.contains(entrenador)) {
            this.ganador = entrenador;
            System.out.println("Ganador del torneo asignado: " + entrenador.getNombre());
        } else {
            System.out.println("El entrenador no participa en este torneo.");
        }
    }

    // Método para obtener el ganador
    public Entrenador obtenerGanador() {
        return ganador;
    }

    // Método para verificar si el torneo está completo (tiene 6 participantes)
    public boolean torneoCompleto() {
        return participantes.size() == 6;
    }

    // Método para obtener la lista de participantes
    public List<Entrenador> obtenerParticipantes() {
        return participantes;
    }

    // Método para mostrar información del torneo
    public void mostrarInformacion() {
        System.out.println("Torneo ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Región: " + region);
        System.out.println("Puntos por victoria: " + puntosVictoria);
        System.out.println("Participantes: ");
        for (Entrenador participante : participantes) {
            System.out.println("- " + participante.getNombre() + " (" + participante.getNacionalidad() + ")");
        }
        if (ganador != null) {
            System.out.println("Ganador: " + ganador.getNombre());
        } else {
            System.out.println("Aún no hay un ganador asignado.");
        }

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getRegion() {
        return region;
    }

    public void setRegion(char region) {
        this.region = region;
    }

    public int getPuntosVictoria() {
        return puntosVictoria;
    }

    public void setPuntosVictoria(int puntosVictoria) {
        this.puntosVictoria = puntosVictoria;
    }

    public List<Entrenador> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Entrenador> participantes) {
        this.participantes = participantes;
    }

    public Entrenador getGanador() {
        return ganador;
    }

    public void setGanador(Entrenador ganador) {
        this.ganador = ganador;
    }
}

