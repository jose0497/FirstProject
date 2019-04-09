package GUI;

import File.EmployeeManySerializables;
import com.mxrck.autocompleter.TextAutoCompleter;
import domain.Employee;
import domain.Vehicle;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author brend
 */
public class InternalFrameSearchEmployee extends JInternalFrame implements ActionListener {

    private JButton jbtnReturn;
    private JInternalFrame updateInternal;
    private JButton jbtnCancel;
    private JButton jbtnUpdate;
    private JButton jbtnRemove;
    JDesktopPane ventana1;
    private JButton jbtnSearch;
    private JTextArea jtaShow;
    private JLabel jlblName;
    private JLabel jlblTypeOfEmployee;
    private JTextField jtfName;
    private JComboBox jcTypeOfEmployee;
    private TextAutoCompleter autoCompleter;
    private EmployeeManySerializables employeeManySerializables;
    

    public InternalFrameSearchEmployee() throws IOException, FileNotFoundException, ClassNotFoundException {
        super("Buscar");
        this.setBackground(Color.lightGray);
        ventana1 = new JDesktopPane();
        employeeManySerializables = new EmployeeManySerializables();
        this.setLayout(null);
        this.jlblTypeOfEmployee = new JLabel("Empleado");
        this.jlblTypeOfEmployee.setBounds(250, 30, 150, 20);
        this.add(this.jlblTypeOfEmployee);
        this.jcTypeOfEmployee = new JComboBox();
        this.jcTypeOfEmployee.addItem("-Seleccionar-");
        this.jcTypeOfEmployee.addItem("Conserje");
        this.jcTypeOfEmployee.addItem("Administrativo");
        this.jcTypeOfEmployee.addItem("Conductor Carro");
        this.jcTypeOfEmployee.addItem("Conductor Maquinaria");
        this.jcTypeOfEmployee.addItem("Por nombre");

        this.ventana1.setBounds(20, 50, 300, 300);
        this.updateInternal = new JInternalFrame("Update");
        this.updateInternal.setBounds(20, 50, 400, 400);
        //this.ventana1.add(updateInternal);
        this.updateInternal.add(this.ventana1);
        this.jbtnCancel = new JButton("Cancelar");
        this.jbtnCancel.setBounds(300, 400, 50, 30);
        this.ventana1.add(this.jbtnCancel);
        this.jbtnCancel.addActionListener(this);

        //this.pack();
        //this.updateInternal.pack();
        JDesktopPane ventana1 = new JDesktopPane();
        this.add(ventana1);
        JInternalFrame ventana1a = new JInternalFrame("Ventana interfaz 1");
        ventana1a.setBounds(5, 5, 300, 300);
        ventana1a.setVisible(true);
        ventana1.add(ventana1a);

        this.jcTypeOfEmployee.setBounds(325, 30, 150, 20);
        this.add(this.jcTypeOfEmployee);
        this.jlblName = new JLabel("Nombre:");
        this.jlblName.setBounds(10, 30, 100, 20);
        this.add(this.jlblName);

        this.jtfName = new JTextField();
        this.jtfName.setBounds(70, 30, 150, 20);
        this.add(this.jtfName);
        this.jbtnRemove = new JButton("Eliminar");
        this.jbtnRemove.setBounds(650, 170, 100, 30);
        this.add(this.jbtnRemove);
        this.jbtnRemove.addActionListener(this);

        this.autoCompleter = new TextAutoCompleter(jtfName);

        this.jbtnReturn = new JButton("Regresar");
        this.jbtnUpdate = new JButton("Actualizar");
        this.jbtnSearch = new JButton("Buscar");
        this.jtaShow = new JTextArea();

        this.jtaShow.setBounds(70, 60, 406, 250);
        JScrollPane scrollPane = new JScrollPane(jtaShow);
        scrollPane.setBounds(70, 60, 406, 250);
        this.add(scrollPane);

        this.jbtnReturn.setBounds(650, 320, 100, 30);
        this.add(this.jbtnReturn);
        this.jbtnReturn.addActionListener(this);

        this.jbtnUpdate.setBounds(650, 120, 100, 30);
        this.add(this.jbtnUpdate);
        this.jbtnUpdate.addActionListener(this);
        this.jbtnSearch.setBounds(650, 220, 100, 30);
        this.add(this.jbtnSearch);
        this.jbtnSearch.addActionListener(this);
        this.jtaShow.setEditable(false);
        
        this.jcTypeOfEmployee.addActionListener((ae) -> {
            if (jcTypeOfEmployee.getSelectedItem().equals("-Seleccionar-")) {
                jtaShow.setText("");
            }
            if (jcTypeOfEmployee.getSelectedItem().equals("Conductor Maquinaria")) {
                jtaShow.setText("");
                autoCompleter.removeAllItems();
                try {
                    if (!employeeManySerializables.getDriverHeavyMachinary().isEmpty()) {
                        String information = "";
                        for (int i = 0; i < employeeManySerializables.getDriverHeavyMachinary().size(); i++) {
                            information += employeeManySerializables.getDriverHeavyMachinary().get(i).toString() + "\n";
                        }
                        this.jtaShow.setText(information);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(InternalFrameSearchEmployee.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(InternalFrameSearchEmployee.class.getName()).log(Level.SEVERE, null, ex);
                }

            }//maquinaria

            if (jcTypeOfEmployee.getSelectedItem().equals("Conserje")) {
                jtaShow.setText("");
                autoCompleter.removeAllItems();
                try {
                    if (!employeeManySerializables.getConcierge().isEmpty()) {
                        String information = "";
                        for (int i = 0; i < employeeManySerializables.getConcierge().size(); i++) {
                            information += employeeManySerializables.getConcierge().get(i).toString() + "\n";
                        }
                        this.jtaShow.setText(information);
                    }

                } catch (IOException ex) {
                    Logger.getLogger(InternalFrameSearchEmployee.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(InternalFrameSearchEmployee.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (jcTypeOfEmployee.getSelectedItem().equals("Administrativo")) {
                jtaShow.setText("");
                autoCompleter.removeAllItems();
                try {
                    if (!employeeManySerializables.getAdministrative().isEmpty()) {
                        String information = "";
                        for (int i = 0; i < employeeManySerializables.getAdministrative().size(); i++) {
                            information += employeeManySerializables.getAdministrative().get(i).toString() + "\n";
                        }
                        this.jtaShow.setText(information);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(InternalFrameSearchEmployee.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(InternalFrameSearchEmployee.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (jcTypeOfEmployee.getSelectedItem().equals("Conductor Carro")) {
                jtaShow.setText("");
                autoCompleter.removeAllItems();
                try {
                    if (!employeeManySerializables.getDriverCar().isEmpty()) {
                        String information = "";
                        for (int i = 0; i < employeeManySerializables.getDriverCar().size(); i++) {
                            information += employeeManySerializables.getDriverCar().get(i).toString() + "\n";
                        }
                        this.jtaShow.setText(information);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(InternalFrameSearchEmployee.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(InternalFrameSearchEmployee.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (jcTypeOfEmployee.getSelectedItem().equals("Por nombre")) {
                jtaShow.setText("");
                try {
                    fillAutoCompleter();
                } catch (IOException ex) {
                    Logger.getLogger(InternalFrameSearchEmployee.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(InternalFrameSearchEmployee.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.jbtnReturn) {
            this.dispose();
            MainWindow.hireEmployee.setVisible(true);
        }//if
//        if (e.getSource() == this.jbtnUpdate) {
//
//        }
//        if (e.getSource() == this.jbtnRemove) {
//
//        }
        if (e.getSource() == this.jbtnSearch) {
            this.jtaShow.setText("");

            Vehicle vehicle = new Vehicle() {
                @Override
                public boolean insertVehicle(Vehicle vehicle) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            //las siguientes lineas de codigo solo llaman a los metodos seeX 
            //dependiendo de lo que se escoja

            if (this.jcTypeOfEmployee.getSelectedItem().toString().equalsIgnoreCase("Por nombre")) {
                try {
                    boolean flag = false;
                    if (!employeeManySerializables.getAll().isEmpty()) {
                        String information = "";

                        for (int i = 0; i < employeeManySerializables.getAll().size(); i++) {
                            if (employeeManySerializables.getAll().get(i).getName().equalsIgnoreCase(jtfName.getText())) {
                                information += employeeManySerializables.getAll().get(i).toString() + "\n";
                                flag = true;
                            }
                        }
                        this.jtaShow.setText(information);
                        if (flag == false) {
                            JOptionPane.showMessageDialog(null, "No existe el empleado");

                        }
                    }

                } catch (IOException ex) {
                    Logger.getLogger(InternalFrameSearchEmployee.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(InternalFrameSearchEmployee.class.getName()).log(Level.SEVERE, null, ex);
                }
            }//if
        }
        if (e.getSource() == this.jbtnRemove) {
            try {

                int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la identificación del empleado"));
                if (employeeManySerializables.existEmployee(id)) {
                    employeeManySerializables.removeEmployee(id);
                    JOptionPane.showMessageDialog(null, "Se borro el empleado");
                }

            } catch (IOException ex) {
                Logger.getLogger(InternalFrameSearchEmployee.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(InternalFrameSearchEmployee.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception err) {

            }
            //this.dispose();
        }
        if (e.getSource() == this.jbtnUpdate) {
            try {
                int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la identificación del empleado"));
                if (employeeManySerializables.existEmployee(id)) {
                    Employee employee = employeeManySerializables.getEmployee(id);
                    UpdateEmployeeWindow updateEmployeeWindow = new UpdateEmployeeWindow(employee);
                    updateEmployeeWindow.setVisible(true);
                }
            } catch (IOException ex) {
                Logger.getLogger(InternalFrameSearchEmployee.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(InternalFrameSearchEmployee.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception err) {

            }

        }

    }//actionPerformed

    public void fillAutoCompleter() throws IOException, FileNotFoundException, ClassNotFoundException {

        employeeManySerializables = new EmployeeManySerializables();

        if (jcTypeOfEmployee.getSelectedItem().equals("Por nombre")) {
            autoCompleter.removeAllItems();
            for (int i = 0; i < employeeManySerializables.getAll().size(); i++) {
                if (!employeeManySerializables.getAll().isEmpty()) {
                    autoCompleter.addItem(employeeManySerializables.getAll().get(i).getName());
                }
            }
        }//if

    }//fill

}
