/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import domain.HeavyMachinary;
import domain.Vehicle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import jdk.nashorn.internal.ir.BreakNode;

/**
 *
 * @author brend
 */
public class MainWindow extends JFrame implements ActionListener {

    public static Vehicle[] vectorVehicle = new Vehicle[30];

    public static JDesktopPane desktopPane;

    JMenuBar jMenuBar;
    JMenu jMenu;
    JMenuItem jMenuItem1;

    private JLabel jlbBackGround;

    public static InternalFrameHireEmployee hireEmployee;

    public MainWindow() {
        super("Empleados");
        ImageIcon image = new ImageIcon("./MyImages/Logo.png");
        jlbBackGround = new JLabel();
        this.desktopPane = new JDesktopPane();
        this.desktopPane.setLayout(null);
        jlbBackGround.setBounds(0,0,800,400);
        jlbBackGround.setIcon(image);
        this.desktopPane.add(jlbBackGround);
        this.setResizable(false);

        this.jMenuBar = new JMenuBar();
        this.jMenu = new JMenu("Menu");
        this.jMenuItem1 = new JMenuItem("Registrar Empleado");

        init();

        this.add(desktopPane);

    }//constructor

    private void init() {
        //empleados quemados para efectos de pruebas

        HeavyMachinary heavyMachinary0 = new HeavyMachinary(1, "Vagoneta", "Chevrolet", 99, 554, "Amarillo");
        HeavyMachinary heavyMachinary1 = new HeavyMachinary(2, "Grua", "Yamaha", 2010, 3567, "Rojo");
        HeavyMachinary heavyMachinary2 = new HeavyMachinary(3, "Montacargas", "Toyota", 1997, 4325, "Azul");
        vectorVehicle[0] = heavyMachinary0;
        vectorVehicle[1] = heavyMachinary1;
        vectorVehicle[2] = heavyMachinary2;

        this.setSize(790, 461);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

        this.jMenuBar.add(this.jMenu);
        this.jMenu.add(this.jMenuItem1);

        this.jMenuItem1.addActionListener(this);

        this.setJMenuBar(this.jMenuBar);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.jMenuItem1) {
            try {
                this.hireEmployee = new InternalFrameHireEmployee();
            } catch (IOException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.hireEmployee.setVisible(true);
            this.hireEmployee.setSize(780, 400);
            this.hireEmployee.setClosable(true);

            this.desktopPane.add(this.hireEmployee);

        }

    }

}
