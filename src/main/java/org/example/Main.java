package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Incio();
    }
    public static void Incio() {
        Scanner sc = new Scanner(System.in);
        Autenticacion auth = new Autenticacion();

        // Inicio del menú principal
        while (true) {
                System.out.println("Bienvenido al sistema de torneos Pokémon.");
                System.out.println("1. Iniciar sesión");
                System.out.println("2. Registrarse como nuevo entrenador");
                System.out.println("3. Salir");

                int opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("Nombre de usuario: ");
                        String nombreExistente = sc.nextLine();
                        System.out.print("Contraseña: ");
                        String password = sc.nextLine();
                        String[] datosUsuario = auth.autenticarExistentes(nombreExistente, password);
                        if (datosUsuario != null) {
                            System.out.println("Bienvenido " + nombreExistente + ". Perfil: " + datosUsuario[1]);
                        } else {
                            System.out.println("Credenciales incorrectas.");
                        }
                        while (datosUsuario == null) {
                            System.out.print("Nombre de usuario: ");
                            nombreExistente = sc.nextLine();
                            System.out.print("Contraseña: ");
                            password = sc.nextLine();
                            datosUsuario = auth.autenticarExistentes(nombreExistente, password);
                            if (datosUsuario != null) {
                                System.out.println("Bienvenido " + nombreExistente + ". Perfil: " + datosUsuario[1]);
                            } else {
                                System.out.println("Credenciales incorrectas.");
                            }
                        }
                    case 2:
                        System.out.print("Nombre completo: ");
                        String nombreNuevo = sc.nextLine();
                        System.out.print("Nacionalidad: ");
                        String nacionalidad = sc.nextLine();
                        String[] datosNuevo = auth.autenticarNuevos(nombreNuevo, nacionalidad);
                        if (datosNuevo != null) {
                            System.out.println("Bienvenido " + nombreNuevo + ". Perfil: " + datosNuevo[1]);
                        } else {
                            System.out.println("Credenciales existentes, inicie sesion.");
                            Incio();
                        }
                    case 3:
                        System.exit(0);
                }
        }
    }
}
