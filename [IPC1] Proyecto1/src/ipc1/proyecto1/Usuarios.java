package ipc1.proyecto1;

import java.util.ArrayList;
import javax.swing.*;

public class Usuarios extends JFrame {

    // Definiciones de las listas
    public static ArrayList<Persona> personas = new ArrayList<>();
    public static ArrayList<Persona> doctores = new ArrayList<>();
    public static ArrayList<Persona> pacientes = new ArrayList<>();
    public static ArrayList<Producto> producto = new ArrayList<>();
    public static ArrayList<Consulta> consulta = new ArrayList<>();
    // Métodos para obtener las listas
    public static ArrayList<Persona> getPersonas() {
        return personas;
    }
    public static ArrayList<Persona> getDoctores() {
        return doctores;
    }
    public static ArrayList<Persona> getPacientes() {
        return pacientes;
    }
    
    public static ArrayList<Producto> getProductos() {
        return producto;
    }
    public static ArrayList<Consulta> getConsultas() {
        return consulta;
    }
    
    // Método para actualizar listas de doctores y pacientes
    public static void actualizarListas() {
        doctores.clear(); // Limpia la lista de doctores
        pacientes.clear(); // Limpia la lista de pacientes
        for (Persona persona : personas) {
            if (persona.getEspecialidad() != null) {
                doctores.add(persona);
            } else {
                pacientes.add(persona);
            }
        }
    }
    
    // Clase para representar una consulta
    static class Consulta {
        public int noConsulta;
        public String fecha;
        public String hora;
        public String estado;

        // Constructor para la clase Consulta
        public Consulta(int noConsulta, String fecha, String hora, String estado) {
            this.noConsulta = noConsulta;
            this.fecha = fecha;
            this.hora = hora;
            this.estado = estado;
        }
    }

    // Clase para representar un producto
    static class Producto {
        public int codigoProducto;
        public String nombre; // Corregido de int a String
        public int cantidad;
        public int precio;

        // Constructor para la clase Producto
        public Producto(int codigoProducto, String nombre, int cantidad, int precio) {
            this.codigoProducto = codigoProducto;
            this.nombre = nombre;
            this.cantidad = cantidad;
            this.precio = precio;
        }
        public int getCodigo() {
        return codigoProducto;
    }
    public String getNombre() {
        return nombre;
    }

    public int getAnimales() {
        return cantidad;
    }

    public int getPrecio() {
        return precio;
    }
    }

    // Clase para representar una persona
    static class Persona {
        public int codigo;
        public String nombre;
        public String apellido;
        public String genero;
        public int edad;
        public String especialidad; // Solo para doctores
        public String password;
        public int telefono;

        // Constructor para la clase Persona
        public Persona(int codigo, String nombre, String apellido, String genero, int edad, String especialidad, String password, int telefono) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.apellido = apellido;
            this.genero = genero;
            this.edad = edad;
            this.especialidad = especialidad;
            this.password = password;
            this.telefono = telefono;
        }
    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getGenero() {
        return genero;
    }

    public int getEdad() {
        return edad;
    }

    public String getEspecialidad() {
        return especialidad;
    }
    public String getPassword() {
        return password;
    }    
    public int getTelefono() {
        return telefono;
    }  
}
    }