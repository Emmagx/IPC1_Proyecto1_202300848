
package ipc1.proyecto1;

import java.util.ArrayList;
import javax.swing.*;

public class Usuarios extends JFrame {
    
        public static void actualizarListas() {
        doctores.clear(); // Limpia la lista antes de volver a llenarla
        pacientes.clear(); // Limpia la lista antes de volver a llenarla
        for (Persona persona : personas) {
            if (persona.getEspecialidad() != null) {
                doctores.add(persona);
            } else {
                pacientes.add(persona);
            }
        }
    }

    
    static class Persona {
    public int codigo;
    public String nombre;
    public String apellido;
    public String genero;
    public int edad;
    public String especialidad; // Solo para doctores
    public String password;
    public int telefono;
    

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
     // Lista para almacenar datos de doctores y pacientes
    public static ArrayList<Persona> personas = new ArrayList<>();
    public static ArrayList<Persona> doctores = new ArrayList<>();
    public static ArrayList<Persona> pacientes = new ArrayList<>();
    
    public static ArrayList<Persona> getPersonas() {
        return personas;
    }
    public static ArrayList<Persona> getDoctores() {
        return doctores;
    }
    public static ArrayList<Persona> getPacientes() {
        return pacientes;
    }
}