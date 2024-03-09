package ipc1.proyecto1;

import ipc1.proyecto1.Usuarios.Persona;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;



public class Admin extends JFrame {
ArrayList<Persona> personas = Usuarios.getPersonas();
ArrayList<Persona> doctores = Usuarios.getDoctores();
ArrayList<Persona> pacientes = Usuarios.getPacientes();    
   
     
    public Admin() {
        
        setIconImage(new ImageIcon(getClass().getResource("./images/equipo-medico.png")).getImage());
         
    // Luego, en el lugar donde necesitas comprobar y cargar los datos:
    if (personas.isEmpty() && doctores.isEmpty() && pacientes.isEmpty()) {
            
        }
            for (Persona persona : personas) {
            
            if (persona.getEspecialidad() != null) {
                // Si la persona tiene una especialidad, se considera un doctor
                doctores.add(persona);
            } else {
                // Si no tiene especialidad, se considera un paciente
                pacientes.add(persona);
            }
        }
        System.out.println("Numero de usuarios : "  + personas.size());
        setResizable(false);
        setLocationRelativeTo(this);
        setTitle("ADMIN");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Crear un JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Agregar pestañas
        tabbedPane.addTab("DOCTORES", createPanel(true, false));
        tabbedPane.addTab("PACIENTES", createPanel(false, false));
        tabbedPane.addTab("FARMACIA", createPanel(false, true));

        // Agregar el JTabbedPane al JFrame
        add(tabbedPane);

        setVisible(true);
    }

    // Método para crear un botón
    private JButton createButton(String text, int x, int y, int width, int height, int fontSize) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setFont(new Font("Arial", Font.PLAIN, fontSize));
        return button;
    }

    // Método para inicializar los datos
//    private void initData() {
//        // Agregar doctores por defecto
//        if (personas.isEmpty()){
//            System.out.println("Entra a esta matriz");
//        personas.add(new Persona(202200001, "Ricardo", "Milos", "Masculino", 30, "Cardiologo", "12345", 23452345));
//        personas.add(new Persona(202200002, "Michelle", "Garcia", "Femenino", 30, "Pediatra", "12345", 23455432));
//        personas.add(new Persona(202200003, "Emanuel", "Garcia", "Masculino", 30, "Pediatra", "12345", 23455432));
//        personas.add(new Persona(202200004, "Brayan", "Garcia", "Masculino", 30, "Dermatologo", "12345", 23455432));
//        personas.add(new Persona(202200005, "Ricardo", "Alcaraz", "Masculino", 30, "Cardiologo", "12345", 12344321));
//        personas.add(new Persona(202200006, "testUser", "test", "Femenino", 30, "Cardiologo", "12345", 12344321));
//
//        // Agregar pacientes por defecto
//        personas.add(new Persona(202300001, "Ricardo", "Milos", "Masculino", 30, null, "asdfg", 12344312));
//        personas.add(new Persona(202300002, "Michelle", "Garcia", "Femenino", 20, null, "12345", 12344321));
//        personas.add(new Persona(202300003, "Emanuel", "Garcia", "Masculino", 10, null, "12345", 12344312));
//        personas.add(new Persona(202300004, "Brayan", "Garcia", "Masculino", 30, null, "12345", 43212343));
//        personas.add(new Persona(202300005, "Ricardo", "Alcaraz", "Masculino", 40, null, "12345", 12344321));
//        
//        }
//    }

    // Método para crear y llenar la tabla de doctores o pacientes
    // Método para crear el panel de doctores, pacientes o farmacia
