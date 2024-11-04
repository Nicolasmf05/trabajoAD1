package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Autenticacion {
    private Map<String, Usuario> usuarios; // Mapa para almacenar usuarios por su nombre de usuario
    private Usuario usuarioActual; // Usuario actualmente autenticado en el sistema

    // Constructor que carga las credenciales al iniciar el sistema
    public Autenticacion(String rutaArchivoCredenciales) {
        usuarios = new HashMap<>();
        cargarCredenciales(rutaArchivoCredenciales);
    }

    // Método para cargar las credenciales desde un archivo de texto
    private void cargarCredenciales(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(" ");
                if (partes.length == 4) {
                    String nombre = partes[0];
                    String contrasena = partes[1];
                    String perfil = partes[2];
                    String id = partes[3];
                    usuarios.put(nombre, new Usuario(nombre, contrasena, perfil, id));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo de credenciales: " + e.getMessage());
        }
    }

    // Método para iniciar sesión
    public boolean iniciarSesion(String nombre, String contrasena) {
        Usuario usuario = usuarios.get(nombre);
        if (usuario != null && usuario.getContrasena().equals(contrasena)) {
            usuarioActual = usuario;
            System.out.println("Inicio de sesión exitoso. Bienvenido, " + usuario.getNombre() + "!");
            return true;
        } else {
            System.out.println("Credenciales incorrectas.");
            return false;
        }
    }

    // Método para cerrar sesión
    public void cerrarSesion() {
        if (usuarioActual != null) {
            System.out.println("Cierre de sesión exitoso. Adiós, " + usuarioActual.getNombre() + "!");
            usuarioActual = null;
        } else {
            System.out.println("No hay usuario autenticado.");
        }
    }

    // Obtener el perfil del usuario actual
    public String obtenerPerfilUsuarioActual() {
        return usuarioActual != null ? usuarioActual.getPerfil() : "Invitado";
    }

    // Obtener el usuario actual
    public Usuario getUsuarioActual() {
        return usuarioActual;
    }
}

