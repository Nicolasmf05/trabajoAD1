package org.example;

    public class Usuario {
        private String nombre;
        private String contrasena;
        private String perfil;
        private String id;

        // Constructor
        public Usuario(String nombre, String contrasena, String perfil, String id) {
            this.nombre = nombre;
            this.contrasena = contrasena;
            this.perfil = perfil;
            this.id = id;
        }

        // Getters
        public String getNombre() { return nombre; }
        public String getContrasena() { return contrasena; }
        public String getPerfil() { return perfil; }
        public String getId() { return id; }
    }


