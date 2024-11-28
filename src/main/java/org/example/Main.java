package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Autenticacion auth;
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Torneo> torneos = new ArrayList<>();

    public static void main(String[] args) {
        try {
            // Inicialización del sistema de autenticación cargando credenciales desde un archivo
            auth = new Autenticacion("credenciales.txt");
        } catch (Exception e) {
            System.out.println("Error al cargar las credenciales: " + e.getMessage());
            return;
        }

        // Bucle principal de la aplicación
        boolean salir = false;
        while (!salir) {
            String perfilUsuario = auth.obtenerPerfilUsuarioActual();
            mostrarMenuPorPerfil(perfilUsuario); // Mostrar el menú según el perfil actual

            try {
                // Leer opción del usuario y ejecutar la opción correspondiente
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                salir = ejecutarOpcion(perfilUsuario, opcion); // Ejecutar acción y verificar si salir
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número.");
                scanner.nextLine(); // Limpiar el buffer en caso de error de tipo
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }
        scanner.close();
    }

    // Mostrar menú basado en el perfil del usuario actual
    private static void mostrarMenuPorPerfil(String perfilUsuario) {
        switch (perfilUsuario) {
            case "invitado":
                mostrarMenuInvitado();
                break;
            case "entrenador":
                mostrarMenuEntrenador();
                break;
            case "administradorTorneo":
                mostrarMenuAdministradorTorneo();
                break;
            case "administradorGeneral":
                mostrarMenuAdministradorGeneral();
                break;
            default:
                System.out.println("Perfil no reconocido.");
                break;
        }
    }

    // Métodos para mostrar menús para cada tipo de perfil
    private static void mostrarMenuInvitado() {
        System.out.println("\n--- Menú Invitado ---");
        System.out.println("1. Iniciar Sesión");
        System.out.println("2. Registrar Nuevo Entrenador");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void mostrarMenuEntrenador() {
        System.out.println("\n--- Menú Entrenador ---");
        System.out.println("1. Exportar Carnet en XML");
        System.out.println("2. Cerrar Sesión");
        System.out.print("Seleccione una opción: ");
    }

    private static void mostrarMenuAdministradorTorneo() {
        System.out.println("\n--- Menú Administrador de Torneo ---");
        System.out.println("1. Exportar Datos del Torneo");
        System.out.println("2. Cerrar Sesión");
        System.out.print("Seleccione una opción: ");
    }

    private static void mostrarMenuAdministradorGeneral() {
        System.out.println("\n--- Menú Administrador General ---");
        System.out.println("1. Registrar Nuevo Torneo");
        System.out.println("2. Cerrar Sesión");
        System.out.print("Seleccione una opción: ");
    }

    // Ejecuta la acción correspondiente a la opción seleccionada en función del perfil del usuario
    private static boolean ejecutarOpcion(String perfilUsuario, int opcion) {
        switch (perfilUsuario) {
            case "invitado":
                return ejecutarOpcionInvitado(opcion);
            case "entrenador":
                return ejecutarOpcionEntrenador(opcion);
            case "administradorTorneo":
                return ejecutarOpcionAdministradorTorneo(opcion);
            case "administradorGeneral":
                return ejecutarOpcionAdministradorGeneral(opcion);
            default:
                return true;
        }
    }

    // Acciones para el perfil "invitado"
    private static boolean ejecutarOpcionInvitado(int opcion) {
        try {
            switch (opcion) {
                case 1:
                    iniciarSesion();
                    return false;
                case 2:
                    registrarNuevoEntrenador();
                    return false;
                case 3:
                    System.out.println("Saliendo...");
                    return true;
                default:
                    System.out.println("Opción no válida.");
                    return false;
            }
        } catch (Exception e) {
            System.out.println("Error en la opción de invitado: " + e.getMessage());
            return false;
        }
    }

    // Acciones para el perfil "entrenador"
    private static boolean ejecutarOpcionEntrenador(int opcion) {
        try {
            switch (opcion) {
                case 1:
                    exportarCarnetXML();
                    return false;
                case 2:
                    cerrarSesion();
                    return false;
                default:
                    System.out.println("Opción no válida.");
                    return false;
            }
        } catch (Exception e) {
            System.out.println("Error en la opción de entrenador: " + e.getMessage());
            return false;
        }
    }

    // Acciones para el perfil "administrador de torneo"
    private static boolean ejecutarOpcionAdministradorTorneo(int opcion) {
        try {
            switch (opcion) {
                case 1:
                    exportarDatosTorneo();
                    return false;
                case 2:
                    cerrarSesion();
                    return false;
                default:
                    System.out.println("Opción no válida.");
                    return false;
            }
        } catch (Exception e) {
            System.out.println("Error en la opción de administrador de torneo: " + e.getMessage());
            return false;
        }
    }

    // Acciones para el perfil "administrador general"
    private static boolean ejecutarOpcionAdministradorGeneral(int opcion) {
        try {
            switch (opcion) {
                case 1:
                    registrarNuevoTorneo();
                    return false;
                case 2:
                    cerrarSesion();
                    return false;
                default:
                    System.out.println("Opción no válida.");
                    return false;
            }
        } catch (Exception e) {
            System.out.println("Error en la opción de administrador general: " + e.getMessage());
            return false;
        }
    }

    // Métodos para iniciar sesión y registrar entrenadores
    private static void iniciarSesion() {
        try {
            System.out.print("Ingrese nombre de usuario: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese contraseña: ");
            String contrasena = scanner.nextLine();
            auth.iniciarSesion(nombre, contrasena);
        } catch (Exception e) {
            System.out.println("Error al iniciar sesión: " + e.getMessage());
        }
    }

    private static void registrarNuevoEntrenador() {
        try {
            System.out.print("Ingrese nombre del entrenador: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese contraseña del entrenador: ");
            String contrasena = scanner.nextLine();
            System.out.print("Ingrese nacionalidad del entrenador: ");
            String nacionalidad = scanner.nextLine();
            registrarEntrenador(nombre, contrasena, nacionalidad,true);
        } catch (Exception e) {
            System.out.println("Error al registrar el entrenador: " + e.getMessage());
        }
    }

    private static void registrarEntrenador(String nombre, String contrasena, String nacionalidad, boolean tipoUsuario) {
        if (tipoUsuario) {
            try {
                long id = Autenticacion.getNextID();
                auth.agregarUsuario(nombre, contrasena, "entrenador", String.valueOf(id));
                Entrenador entrenador = new Entrenador(nombre, contrasena, nacionalidad, id);
                auth.agregarEntrenador(entrenador);
            } catch (Exception e) {
                System.out.println("Error al agregar entrenador: " + e.getMessage());
            }
        } else {
            try {
                long id = Autenticacion.getNextID();
                auth.agregarUsuario(nombre, contrasena, "adminTorneo", String.valueOf(id));
                Entrenador entrenador = new Entrenador(nombre, contrasena, nacionalidad, id);
                auth.agregarAdminTorneo(entrenador);
            } catch (Exception e) {
                System.out.println("Error al agregar administador de torneo: " + e.getMessage());
            }
        }
    }

    // Registrar un nuevo torneo en el sistema
    private static void registrarNuevoTorneo() {
        System.out.print("Ingrese el nombre del nuevo torneo: ");
        String nombreTorneo = scanner.nextLine();
        System.out.print("Ingrese la región del nuevo torneo (un carácter): ");
        char region = scanner.nextLine().charAt(0);
        System.out.print("Ingrese el nombre del administrador del torneo: ");
        String nombreAdmin = scanner.nextLine();
        System.out.print("Ingrese la contraseña del administrador del torneo: ");
        String contrasenaAdmin = scanner.nextLine();
        System.out.print("Ingrese la nacionalidad del administrador del torneo: ");
        String nacionalidadAdmin = scanner.nextLine();
        registrarEntrenador(nombreAdmin,contrasenaAdmin,nacionalidadAdmin,false);

        // Verificar si el torneo ya existe
        for (Torneo torneo : torneos) {
            if (torneo.getNombre().equals(nombreTorneo)) {
                System.out.println("El torneo ya existe.");
                return;
            }
        }

        // Crear y registrar nuevo torneo
        Torneo nuevoTorneo = new Torneo(nombreTorneo, region, 10);
        nuevoTorneo.setIdResponsable(auth.getNextID());
        torneos.add(nuevoTorneo);
        System.out.println("Nuevo torneo registrado con éxito.");

        // Solicitar fechas de combates
        System.out.print("Ingrese la cantidad de combates: ");
        int numCombates = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= numCombates; i++) {
            System.out.print("Fecha del combate " + i + " (yyyy-mm-dd): ");
            LocalDate fecha = LocalDate.parse(scanner.nextLine());
            nuevoTorneo.inscribir(new Entrenador("Entrenador " + i, "contraseña", "N/A", auth.getNextID()));
        }
        auth.exportarTorneo(nuevoTorneo);
    }

    // Exportar carnet en formato XML para un entrenador
    private static void exportarCarnetXML() {
        if (auth.obtenerPerfilUsuarioActual().equals("entrenador")) {
            Entrenador entrenador = auth.getEntrenador(auth.getNombreActual());
            if (entrenador != null) {
                Exportar exportar = new Exportar(entrenador);
                exportar.ejecutar();
                System.out.println("Carnet exportado correctamente.");
            } else {
                System.out.println("Error: Entrenador no encontrado.");
            }
        } else {
            System.out.println("Solo los entrenadores pueden exportar su carnet.");
        }
    }

    // Exportar datos del torneo en XML
    private static void exportarDatosTorneo() {
        if (auth.obtenerPerfilUsuarioActual().equals("administradorTorneo")) {
            System.out.println("Exportando datos del torneo en XML...");
            // Lógica de exportación del torneo aquí
        } else {
            System.out.println("Solo los administradores de torneo pueden exportar datos del torneo.");
        }
    }

    // Cerrar sesión del usuario actual
    private static void cerrarSesion() {
        auth.cerrarSesion();
    }
}
