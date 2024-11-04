package org.example;

public class Main {
    public static void main(String[] args) {
        Autenticacion auth = new Autenticacion("credenciales.txt");

        // Intento de inicio de sesión
        auth.iniciarSesion("usuarioEjemplo", "contrasenaEjemplo");

        // Ver el perfil del usuario actual
        System.out.println("Perfil del usuario autenticado: " + auth.obtenerPerfilUsuarioActual());

        // Cerrar sesión
        auth.cerrarSesion();
    }
}