private JPanel createPanel(boolean isDoctor, boolean isFarmacia) {
    System.out.println("CreandoPanel");
    JPanel adminPanel = createGradientPanel();
    adminPanel.setLayout(null);
    setupImagesAndButtons(adminPanel);
    this.setLocationRelativeTo(null);
    // Crear y agregar la tabla al panel
    

    // Si es panel de doctores, mostrar la gráfica de especialidades
    if (isDoctor) {
        JTable table = createTable(isDoctor, isFarmacia);
        System.out.println("CreandoTablaDoctor");
        JPanel tablaPanel = new JPanel();
        tablaPanel.setSize(470, 430);
        tablaPanel.setLocation(10, 50);
        tablaPanel.add(new JScrollPane(table));
        adminPanel.add(tablaPanel);
        JPanel graficaEspecialidades = createGradientPanel();
        graficaEspecialidades.setBounds(490, 250, 270, 180);
        
        adminPanel.add(graficaEspecialidades);
        JLabel tituloPanelGrafica = new JLabel("Gráfica de especialidades");
        tituloPanelGrafica.setBounds(543, 230, 200, 20);
        tituloPanelGrafica.setFont(new Font("Arial", Font.PLAIN, 15));
        adminPanel.add(tituloPanelGrafica);
        updateEspecialidadesChart(graficaEspecialidades);
    } else if (isFarmacia) {
        // Si es panel de farmacia, aquí puedes agregar lógica específica para la farmacia
        // Por ejemplo, puedes agregar botones para gestionar el inventario de la farmacia
        // También puedes agregar gráficas o cualquier otro componente que necesites
    } else {
        JTable table = createTable(isDoctor, isFarmacia);
        System.out.println("CreandoTablaPaciente");
        JPanel tablaPanel = new JPanel();
        tablaPanel.setSize(450, 430);
        tablaPanel.setLocation(30, 50);
        tablaPanel.add(new JScrollPane(table));
        adminPanel.add(tablaPanel);
        JPanel graficaPacientes = createGradientPanel();
        graficaPacientes.setBounds(490, 250, 270, 180);
        adminPanel.add(graficaPacientes);
        JLabel tituloPanelGrafica = new JLabel("Grafica de Pacientes");
        tituloPanelGrafica.setBounds(543, 230, 200, 20);
        tituloPanelGrafica.setFont(new Font("Arial", Font.PLAIN, 15));
        adminPanel.add(tituloPanelGrafica);
        updateEdadesPacientesChart(graficaPacientes);
    }

    // Agregar el botón "Salir" al panel
    JButton exitButton = createButton("Salir", 10, 10, 60, 20, 9);
    exitButton.addActionListener((var e) -> {
        
        this.dispose();
        Login login = new Login();
        login.setVisible(true);
        
    });
    adminPanel.add(exitButton);
    return adminPanel;
}

