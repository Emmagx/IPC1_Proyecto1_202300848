package ipc1.proyecto1;

import ipc1.proyecto1.Usuarios.Persona;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Login extends Proyecto1 {
ArrayList<Persona> personas = Usuarios.getPersonas();

    // Componentes de la interfaz de usuario
    JLabel userName = new JLabel(); // Etiqueta para el nombre de usuario
    JLabel userPass = new JLabel(); // Etiqueta para la contraseña
    JLabel showPassLabel = new JLabel("Mostrar Contraseña"); // Etiqueta para mostrar contraseña
    JTextField usernameField = new JTextField(); // Campo de texto para el nombre de usuario
    JLabel registerLabel = new JLabel("No tienes cuenta?"); // Etiqueta para el registro
    JPasswordField passwordField = new JPasswordField(); // Campo de contraseña
    JButton loginButton = new JButton("LOGIN"); // Botón de inicio de sesión
    JLabel registerButton = new JLabel("Regístrate"); // Botón de registro
    Checkbox showPassCheckbox = new Checkbox(); // Checkbox para mostrar la contraseña

    JPanel background;

    public Login() {

        initializeUI(); // Inicializa la interfaz de usuario
        setupLayout(); // Configura el diseño de la interfaz
        addComponents(); // Agrega los componentes a la interfaz
        addEvents(); // Agrega eventos a los componentes
    }

    private void initializeUI() {
        // Configuración inicial de la ventana
        
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Login");
        // Establece el ícono de la ventana
        setIconImage(new ImageIcon(getClass().getResource("./images/equipo-medico.png")).getImage());
    }

    private void setupLayout() {
        setLocationRelativeTo(null);
        background = createGradientPanel(); // Utiliza el panel de fondo creado con el método createGradientPanel()
        background.setLayout(null); // Utiliza un diseño nulo para permitir la colocación absoluta de componentes
    }

    private void addComponents() {

        // Agrega los componentes al panel de fondo
        userName.setText("Usuario:"); // Establece el texto de la etiqueta de usuario
        userName.setBounds(40, 70, 80, 20); // Establece la posición y tamaño de la etiqueta de usuario
        userName.setFont(new Font("Arial", Font.PLAIN, 15)); // Establece la fuente de la etiqueta de usuario
        background.add(userName); // Agrega la etiqueta de usuario al panel de fondo

        usernameField.setBounds(40, 100, 300, 25); // Establece la posición y tamaño del campo de texto de usuario
        // Agrega un KeyListener para permitir solo números
        usernameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    e.consume();
                }
            }
        });
        background.add(usernameField); // Agrega el campo de texto de usuario al panel de fondo

        userPass.setText("Contraseña:"); // Establece el texto de la etiqueta de contraseña
        userPass.setBounds(40, 140, 100, 20); // Establece la posición y tamaño de la etiqueta de contraseña
        userPass.setFont(new Font("Arial", Font.PLAIN, 15)); // Establece la fuente de la etiqueta de contraseña
        background.add(userPass); // Agrega la etiqueta de contraseña al panel de fondo

        passwordField.setEchoChar('\u25CF');
        passwordField.setBounds(40, 160, 300, 25); // Establece la posición y tamaño del campo de contraseña
        background.add(passwordField); // Agrega el campo de contraseña al panel de fondo

        loginButton.setFont(new Font("Arial", Font.PLAIN, 10)); // Establece la fuente del botón de inicio de sesión
        loginButton.setSize(68, 18); // Establece el tamaño del botón de inicio de sesión
        loginButton.setLocation(272, 215); // Establece la posición del botón de inicio de sesión
        background.add(loginButton); // Agrega el botón de inicio de sesión al panel de fondo

        registerButton.setFont(new Font("Arial", Font.PLAIN, 10)); // Establece la fuente del botón de registro
        registerButton.setSize(90, 18); // Establece el tamaño del botón de registro
        registerButton.setLocation(40, 230); // Establece la posición del botón de registro
        registerButton.setOpaque(false); // Hace que el botón de registro sea transparente
        background.add(registerButton); // Agrega el botón de registro al panel de fondo

        registerLabel.setBounds(40, 210, 150, 20); // Establece la posición y tamaño de la etiqueta de registro
        registerLabel.setFont(new Font("Arial", Font.PLAIN, 9)); // Establece la fuente de la etiqueta de registro
        background.add(registerLabel); // Agrega la etiqueta de registro al panel de fondo

        showPassCheckbox.setBounds(40, 190, 10, 10); // Establece la posición y tamaño del checkbox para mostrar contraseña
        background.add(showPassCheckbox); // Agrega el checkbox al panel de fondo

        showPassLabel.setBounds(55, 190, 150, 10); // Establece la posición y tamaño de la etiqueta "Mostrar Contraseña"
        showPassLabel.setFont(new Font("Arial", Font.PLAIN, 9)); // Establece la fuente de la etiqueta "Mostrar Contraseña"
        background.add(showPassLabel); // Agrega la etiqueta "Mostrar Contraseña" al panel de fondo

        // Agrega la imagen de login
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("./images/intimidad.png")); // Carga la imagen
        Image imageDimension = imageIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH); // Ajusta el tamaño de la imagen
        ImageIcon adjustedImageIcon = new ImageIcon(imageDimension); // Crea un nuevo ImageIcon con la imagen ajustada
        JLabel imageLabel = new JLabel(adjustedImageIcon); // Crea un JLabel para mostrar la imagen
        imageLabel.setBounds(160, 15, 80, 80); // Establece la posición y tamaño del JLabel de la imagen
        background.add(imageLabel); // Agrega el JLabel de la imagen al panel de fondo

        add(background); // Agrega el panel de fondo a la ventana
    }

    private void addEvents() {
        // Agrega eventos al checkbox para mostrar contraseña
        showPassCheckbox.addItemListener((ItemEvent e) -> {
            // Verifica si el checkbox ha cambiado su estado
            if (e.getStateChange() == ItemEvent.SELECTED) {
                // Si está seleccionado, muestra la contraseña
                passwordField.setEchoChar((char) 0);
            }
            else {
                // Si no está seleccionado, oculta la contraseña
                passwordField.setEchoChar('\u25CF');
            }
        });

        registerButton.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            // Crear una instancia de la clase Registros
            Registros registrosWindow = new Registros();
            dispose();
            // Hacer visible la ventana de registros
            setVisible(false); // Ocultar la ventana actual
            registrosWindow.agregarPersona(false, true);
            registrosWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configurar el cierre de la ventana de registros
        }
});

        loginButton.addActionListener((var e) -> {
            // Obtener el texto del JTextField
            String texto = usernameField.getText();
            String password = passwordField.getText();
            // Convertir el texto a un entero
            


            if(texto.isEmpty() || password.isEmpty()){
                JOptionPane.showMessageDialog(this, ("Rellene todos los campos"));
            }
            else {
                int user = Integer.parseInt(texto);
                    //Imprimimos el user
                    System.out.println("El usuario es: " + user);
                    System.out.println("La contrasena es: " + password);
                if(user == 202300848  && "proyecto1IPC1".equals(password)){
                    System.out.println("Entrando como admin...");
                    System.out.println("Espere un momento");
                    Admin admin = new Admin();
                    admin.setVisible(true);
                    dispose();
                }
                if(user != 202300848) {
                    boolean encontrado = false;
                    for (Persona paciente : personas) {
                        if (paciente.getCodigo() == user && paciente.getPassword().equals(password)) {
                            System.out.println("No. Usuarios:  " + personas.size());
                            System.out.println("Entrando como " + user);
                            System.out.println("Y contraseña " + password);
                            encontrado = true;
    //                        dispose();
                            if (paciente.getEspecialidad()== null ){
                                System.out.println("Entrando como paciente...");}
                            else {
                                System.out.println("Entrando como medico");
                            }
                            break; // Sale del bucle una vez que encuentra al usuario
                        }
                    }

                    if (!encontrado) {
                        JOptionPane.showMessageDialog(this, ("Usuario o contraseña incorrectos."));
                        System.out.println("Usuario o contraseña incorrectos.");
    }

                }                
            
            }

        });
    }

    // Con esto agregamos le degradado
    private JPanel createGradientPanel() {

        JPanel gradientPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Color colorInicio = new Color(0X8CB7C8);
                Color colorFin = new Color(0X7D9EEF);
                GradientPaint gradient = new GradientPaint(0, 0, colorInicio, getWidth(), getHeight(), colorFin);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        return gradientPanel;
    }
}
