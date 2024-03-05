package ipc1.proyecto1;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Admin extends JFrame {
    // Declaramos nuestras matrices
    // Matriz doctores
    public static ArrayList<String> doctorName = new ArrayList<>();
    public static ArrayList<String> doctorLast = new ArrayList<>();
    public static ArrayList<String> passwordArray = new ArrayList<>();
    public static ArrayList<String> especialidades = new ArrayList<>();
    public static ArrayList<String> genero = new ArrayList<>();
    public static ArrayList<Integer> doctorEdad = new ArrayList<>();

    public Admin() {
        //--------------------------------------------Imagenes------------------------------
        // Agrega la imagen de login
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("./images/add.png")); // Carga la imagen
        Image imageDimension = imageIcon.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Ajusta el tamaño de la imagen
        ImageIcon adjustedImageIcon = new ImageIcon(imageDimension); // Crea un nuevo ImageIcon con la imagen ajustada
        JLabel imageLabel = new JLabel(adjustedImageIcon); // Crea un JLabel para mostrar la imagen
        imageLabel.setBounds(550, 40, 45, 45); // Establece la posición y tamaño del JLabel de la imagen

        ImageIcon imageIcon1 = new ImageIcon(getClass().getResource("./images/users-alt.png")); // Carga la imagen
        Image imageDimension1 = imageIcon1.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Ajusta el tamaño de la imagen
        ImageIcon adjustedImageIcon1 = new ImageIcon(imageDimension1); // Crea un nuevo ImageIcon con la imagen ajustada
        JLabel imageLabel1 = new JLabel(adjustedImageIcon1); // Crea un JLabel para mostrar la imagen
        imageLabel1.setBounds(630, 40, 45, 45); // Establece la posición y tamaño del JLabel de la imagen

        ImageIcon imageIcon2 = new ImageIcon(getClass().getResource("./images/cross.png")); // Carga la imagen
        Image imageDimension2 = imageIcon2.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Ajusta el tamaño de la imagen
        ImageIcon adjustedImageIcon2 = new ImageIcon(imageDimension2); // Crea un nuevo ImageIcon con la imagen ajustada
        JLabel imageLabel2 = new JLabel(adjustedImageIcon2); // Crea un JLabel para mostrar la imagen
        imageLabel2.setBounds(590, 120, 45, 45); // Establece la posición y tamaño del JLabel de la imagen         
        
        
        
        setTitle("ADMIN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 720);

        // Crear un JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Agregar pestañas

        //----------------------------------Pestaña Medicos-------------------------
        JPanel adminPanel1 = createGradientPanel();
        adminPanel1.setLayout(null);
        JPanel tablaDoctor = new JPanel();
        tablaDoctor.setSize(450, 430);
        tablaDoctor.setLocation(30, 50);
        adminPanel1.add(tablaDoctor);
        adminPanel1.add(imageLabel); // Agrega el JLabel de la imagen al panel de fondo
        adminPanel1.add(imageLabel1);
        adminPanel1.add(imageLabel2);

        // Crear la tabla de médicos y llenarla con los datos
        JTable doctorTable = createDoctorTable();

        // Agregar la tabla de médicos al panel
        tablaDoctor.add(new JScrollPane(doctorTable), BorderLayout.CENTER);

        // Agregar el botón "Salir" al adminPanel1
        JButton exit1 = createExitButton();
        adminPanel1.add(exit1);

        tabbedPane.addTab("Doctores", adminPanel1);

        //Panel Consultas
        JPanel adminPanel2 = createGradientPanel();
        adminPanel2.setLayout(null);
        adminPanel2.add(new JLabel("Contenido de la pestaña 2"), BorderLayout.CENTER);

        // Agregar el botón "Salir" al adminPanel2
        JButton exit2 = createExitButton();
        adminPanel2.add(exit2);

        tabbedPane.addTab("Consultas", adminPanel2);

        //Panel Pacientes
        
        JPanel adminPanel3 = createGradientPanel();
        adminPanel3.setLayout(null);
        // Agregar el botón "Salir" al adminPanel3
        JButton exit3 = createExitButton();
        adminPanel3.add(exit3);

        tabbedPane.addTab("Pacientes", adminPanel3);

        // Agregar el JTabbedPane al JFrame
        add(tabbedPane);

        setVisible(true);
    }

    // Método para crear un panel con degradado
    public JPanel createGradientPanel() {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Color colorInicio = new Color(0X8CB7C8);
                Color colorFin = new Color(0X7D9EEF);
                GradientPaint gradient = new GradientPaint(0, 0, colorInicio, getWidth(), getHeight(), colorFin);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        return panel;
    }

    // Método para crear y llenar la tabla de médicos
    private JTable createDoctorTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Codigo");
        model.addColumn("Nombre");
        model.addColumn("Apellidos");
        model.addColumn("Especialidad");
        model.addColumn("Genero");
        model.addColumn("Edad");

        // Agregar los datos de los médicos al modelo de la tabla
        for (int i = 0; i < doctorName.size(); i++) {
            model.addRow(new Object[]{doctorName.get(i), doctorLast.get(i), especialidades.get(i), genero.get(i), doctorEdad.get(i)});
        }

        return new JTable(model);
    }

    // Método para crear un botón de salida
    private JButton createExitButton() {
        JButton exitButton = new JButton("Salir");
        exitButton.setBounds(10, 10, 60, 20); // Ajusta las coordenadas y el tamaño según tus necesidades de diseño
        exitButton.setFont(new Font("Arial", Font.PLAIN, 9));
        return exitButton;
    }
}
