package ipc1.proyecto1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Registros extends JFrame {
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
    

    
    public void initializeUIMedico() {
        addComponents(true);
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
    
    
    public void initializeUI() {
        addComponents(false);
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

    public void addComponents(boolean isDoctor) {
        revalidate();
        repaint();
        
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
        comboBoxGenero.setBounds(120, 140, 100, 30);
        panelRegistro.add(comboBoxGenero);
        
        
        JLabel Edad = new JLabel("Edad:");
        Edad.setBounds(20, 180, 50, 30); // Establece la posición y el tamaño del JLabel
        panelRegistro.add(Edad);
        
        JTextField EdadField = new JTextField();
        EdadField.setBounds(120, 180, 40, 30);
        
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
        if (isDoctor){
            System.out.println("Es doctor ");
            Registrarse.setBounds(218, 300, 100, 20);
            JLabel especialidadJL = new JLabel("Especialidad:");
            especialidadJL.setBounds(20, 220, 100, 30);
            panelRegistro.add(especialidadJL); // Asegúrate de añadir al panelRegistro.

            JTextField especialidadField = new JTextField();
            especialidadField.setBounds(120, 220, 200, 30);
            panelRegistro.add(especialidadField); 
        }
        else{
            System.out.println("No es doctor");
            Registrarse.setBounds(218, 220, 100, 20);
        }
            panelRegistro.add(Registrarse);
            Registrarse.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String edad = EdadField.getText();
                
                String nombre = nameField.getText();
                String Apellido = lastNameField.getText();
                String contrasena = passwordField.getText();
                
                Object selectedItem = comboBoxGenero.getSelectedItem();
                String gender = (String) selectedItem;
                
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
                    
                    JOptionPane.showMessageDialog(panelRegistro, "Su usuario es: codigo");
//                    Login login = new Login();
//                    login.setVisible(true);
                    dispose();
                }


                
                
            }
            
            
        });
    }
    
    public void agregarPersona(boolean isDoctor){
        if (isDoctor){
            initializeUIMedico();
            setSize(400, 400);
        }
        else {
            initializeUI();
        }
     // Configura la UI para médicos
    
    // Añade campos específicos de registro para médicos al panelRegistro.
    // Añade al panelRegistro.
    
    panelRegistro.revalidate();
    panelRegistro.repaint();


    
    setVisible(true);
}
    public void registroPacientes(){
        
    }
}
