package org.example;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase que permite gestionar la autenticación de usuarios (entrenadores y administradores de torneo),
 * cargar credenciales desde un archivo y manejar sesiones de usuarios.
 */
public class Autenticacion {
    private static Map<String, String[]> usuarios; // Almacena los usuarios: nombre -> {contrasena, perfil, id}
    private static Map<Integer, Torneo> torneos; // Mapa de torneos por ID
    private String perfilActual; // Perfil del usuario actual ("invitado" si no está autenticado)
    private String nombreActual; // Nombre del usuario actual (null si no está autenticado)
    private static Map<Long, Entrenador> entrenadores; // Mapa de entrenadores por ID

    /**
     * Constructor que inicializa la autenticación cargando credenciales desde un archivo de texto.
     *
     * @param rutaArchivoCredenciales Ruta del archivo de credenciales
     */
    public Autenticacion(String rutaArchivoCredenciales) {
        usuarios = new HashMap<>();
        torneos = new HashMap<>();
        entrenadores = new HashMap<>();
        cargarCredenciales(rutaArchivoCredenciales);
        perfilActual = "invitado";
        nombreActual = null;
    }

    /**
     * Carga las credenciales de los usuarios desde un archivo de texto.
     *
     * @param rutaArchivo Ruta del archivo de credenciales
     */
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
                    usuarios.put(nombre, new String[]{contrasena, perfil, id});
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo de credenciales: " + e.getMessage());
        }
    }

    /**
     * Permite al usuario iniciar sesión.
     *
     * @param nombre Nombre del usuario
     * @param contrasena Contraseña del usuario
     * @return true si el inicio de sesión es exitoso, false de lo contrario
     */
    public boolean iniciarSesion(String nombre, String contrasena) {
        String[] datosUsuario = usuarios.get(nombre);
        if (datosUsuario != null && datosUsuario[0].equals(contrasena)) {
            nombreActual = nombre;
            perfilActual = datosUsuario[1];
            System.out.println("Inicio de sesión exitoso. Bienvenido, " + nombreActual + "!");
            return true;
        } else {
            System.out.println("Credenciales incorrectas.");
            return false;
        }
    }

    /**
     * Obtiene el nombre del usuario actual.
     *
     * @return Nombre del usuario actual
     */
    public String getNombreActual() {
        return nombreActual;
    }

    public void setNombreActual(String nombreActual) {
        this.nombreActual = nombreActual;
    }

    /**
     * Cierra la sesión del usuario actual y establece el perfil como "invitado".
     */
    public void cerrarSesion() {
        if (nombreActual != null) {
            System.out.println("Cierre de sesión exitoso. Adiós, " + nombreActual + "!");
            nombreActual = null;
            perfilActual = "invitado";
        } else {
            System.out.println("No hay usuario autenticado.");
        }
    }

    /**
     * Obtiene el perfil del usuario actual.
     *
     * @return Perfil del usuario actual
     */
    public String obtenerPerfilUsuarioActual() {
        return perfilActual;
    }

    /**
     * Genera el siguiente ID para los entrenadores.
     *
     * @return ID generado
     */
    public static long getNextID() {
        return usuarios.size() + 1;
    }

    /**
     * Agrega un nuevo usuario al sistema.
     *
     * @param nombre Nombre del usuario
     * @param contrasena Contraseña del usuario
     * @param perfil Perfil del usuario ("entrenador" o "administrador")
     * @param id ID del usuario
     */
    public void agregarUsuario(String nombre, String contrasena, String perfil, String id) {
        usuarios.put(nombre, new String[]{contrasena, perfil, id});
    }

    /**
     * Agrega un entrenador al sistema y lo guarda en el archivo de credenciales.
     *
     * @param entrenador Entrenador a agregar
     */
    public void agregarEntrenador(Entrenador entrenador) {
        if (entrenador != null) {
            entrenadores.put(entrenador.getId(), entrenador);
            String[] datosEntrenador = {entrenador.getContraseña(), "entrenador", String.valueOf(entrenador.getId())};
            usuarios.put(entrenador.getNombre(), datosEntrenador);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("credenciales.txt", true))) {
                writer.write(entrenador.getNombre() + " " + entrenador.getContraseña() + " entrenador " + entrenador.getId() + "\n");
                System.out.println("Entrenador " + entrenador.getNombre() + " agregado correctamente.");
            } catch (IOException e) {
                System.out.println("Error al guardar el entrenador en el archivo de credenciales: " + e.getMessage());
            }
        }
    }
    public void agregarAdminTorneo(Entrenador entrenador) {
        if (entrenador != null) {
            entrenadores.put(entrenador.getId(), entrenador);
            String[] datosEntrenador = {entrenador.getContraseña(), "adminTorneo", String.valueOf(entrenador.getId())};
            usuarios.put(entrenador.getNombre(), datosEntrenador);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("credenciales.txt", true))) {
                writer.write(entrenador.getNombre() + " " + entrenador.getContraseña() + " adminTorneo " + entrenador.getId() + "\n");
                System.out.println("Administrador de torneo " + entrenador.getNombre() + " agregado correctamente.");
            } catch (IOException e) {
                System.out.println("Error al guardar el Administrador de torneo en el archivo de credenciales: " + e.getMessage());
            }
        }
    }

    /**
     * Obtiene un entrenador basado en el nombre.
     *
     * @param nombre Nombre del entrenador
     * @return Entrenador encontrado o null si no existe
     */
    public Entrenador getEntrenador(String nombre) {
        String[] datosUsuario = usuarios.get(nombre);
        if (datosUsuario != null && datosUsuario[1].equals("entrenador")) {
            long id = Long.parseLong(datosUsuario[2]);
            String contrasena = datosUsuario[0];
            String nacionalidad = "Desconocida";
            return new Entrenador(nombre, contrasena, nacionalidad, id);
        }
        return null;
    }

    /**
     * Obtiene un torneo por su ID.
     *
     * @param id ID del torneo
     * @return Torneo encontrado o null si no existe
     */
    public Torneo getTorneo(int id) {
        return torneos.get(id);
    }

    /**
     * Agrega un torneo al sistema.
     *
     * @param torneo Torneo a agregar
     */
    public void agregarTorneo(Torneo torneo) {
        torneos.put((int) torneo.getId(), torneo);
    }

    /**
     * Exporta un torneo a un archivo .dat serializado.
     *
     * @param torneo Torneo a exportar
     */
    public static void exportarTorneo(Torneo torneo) {
        long idResponsable = torneo.getIdResponsable();
        String archivo = "torneo_" + idResponsable + ".dat";

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo))) {
            out.writeObject(torneo);
            System.out.println("Torneo exportado correctamente a " + archivo);
        } catch (IOException e) {
            System.out.println("Error al exportar el torneo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
