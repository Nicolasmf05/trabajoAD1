package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

class Carnet {
    private Entrenador entrenador;
    private final LocalDate fechaEmision;
    private int puntos;
    private int numVictorias;


    public Carnet(Entrenador entrenador, LocalDate fechaEmision, int puntos, int numVictorias) {
        this.entrenador = entrenador;
        this.fechaEmision = LocalDate.now();
        this.puntos = puntos;
        this.numVictorias = numVictorias;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public int getPuntos() {
        return puntos;
    }

    public int getNumVictorias() {
        return numVictorias;
    }

    public void actualizarPuntos(int nuevosPuntos) {
        this.puntos += nuevosPuntos;
    }

    public void incrementarCampeonatos() {
        this.numVictorias++;
    }

    public void exportarCarnet(Entrenador entrenador) {
        StringBuilder xmlBuilder = new StringBuilder();

        xmlBuilder.append("<carnet>\n");
        xmlBuilder.append("  <id>").append(entrenador).append("</id>\n");
        xmlBuilder.append("  <fechaexp>").append(getFechaEmision()).append("</fechaexp>\n");

        // Entrenador
        xmlBuilder.append("  <entrenador>\n");
        xmlBuilder.append("    <nombre>").append(Entrenador.getNombre()).append("</nombre>\n");
        xmlBuilder.append("    <nacionalidad>").append(Entrenador.getNacionalidad()).append("</nacionalidad>\n");
        xmlBuilder.append("  </entrenador>\n");

        xmlBuilder.append("  <hoy>").append(LocalDate.now()).append("</hoy>\n");
        xmlBuilder.append("  <puntos>").append(getPuntos()).append("</puntos>\n");

        // Torneos
        xmlBuilder.append("  <torneos>\n");
        for (Torneo torneo : Entrenador.getTorneos()) {
            xmlBuilder.append("    <torneo>\n");
            xmlBuilder.append("      <nombre>").append(Torneo.getNombre()).append("</nombre>\n");
            xmlBuilder.append("      <region>").append(Torneo.getRegion()).append("</region>\n");
            xmlBuilder.append("      <combates>\n");
            for (Combate combate : torneo.getCombates()) {
                xmlBuilder.append("        <combate>\n");
                xmlBuilder.append("          <id>").append(combate.getId()).append("</id>\n");
                xmlBuilder.append("          <fecha>").append(combate.getFecha()).append("</fecha>\n");
                xmlBuilder.append("          <victoria>").append(combate.isVictoria()).append("</victoria>\n");
                xmlBuilder.append("        </combate>\n");
            }
            xmlBuilder.append("      </combates>\n");
            xmlBuilder.append("    </torneo>\n");
        }
        xmlBuilder.append("  </torneos>\n");

        xmlBuilder.append("</carnet>");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(entrenador.getNombre() + "_carnet.xml"))) {
            writer.write(xmlBuilder.toString());
            System.out.println("Carnet exportado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


