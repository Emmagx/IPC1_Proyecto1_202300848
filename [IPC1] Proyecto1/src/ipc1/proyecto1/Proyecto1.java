package ipc1.proyecto1;

import javax.swing.*;
import java.awt.*;
public class Proyecto1 extends JFrame {
    public static int contadorMedicos = 6;
    public static int contadorPacientes = 6;
    public static int codigosFarmacia = 0;
    static Login login = new Login();
    
//    static Admin admin = new Admin();
    public static void main(String[] args) {
        
        login.setVisible(true);
//        admin.setVisible(true);
    }
}
