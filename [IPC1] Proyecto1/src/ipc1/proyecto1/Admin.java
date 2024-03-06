package ipc1.proyecto1;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Admin extends JFrame {
    
    // Matrices para almacenar datos de doctores y pacientes
    public static ArrayList<Integer> codigos = new ArrayList<>();
    public static ArrayList<String> doctorName = new ArrayList<>();
    public static ArrayList<String> doctorLast = new ArrayList<>();
    public static ArrayList<String> passwordArray = new ArrayList<>();
    public static ArrayList<String> especialidades = new ArrayList<>();
    public static ArrayList<String> genero = new ArrayList<>();
    public static ArrayList<Integer> doctorEdad = new ArrayList<>();
    
    public static ArrayList<Integer> patientCode = new ArrayList<>();
    public static ArrayList<String> patientName = new ArrayList<>();
    public static ArrayList<String> patientLast = new ArrayList<>();
    public static ArrayList<String> passwordPatientArray = new ArrayList<>();
    public static ArrayList<String> generoPaciente = new ArrayList<>();
    public static ArrayList<Integer> edadPaciente = new ArrayList<>();

    public Admin() {
        DoctoresDefault();
        patientDefault();
        setResizable(false);
        setTitle("ADMIN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Crear un JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Agregar pestañas
        tabbedPane.addTab("DOCTORES", createDoctorPanel());
        tabbedPane.addTab("PACIENTES", createPacientePanel());
        tabbedPane.addTab("FARMACIA", createFarmaciaPanel());

        // Agregar el JTabbedPane al JFrame
        add(tabbedPane);

        setVisible(true);
    }

    // Método para crear el panel de doctores
    private JPanel createDoctorPanel() {
        JPanel adminPanel = createGradientPanel();
        adminPanel.setLayout(null);

        // Crear y agregar la tabla de doctores al panel
        JTable doctorTable = createDoctorTable();
        JPanel tablaDoctor = new JPanel();
        tablaDoctor.setSize(450, 430);
        tablaDoctor.setLocation(30, 50);
        tablaDoctor.add(new JScrollPane(doctorTable));
        adminPanel.add(tablaDoctor);

        // Crear y agregar los botones de acciones al panel
        setupImagesAndButtons(adminPanel);

        // Crear y mostrar la gráfica de especialidades
        JPanel graficaEspecialidades = createGradientPanel();
        graficaEspecialidades.setBounds(490, 200, 270, 180);
        adminPanel.add(graficaEspecialidades);
        JLabel tituloPanelGrafica = new JLabel("Grafica de especialidades");
        tituloPanelGrafica.setBounds(543, 160, 200, 20);
        tituloPanelGrafica.setFont(new Font("Arial", Font.PLAIN, 15));
        adminPanel.add(tituloPanelGrafica);
        updateEspecialidadesChart(graficaEspecialidades);

        // Agregar el botón "Salir" al panel
        JButton exitButton = createExitButton();
        adminPanel.add(exitButton);

        return adminPanel;
    }

    // Método para crear el panel de pacientes
    private JPanel createPacientePanel() {
        JPanel adminPanel = createGradientPanel();
        adminPanel.setLayout(null);

        // Crear y agregar la tabla de pacientes al panel
        JTable pacientesTable = createPacientesTable();
        JPanel tablaPacientes = new JPanel();
        tablaPacientes.setSize(450, 430);
        tablaPacientes.setLocation(30, 50);
        tablaPacientes.add(new JScrollPane(pacientesTable));
        adminPanel.add(tablaPacientes);

        // Crear y agregar los botones de acciones al panel
        setupImagesAndButtons(adminPanel);

        // Agregar el botón "Salir" al panel
        JButton exitButton = createExitButton();
        adminPanel.add(exitButton);

        return adminPanel;
    }

    // Método para crear el panel de la farmacia
    private JPanel createFarmaciaPanel() {
        JPanel adminPanel = createGradientPanel();
        adminPanel.setLayout(null);

        // Agregar el botón "Salir" al panel
        JButton exitButton = createExitButton();
        adminPanel.add(exitButton);

        // Crear y agregar los botones de acciones al panel
        setupImagesAndButtons(adminPanel);

        return adminPanel;
    }

    // Método para agregar imágenes y botones a un panel
    private void setupImagesAndButtons(JPanel panel) {
        // Imagen y botón de agregar médicos
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("./images/add.png"));
        Image imageDimension = imageIcon.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH);
        ImageIcon adjustedImageIcon = new ImageIcon(imageDimension);
        JLabel imageLabel = new JLabel(adjustedImageIcon);
        imageLabel.setBounds(510, 60, 45, 45);
        JButton buttonAdd = new JButton("Agregar");
        buttonAdd.setFont(new Font("Arial", Font.PLAIN, 13));
        buttonAdd.setBounds(490, 110, 80, 20);

        // Imagen y botón de Editar usuario
        ImageIcon imageIcon1 = new ImageIcon(getClass().getResource("./images/users-alt.png"));
        Image imageDimension1 = imageIcon1.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH);
        ImageIcon adjustedImageIcon1 = new ImageIcon(imageDimension1);
        JLabel imageLabel1 = new JLabel(adjustedImageIcon1);
        imageLabel1.setBounds(600, 60, 45, 45);
        JButton buttonEdit = new JButton("Editar");
        buttonEdit.setFont(new Font("Arial", Font.PLAIN, 13));
        buttonEdit.setBounds(585, 110, 80, 20);

        // Imagen y botón de eliminar 
        ImageIcon imageIcon2 = new ImageIcon(getClass().getResource("./images/cross.png"));
        Image imageDimension2 = imageIcon2.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH);
        ImageIcon adjustedImageIcon2 = new ImageIcon(imageDimension2);
        JLabel imageLabel2 = new JLabel(adjustedImageIcon2);
        imageLabel2.setBounds(700, 60, 45, 45);
        JButton buttonDelete = new JButton("Eliminar");
        buttonDelete.setFont(new Font("Arial", Font.PLAIN, 12));
        buttonDelete.setBounds(685, 110, 80, 20);

        // Agregar imágenes y botones al panel
        panel.add(imageLabel);
        panel.add(imageLabel1);
        panel.add(imageLabel2);
        panel.add(buttonAdd);
        panel.add(buttonEdit);
        panel.add(buttonDelete);
    }

    // Método para actualizar la gráfica de especialidades
    private void updateEspecialidadesChart(JPanel panel) {
        panel.removeAll();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Agregar los valores de especialidades al conjunto de datos
        for (String especialidad : especialidades) {
            int count = Collections.frequency(especialidades, especialidad);
            dataset.addValue(count, especialidad, especialidad);
        }

        // Crear la gráfica de barras
        JFreeChart chart = ChartFactory.createBarChart(
                "Especialidades", // Título de la gráfica
                "Especialidades", // Etiqueta del eje X
                "Cantidad",       // Etiqueta del eje Y
                dataset,         // Conjunto de datos
                PlotOrientation.VERTICAL,
                true, true, false
        );

        // Crear un panel para mostrar la gráfica
        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel);
        chartPanel.setPreferredSize(new Dimension(230, 150));
        panel.revalidate();
        panel.repaint();
    }

    // Método para crear un panel con degradado
    private JPanel createGradientPanel() {
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

    // Método para crear un botón de salida
    private JButton createExitButton() {
        JButton exitButton = new JButton("Salir");
        exitButton.setBounds(10, 10, 60, 20);
        exitButton.setFont(new Font("Arial", Font.PLAIN, 9));
        exitButton.addActionListener((var e) -> {
            Login login = new Login();
            login.setVisible(true);
            dispose();
        });
        return exitButton;
    }

    // Método para crear y llenar la tabla de doctores
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
            model.addRow(new Object[]{codigos.get(i), doctorName.get(i), doctorLast.get(i), especialidades.get(i), genero.get(i), doctorEdad.get(i)});
        }
        return new JTable(model);
    }

    // Método para crear y llenar la tabla de pacientes
    private JTable createPacientesTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Codigo");
        model.addColumn("Nombre");
        model.addColumn("Apellidos");
        model.addColumn("Genero");
        model.addColumn("Edad");

        // Agregar los datos de los pacientes al modelo de la tabla
        for (int i = 0; i < patientCode.size(); i++) {
            model.addRow(new Object[]{patientCode.get(i), patientName.get(i), patientLast.get(i), generoPaciente.get(i), edadPaciente.get(i)});
        }
        return new JTable(model);
    }

    // Método para agregar datos por defecto a la lista de doctores
    public void DoctoresDefault() {
        // Agregar doctores por defecto
        codigos.add(202200001);
        doctorName.add("Ricardo");
        doctorLast.add("Milos");
        genero.add("Masculino");
        doctorEdad.add(30);
        passwordArray.add("doctor");
        especialidades.add("Cardiologo");
        
        codigos.add(202200002);
        doctorName.add("Michelle");
        doctorLast.add("Garcia");
        genero.add("Femenino");
        doctorEdad.add(30);
        passwordArray.add("doctor");
        especialidades.add("Pediatra");
        
        codigos.add(202200003);
        doctorName.add("Emanuel");
        doctorLast.add("Garcia");
        genero.add("Masculino");
        doctorEdad.add(30);
        passwordArray.add("doctor");
        especialidades.add("Pediatra");
        
        codigos.add(202200004);
        doctorName.add("Brayan");
        doctorLast.add("Garcia");
        genero.add("Masculino");
        doctorEdad.add(30);
        passwordArray.add("doctor");
        especialidades.add("Dermatologo");
        
        codigos.add(202200005);
        doctorName.add("Ricardo");
        doctorLast.add("Alcaraz");
        genero.add("Masculino");
        doctorEdad.add(30);
        passwordArray.add("doctor");
        especialidades.add("Cardiologo");
        
        codigos.add(202200006);
        doctorName.add("testUser");
        doctorLast.add("test");
        genero.add("Femenino");
        doctorEdad.add(30);
        passwordArray.add("doctor");
        especialidades.add("Cardiologo");

    }

    // Método para agregar datos por defecto a la lista de pacientes
    public void patientDefault() {
        // Agregar pacientes por defecto
        patientCode.add(202300001);
        patientName.add("Ricardo");
        patientLast.add("Milos");
        generoPaciente.add("Masculino");
        edadPaciente.add(30);
        passwordArray.add("doctor");

        patientCode.add(202300002);
        patientName.add("Michelle");
        patientLast.add("Garcia");
        generoPaciente.add("Femenino");
        edadPaciente.add(30);
        passwordPatientArray.add("doctor");
        
        
        patientCode.add(202300003);
        patientName.add("Emanuel");
        patientLast.add("Garcia");
        generoPaciente.add("Masculino");
        edadPaciente.add(30);
        passwordPatientArray.add("doctor");
        
        
        patientCode.add(202300004);
        patientName.add("Brayan");
        patientLast.add("Garcia");
        generoPaciente.add("Masculino");
        edadPaciente.add(30);
        passwordPatientArray.add("doctor");
        
        
        patientCode.add(202300005);
        patientName.add("Ricardo");
        patientLast.add("Alcaraz");
        generoPaciente.add("Masculino");
        edadPaciente.add(30);
        passwordPatientArray.add("doctor");
        
        patientCode.add(202300006);
        patientName.add("testUser");
        patientLast.add("test");
        generoPaciente.add("Femenino");
        edadPaciente.add(30);
        passwordPatientArray.add("doctor");
    }
}