private JTable createTable(boolean isDoctor, boolean isFarmacia) {
    DefaultTableModel model = new DefaultTableModel();
    model.setRowCount(0);
    model.addColumn("Codigo");
    if (isDoctor || !isFarmacia){
    model.addColumn("Nombre");
    model.addColumn("Apellidos");
    }
    
    
    if (isDoctor) {
        model.addColumn("Especialidad");
    }
    if (isDoctor || !isFarmacia){
    model.addColumn("Genero");
    model.addColumn("Edad");
    model.addColumn("Telefono");
    }
    
    
    if (isDoctor && !isFarmacia) {
//        model.setRowCount(0); // Esto limpia las filas existentes

        for (Persona doctor : Usuarios.getDoctores()) {
            model.addRow(new Object[]{
                
                doctor.getCodigo(),
                doctor.getNombre(),
                doctor.getApellido(),
                doctor.getEspecialidad(),
                doctor.getGenero(),
                doctor.getEdad(),
                doctor.getTelefono()
            });System.out.println("CreandoFila");
        }
    } 
    else if (!isDoctor && isFarmacia) {
        
       
    } 
    if(!isDoctor && !isFarmacia) {
//        model.setRowCount(0); // Esto limpia las filas existentes;

        for (Persona paciente : Usuarios.getPacientes()) {
            Object[] rowData = new Object[]{
                paciente.getCodigo(),
                paciente.getNombre(),
                paciente.getApellido(),
                paciente.getGenero(),
                paciente.getEdad(),
                paciente.getTelefono()
            };
            System.out.println("CreandoFilaPaciente");
            model.addRow(rowData);
        }
    }
    
    return new JTable(model);
}


    
     // Método para agregar imágenes y botones a un panel
    private void setupImagesAndButtons(JPanel panel) {
            // Imagen y botón de agregar médicos
            ImageIcon imageIcon = new ImageIcon(getClass().getResource("./images/agregar.png"));
            Image imageDimension = imageIcon.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH);
            ImageIcon adjustedImageIcon = new ImageIcon(imageDimension);
            JLabel imageLabel = new JLabel(adjustedImageIcon);
            imageLabel.setBounds(510, 60, 45, 45);
            JButton buttonAdd = new JButton("Agregar");
            buttonAdd.setFont(new Font("Arial", Font.PLAIN, 13));
            buttonAdd.setBounds(490, 110, 80, 20);
            buttonAdd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                    Registros registros = new Registros();
                    registros.agregarPersona(true, false);
                    
                    
                    }
                    });

                    
        // Imagen y botón de Editar usuario
        ImageIcon imageIcon1 = new ImageIcon(getClass().getResource("./images/firma.png"));
        Image imageDimension1 = imageIcon1.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH);
        ImageIcon adjustedImageIcon1 = new ImageIcon(imageDimension1);
        JLabel imageLabel1 = new JLabel(adjustedImageIcon1);
        imageLabel1.setBounds(600, 60, 45, 45);
        JButton buttonEdit = new JButton("Editar");
        buttonEdit.setFont(new Font("Arial", Font.PLAIN, 13));
        buttonEdit.setBounds(585, 110, 80, 20);

        // Imagen y botón de eliminar 
        ImageIcon imageIcon2 = new ImageIcon(getClass().getResource("./images/cancelar.png"));
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
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    // Contar la cantidad de cada especialidad
    Map<String, Integer> especialidadesCount = new HashMap<>();
    for (Persona doctor : doctores) {
        String especialidad = doctor.getEspecialidad();
        if (especialidad != null) {
            especialidadesCount.put(especialidad, especialidadesCount.getOrDefault(especialidad, 0) + 1);
        }
    }

    // Agregar los datos al dataset
    for (Map.Entry<String, Integer> entry : especialidadesCount.entrySet()) {
        dataset.addValue(entry.getValue(), entry.getKey(), entry.getKey());
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
    panel.removeAll();
    panel.add(chartPanel);
    chartPanel.setPreferredSize(new Dimension(230, 150));
    panel.revalidate();
    panel.repaint();
}
 

// Método para actualizar la gráfica de edades de pacientes
private void updateEdadesPacientesChart(JPanel panel) {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    // Contar la cantidad de pacientes por edad
    Map<Integer, Integer> edadesCount = new HashMap<>();
    for (Persona paciente : pacientes) {
        int edad = paciente.getEdad();
        edadesCount.put(edad, edadesCount.getOrDefault(edad, 0) + 1);
    }

    // Agregar los datos al dataset
    for (Map.Entry<Integer, Integer> entry : edadesCount.entrySet()) {
        dataset.addValue(entry.getValue(), "Pacientes", String.valueOf(entry.getKey()));
    }

    // Crear la gráfica de barras
    JFreeChart chart = ChartFactory.createBarChart(
            "Edades de Pacientes", // Título de la gráfica
            "Edades",              // Etiqueta del eje X
            "Cantidad",            // Etiqueta del eje Y
            dataset,               // Conjunto de datos
            PlotOrientation.VERTICAL,
            true, true, false
    );

    // Crear un panel para mostrar la gráfica
    ChartPanel chartPanel = new ChartPanel(chart);
    panel.removeAll();
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
                Color colorFin = new Color(0X71EEEF);
                GradientPaint gradient = new GradientPaint(0, 0, colorInicio, getWidth(), getHeight(), colorFin);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        return panel;
    }
}