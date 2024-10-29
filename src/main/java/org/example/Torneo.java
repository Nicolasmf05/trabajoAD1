package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

    public class Torneo {
        private String id;
        private String nombre;
        private char region;
        private List<Entrenador> entrenadores;
        private List<Combate> combates;

        public Torneo(String id, String nombre, char region) {
            this.id = id;
            this.nombre = nombre;
            this.region = region;
        }

        public void exportarDatosTorneo(Date fechaInicio, Date fechaFin) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String nombreArchivo = nombre + "_datos_torneo.txt";

            LocalDate startDate = fechaInicio.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate endDate = fechaFin.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(nombreArchivo), StandardCharsets.UTF_8)) {
                writer.write("ID Torneo: " + id + "\n");
                writer.write("Nombre Torneo: " + nombre + "\n");
                writer.write("Región: " + region + "\n");
                writer.write("Rango de fechas: " + startDate.format(dtf) + " - " + endDate.format(dtf) + "\n\n");

                // Filtrar combates en el rango de fechas
                for (Combate combate : combates) {
                    LocalDate combateFecha = combate.getFecha();
                    if (!combateFecha.isBefore(startDate) && !combateFecha.isAfter(endDate)) {
                        writer.write("Combate ID: " + combate.getId() + "\n");
                        writer.write("Fecha: " + combateFecha.format(dtf) + "\n");

                        Entrenador ganador = combate.getGanador();
                        writer.write("Ganador: " + (ganador != null ? ganador.getNombre() : "Empate") + "\n");

                        writer.write("Entrenadores participantes:\n");
                        for (Entrenador entrenador : entrenadores) {
                            writer.write("- " + entrenador.getNombre() + " (ID: " + entrenador.getId() + ")\n");
                        }
                        writer.write("\n");
                    }
                }
                System.out.println("Datos exportados correctamente a " + nombreArchivo);
            } catch (IOException e) {
                e.printStackTrace();
            }

        public void agregarCombate(Combate combate) {
            combates.add(combate);
        }

        public void agregarEntrenador(Entrenador entrenador) {
            entrenadores.add(entrenador);
        }

        public List<Combate> getCombates() {
            return combates;
        }

        public List<Entrenador> getEntrenadores() {
            return entrenadores;
        }
    }
}