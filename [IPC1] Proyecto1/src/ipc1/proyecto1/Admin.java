import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JFrame {
    JLabel adminText = new JLabel("Pestana de administracion");

    public Admin() {
        initializeUi();
        setupLayout();
        components();
    }

    JPanel adminPanel = new JPanel() {
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

    private void setupLayout() {
        adminPanel.setLayout(null);
    }

    private void components() {
        adminText.setBounds(100, 100, 50, 50);
        adminText.setFont(new Font("Arial", Font.PLAIN, 9));
        adminText.setVisible(true);
        adminPanel.add(adminText);

        JButton updateDoctorButton = new JButton("Actualizar Doctor");
        updateDoctorButton.setBounds(50, 200, 150, 30);
        updateDoctorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String doctorCode = JOptionPane.showInputDialog(null, "Ingrese el código del doctor a actualizar:");
                if (doctorCode != null && !doctorCode.isEmpty()) {
                    // Aquí deberías validar si el doctor existe en tu sistema
                    boolean doctorExists = validarExistenciaDoctor(doctorCode);
                    if (doctorExists) {
                        actualizarDoctor(doctorCode); // Método para abrir la ventana de actualización
                    } else {
                        JOptionPane.showMessageDialog(null, "El doctor con código " + doctorCode + " no existe.");
                    }
                }
            }
        });
        adminPanel.add(updateDoctorButton);

        JButton deleteDoctorButton = new JButton("Eliminar Doctor");
        deleteDoctorButton.setBounds(250, 200, 150, 30);
        deleteDoctorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String doctorCode = JOptionPane.showInputDialog(null, "Ingrese el código del doctor a eliminar:");
                if (doctorCode != null && !doctorCode.isEmpty()) {
                    // Aquí deberías validar si el doctor existe en tu sistema
                    boolean doctorExists = validarExistenciaDoctor(doctorCode);
                    if (doctorExists) {
                        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar al doctor con código " + doctorCode + "?");
                        if (confirmacion == JOptionPane.YES_OPTION) {
                            eliminarDoctor(doctorCode); // Método para eliminar el doctor
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El doctor con código " + doctorCode + " no existe.");
                    }
                }
            }
        });
        adminPanel.add(deleteDoctorButton);
    }

    private void initializeUi() {
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Admin");
    }

    private boolean validarExistenciaDoctor(String doctorCode) {
        // Implementa la lógica para validar si el doctor existe en tu sistema
        return true; // Ejemplo: siempre retorna true
    }

    private void actualizarDoctor(String doctorCode) {
        // Implementa la lógica para abrir la ventana de actualización del doctor
        // Debes crear una nueva ventana (JDialog) para permitir al usuario actualizar los datos del doctor
    }

    private void eliminarDoctor(String doctorCode) {
        // Implementa la lógica para eliminar el doctor de tu sistema
    }
}