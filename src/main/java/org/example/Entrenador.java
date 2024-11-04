package org.example;

public class Entrenador {
        private String id;


    private String nombre;
        private String nacionalidad;
        private Carnet carnet;

        // Constructor
        public Entrenador(String id, String nombre, String nacionalidad, Carnet carnet) {
            this.id = id;
            this.nombre = nombre;
            this.nacionalidad = nacionalidad;
            this.carnet = carnet;
        }

        // Getters y Setters
        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNacionalidad() {
            return nacionalidad;
        }

        public void setNacionalidad(String nacionalidad) {
            this.nacionalidad = nacionalidad;
        }

        public Carnet getCarnet() {
            return carnet;
        }

        public void setCarnet(Carnet carnet) {
            this.carnet = carnet;
        }


        // toString() para impresión de datos del entrenador
        @Override
        public String toString() {
            return "Entrenador{" +
                    "id='" + id + '\'' +
                    ", nombre='" + nombre + '\'' +
                    ", nacionalidad='" + nacionalidad + '\'' +
                    ", carnet=" + carnet +
                    '}';
        }
    }

