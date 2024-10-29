package org.example;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Autenticacion {
    private Map<String, String[]> credenciales;

    public Autenticacion() {
        credenciales = new HashMap<>();
        cargarCredenciales();
    }

    // Carga las credenciales desde el archivo
    private void cargarCredenciales() {
        try (BufferedReader br = new BufferedReader(new FileReader("credenciales.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(" ");
                credenciales.put(datos[0], new String[]{datos[1], datos[2], datos[3]});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Usuarios existentes
    public String[] autenticarExistentes(String nombre, String contraseña) {
        if (credenciales.containsKey(nombre)) {
            String[] datos = credenciales.get(nombre);
            if (datos[0].equals(contraseña)) {
                return datos;
            }
        }
        return null;
    }

    // Usuarios "nuevos"
    public String[] autenticarNuevos(String nombre, String nacionalidad) {
        if (credenciales.containsKey(nombre)) {
            String[] datos = credenciales.get(nombre);
            if (datos[0].equals(nacionalidad)) {
                return datos;
            }
        }
        return null;
    }
}
