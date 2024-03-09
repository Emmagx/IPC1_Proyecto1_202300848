package ipc1.proyecto1;

import static ipc1.proyecto1.Proyecto1.contadorMedicos;
import static ipc1.proyecto1.Proyecto1.contadorPacientes;
import ipc1.proyecto1.Usuarios;
import ipc1.proyecto1.Usuarios.Persona;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Registros extends JFrame {
ArrayList<Persona> personas = Usuarios.getPersonas();
ArrayList<Persona> doctores = Usuarios.getDoctores();
ArrayList<Persona> pacientes = Usuarios.getPacientes();
    int telefonoInt;
    private JTextField nameField;
    private JTextField lastNameField;

    JPanel panelRegistro = new JPanel() {
        
        @Override
        public void paintComponent(Graphics g) {
            
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            // Define los colores del degradado
            Color colorInicio = new Color(0X8CB7C8); // HEX azul oscurito
            Color colorFin = new Color(0X7D9EEF); // HEX, azul clarito
            // Crea el degradado y lo aplica al fondo del panel
            GradientPaint gradient = new GradientPaint(0, 0, colorInicio, getWidth(), getHeight(), colorFin);
            g2d.setPaint(gradient);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }  
    };
    JPanel panelRegistroMedico = new JPanel() {
        @Override
        public void paintComponent(Graphics g) {
            
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            // Define los colores del degradado
            Color colorInicio = new Color(0X8CB7C8); // HEX azul oscurito
            Color colorFin = new Color(0X7D9EEF); // HEX, azul clarito
            // Crea el degradado y lo aplica al fondo del panel
            GradientPaint gradient = new GradientPaint(0, 0, colorInicio, getWidth(), getHeight(), colorFin);
            g2d.setPaint(gradient);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }  
    };
    

        public void initializeUIRegister() {
        addComponents(false, true);
        setIconImage(new ImageIcon(getClass().getResource("./images/equipo-medico.png")).getImage());
        setSize(370, 300);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Registro");
        // Establece el ícono de la ventana
        
        // Establece el layout del panel de registro como nulo (null layout)
        panelRegistro.setLayout(null);
        // Agrega el panel de registro al frame
        add(panelRegistro);
    }
    
    
    
    public void initializeUIMedico() {
        
        addComponents(true, false);
        // Establece el ícono de la ventana
        setIconImage(new ImageIcon(getClass().getResource("./images/equipo-medico.png")).getImage());
        setSize(400, 400);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Registro Persona");

        // Establece el layout del panel de registro como nulo (null layout)
        panelRegistro.setLayout(null);
        // Agrega el panel de registro al frame
        add(panelRegistro);
    }
    
    
    public void initializeUILogin() {
        addComponents(false, false);
        setIconImage(new ImageIcon(getClass().getResource("./images/equipo-medico.png")).getImage());
        setSize(370, 300);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Registro");
        // Establece el ícono de la ventana
        
        // Establece el layout del panel de registro como nulo (null layout)
        panelRegistro.setLayout(null);
        // Agrega el panel de registro al frame
        add(panelRegistro);
    }

    public void addComponents(boolean isDoctor, boolean isRegister) {
        revalidate();
        repaint();
        String especialiadad;
        setLocationRelativeTo(null);
        // Agrega los componentes necesarios para el formulario de registro al panelRegistro
        
        JLabel nameLabel = new JLabel("Nombre:");
        nameLabel.setBounds(20, 20, 80, 30); // Establece la posición y el tamaño del JLabel
        panelRegistro.add(nameLabel);
        
        nameField = new JTextField(); // Crea un JTextField sin especificar el ancho
        nameField.setBounds(120, 20, 200, 30); // Establece la posición y el tamaño del JTextField
        panelRegistro.add(nameField);
        
        
       
        JLabel lastNameLabel = new JLabel("Apellido:");
        lastNameLabel.setBounds(20, 60, 80, 30); // Establece la posición y el tamaño del JLabel
        panelRegistro.add(lastNameLabel);
        
        lastNameField = new JTextField();
        lastNameField.setBounds(120, 60, 200, 30);
        panelRegistro.add(lastNameField);
        
        
        JLabel Password = new JLabel("Contrasena:");
        Password.setBounds(20, 100, 100, 30); // Establece la posición y el tamaño del JLabel
        panelRegistro.add(Password);
        
        
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(120, 100, 200, 30);
        panelRegistro.add(passwordField);
        
        
        JLabel GeneroLabel = new JLabel("Genero:");
        GeneroLabel.setBounds(20, 140, 100, 30); // Establece la posición y el tamaño del JLabel
        panelRegistro.add(GeneroLabel);
        String[] Genero = {"Masculino", "Femenino", "Otro"};
        JComboBox<String> comboBoxGenero = new JComboBox<>(Genero);
        comboBoxGenero.setBounds(120, 140, 90, 30);
        panelRegistro.add(comboBoxGenero);
        
        
        JLabel Edad = new JLabel("Edad:");
        Edad.setBounds(220, 140, 50, 30); // Establece la posición y el tamaño del JLabel
        panelRegistro.add(Edad);
        
        JTextField EdadField = new JTextField();
        EdadField.setBounds(265, 140, 50, 30);
        
        JLabel telefono = new JLabel("Telefono:");
        telefono.setBounds(20, 180, 80, 30); // Establece la posición y el tamaño del JLabel
        panelRegistro.add(telefono);
        
        JTextField Telefono = new JTextField();
        Telefono.setBounds(120, 180, 80, 30);
        panelRegistro.add(Telefono);
        Telefono.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    e.consume();
                }
            }
            
        });
        // Agrega un KeyListener para permitir solo números
        EdadField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    e.consume();
                }
            }
            
        }
        );
        panelRegistro.add(EdadField);
        
        
        JButton Registrarse = new JButton("Registrarse");
        Registrarse.setVisible(true);
        JTextField especialidadField = new JTextField();
        especialidadField.setBounds(120, 220, 200, 30);
        if (isDoctor){
            System.out.println("Es doctor ");
            Registrarse.setBounds(218, 260, 100, 20);
            JLabel especialidadJL = new JLabel("Especialidad:");
            especialidadJL.setBounds(20, 220, 100, 30);
            panelRegistro.add(especialidadJL); // Asegúrate de añadir al panelRegistro.


            panelRegistro.add(especialidadField); 
            

        }
        if (isRegister){
            System.out.println("No es doctor");
            Registrarse.setBounds(218, 220, 100, 20);
            
        }
            panelRegistro.add(Registrarse);
            Registrarse.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String edad = EdadField.getText();
                
                String TelefonoString = Telefono.getText();
                if (TelefonoString.isEmpty()){
                    TelefonoString = null;
                }
                else{
                    telefonoInt = Integer.parseInt(TelefonoString);
                }
                String nombre = nameField.getText();
                String Apellido = lastNameField.getText();
                String contrasena = passwordField.getText();
                String especialidad = especialidadField.getText();
                Object selectedItem = comboBoxGenero.getSelectedItem();
                String gender = (String) selectedItem;
                if (especialidad.isEmpty()){
                especialidad = null;
                
                }
                if (contrasena.isEmpty() || nombre.isEmpty() || Apellido.isEmpty() || edad.isEmpty()){
                    System.out.println("Algo esta vacio");
                    JOptionPane.showMessageDialog(null, ("Rellena todos los campos"));
                }
                else{
                    
                    int edadInt = Integer.parseInt(edad);
                    System.out.println("Edad : " + edadInt);
                    System.out.println("Genero " + gender);
                    System.out.println("Nombre " + nombre);
                    System.out.println("Apellido " + Apellido);
                    System.out.println("Contrasena " + contrasena);
                        if (especialidad != null){
                            
                            int codigo = 202200000 + contadorMedicos;
                            contadorMedicos++;
                            System.out.println("Contador Medicos " + contadorMedicos);
                            System.out.println("Antes de añadir: " + personas.size());
                            personas.add(new Persona(codigo, nombre, Apellido, gender, edadInt, especialidad, contrasena, telefonoInt));
                            doctores.add(new Persona(codigo, nombre, Apellido, gender, edadInt, especialidad, contrasena, telefonoInt));
                            System.out.println("Después de añadir: " + personas.size());
                            System.out.println("Último usuario registrado: " + personas.get(personas.size() - 1).getCodigo());
                            System.out.println("Último usuario registrado: " + personas.get(personas.size() - 1).getNombre());
                            JOptionPane.showMessageDialog(panelRegistro, "Su usuario es: " + codigo);
                            
//                            if (isRegister){Login login = new Login();
//                            login.setVisible(true);
//                            dispose();}
                        }
                        else{
                            int codigo = 202300000 + contadorPacientes;
                            contadorPacientes++;
                            System.out.println("Contador pacientes " + contadorPacientes);
                            System.out.println("Después de añadir: " + personas.size());
                            personas.add(new Persona(codigo, nombre, Apellido, gender, edadInt, null, contrasena, telefonoInt));
                            pacientes.add(new Persona(codigo, nombre, Apellido, gender, edadInt, null, contrasena, telefonoInt));
                            System.out.println("Después de añadir: " + personas.size());
                            System.out.println("Último usuario registrado: " + personas.get(personas.size() - 1).getCodigo());
                            System.out.println("Último usuario registrado: " + personas.get(personas.size() - 1).getNombre());
                            JOptionPane.showMessageDialog(panelRegistro, "Su usuario es: " + codigo);
                            if (isRegister){Login login = new Login();
                            login.setVisible(true);
                            dispose();}
   
                        }

                }


                
                
            }
            
            
        });
    }
    
    public void agregarPersona(boolean isDoctor, boolean isRegister){
        if (isDoctor && !isRegister){
            setSize(400, 400);
            initializeUIMedico();
            
        }
        if (isRegister && !isDoctor){
            initializeUIRegister();
        }
        if(!isDoctor && !isRegister) {
            initializeUILogin();
        }
    panelRegistro.revalidate();
    panelRegistro.repaint();


    
    setVisible(true);
}
    public void registroMedicina(){
        
        
    }
}
