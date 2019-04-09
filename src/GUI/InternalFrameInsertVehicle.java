package GUI;

import File.VehicleFile;
import domain.Car;
import domain.HeavyMachinary;
import domain.Vehicle;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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
public class InternalFrameInsertVehicle extends JInternalFrame implements ActionListener {

    JLabel jlblLicensePlate, jlblTypeOfDriver, jlblTypeOfMachinary, jlblBrand, jlblColor, jlblMileage, jlblYear, jlSeries, jlAmerican;

    public static JTextField jtfLicensePlate;
    public static JComboBox jcTypeOfVehicle;
    public static JComboBox jcTypeOfMachinary;
    public static JTextField jtfBrand;
    public static JTextField jtfColor;
    public static JTextField jtfMileage;
    public static JTextField jtfModel;
    public static JTextField jtfSeries;
    public static JCheckBox jchAmerican;
    VehicleFile vehicleFile;
    private JTextArea jtaInformationCar;
    private JScrollPane scrollPane;

    private JButton jbtnReturn;
    private JButton jbtnInsertVehicle;
    private JButton jbtnRemove;
    private JButton jbtnSearch;
    private JButton jbtnUpdate;
    private JButton jbtnSeeAll;

    public InternalFrameInsertVehicle() throws IOException {

        super("Insertar Vehiculos");
        vehicleFile = new VehicleFile(new File("./MyFile/Automoviles"));
        this.setLayout(null);
        this.setBackground(Color.lightGray);

        this.jlblLicensePlate = new JLabel("N.Placa");

        this.jlblColor = new JLabel("Color");
        this.jlAmerican = new JLabel("Americano");
        this.jlSeries = new JLabel("Serie");
        this.jlblTypeOfDriver = new JLabel("T.Vehicle");
        this.jlblTypeOfMachinary = new JLabel("Maquinaria");
        this.jlblBrand = new JLabel("Marca");
        this.jlblMileage = new JLabel("Kilometraje");
        this.jlblYear = new JLabel("Año");

        this.jtfBrand = new JTextField();
        this.jtfLicensePlate = new JTextField();
        this.jtfMileage = new JTextField();
        this.jtfColor = new JTextField();
        this.jtfModel = new JTextField();
        this.jtfSeries = new JTextField();
        this.jtaInformationCar = new JTextArea();

        //JComboBox
        this.jcTypeOfMachinary = new JComboBox();
        this.jcTypeOfVehicle = new JComboBox();

        this.jchAmerican = new JCheckBox();

        //
        this.jbtnReturn = new JButton("Regresar");
        this.jbtnInsertVehicle = new JButton("Registrar");
        this.jbtnRemove = new JButton("Eliminar");
        this.jbtnSearch = new JButton("Buscar");
        this.jbtnSeeAll = new JButton("Ver todos");
        this.jbtnUpdate = new JButton("Actualizar");

        init();
    }

    public void init() {

        this.jcTypeOfVehicle.addItem("Automovil");
        this.jcTypeOfVehicle.addItem("Maquinaria Pesada");

        this.jcTypeOfMachinary.addItem("Vagoneta");
        this.jcTypeOfMachinary.addItem("Grua");
        this.jcTypeOfMachinary.addItem("Montacargas");

        this.jtfMileage.setBounds(360, 30, 150, 20);
        this.add(this.jtfMileage);

        this.jtfSeries.setBounds(360, 100, 150, 20);
        this.add(jtfSeries);

        this.jchAmerican.setBounds(360, 170, 150, 20);
        this.add(jchAmerican);

        this.jtaInformationCar.setBounds(300, 200, 300, 150);
        this.jtaInformationCar.setEditable(false);
        scrollPane = new JScrollPane(this.jtaInformationCar);
        scrollPane.setBounds(300, 200, 300, 150);
        this.add(scrollPane);

        this.jtfModel.setBounds(110, 100, 150, 20);
        this.add(this.jtfModel);

        //llllllllllllllllllllllllllllllllllllll
        this.jtfLicensePlate.setBounds(110, 30, 150, 20);
        this.add(jtfLicensePlate);

        this.jcTypeOfVehicle.setBounds(110, 240, 150, 20);
        this.add(this.jcTypeOfVehicle);

        this.jtfColor.setBounds(110, 310, 150, 20);
        this.add(this.jtfColor);

        this.jtfBrand.setBounds(110, 170, 150, 20);
        this.add(this.jtfBrand);

        this.jcTypeOfMachinary.setBounds(360, 30, 150, 20);
        this.add(this.jcTypeOfMachinary);

        //llllllllllllllllllllllllllllllllllllll
        this.jlblMileage.setBounds(280, 30, 100, 20);
        this.add(this.jlblMileage);

        this.jlSeries.setBounds(280, 100, 100, 20);
        this.add(this.jlSeries);

        this.jlAmerican.setBounds(280, 170, 100, 20);
        this.add(this.jlAmerican);

        this.jlblYear.setBounds(10, 100, 100, 20);
        this.add(this.jlblYear);

        this.jlblLicensePlate.setBounds(10, 30, 100, 20);
        this.add(this.jlblLicensePlate);

        this.jlblBrand.setBounds(10, 170, 100, 20);
        this.add(this.jlblBrand);

        this.jlblTypeOfMachinary.setBounds(280, 30, 100, 20);
        this.add(this.jlblTypeOfMachinary);

        this.jlblTypeOfDriver.setBounds(10, 240, 100, 20);
        this.add(this.jlblTypeOfDriver);

        this.jlblColor.setBounds(10, 310, 100, 20);
        this.add(this.jlblColor);

        this.jbtnReturn.setBounds(650, 320, 100, 30);
        this.add(this.jbtnReturn);
        this.jbtnReturn.addActionListener(this);

        this.jbtnInsertVehicle.setBounds(650, 270, 100, 30);
        this.add(this.jbtnInsertVehicle);
        this.jbtnInsertVehicle.addActionListener(this);

        this.jbtnSearch.setBounds(650, 220, 100, 30);
        this.add(this.jbtnSearch);
        this.jbtnSearch.addActionListener(this);

        this.jbtnRemove.setBounds(650, 170, 100, 30);
        this.add(this.jbtnRemove);
        this.jbtnRemove.addActionListener(this);

        this.jbtnUpdate.setBounds(650, 120, 100, 30);
        this.add(this.jbtnUpdate);
        this.jbtnUpdate.addActionListener(this);

        this.jbtnSeeAll.setBounds(650, 70, 100, 30);
        this.add(this.jbtnSeeAll);
        this.jbtnSeeAll.addActionListener(this);

        this.jcTypeOfVehicle.addActionListener(this);
        this.jcTypeOfMachinary.addActionListener(this);

        this.jcTypeOfMachinary.setVisible(false);
        this.jlblTypeOfMachinary.setVisible(false);
        
        //embellecer la ventana
        
        
        

    }//init()

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.jbtnReturn) {
            try {
                MainWindow.hireEmployee.fillJcCar();
                
               
            } catch (IOException ex) {
                Logger.getLogger(InternalFrameInsertVehicle.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
            MainWindow.hireEmployee.setVisible(true);
        }//contratar

        if (e.getSource() == this.jbtnInsertVehicle) {

            if (!this.jtfBrand.getText().equalsIgnoreCase("") && !this.jtfColor.getText().equalsIgnoreCase("") && !this.jtfLicensePlate.getText().equalsIgnoreCase("") && !this.jtfModel.getText().equalsIgnoreCase("")) {
                if (this.jcTypeOfVehicle.getSelectedItem().toString().equalsIgnoreCase("Automovil")) {
                    Vehicle vehicle = new Car(Integer.parseInt(jtfMileage.getText()), jchAmerican.isSelected(), Integer.parseInt(jtfSeries.getText()), jtfBrand.getText(), Integer.parseInt(jtfModel.getText()), Integer.parseInt(jtfLicensePlate.getText()), jtfColor.getText());
                    try {
                        if (vehicleFile.exist(Integer.parseInt(jtfSeries.getText()))) {
                            JOptionPane.showMessageDialog(null, "Ya existe este automovil");
                        } else {
                            Car car = (Car) vehicle;
                            vehicleFile.addEndRecord(car);
                            jtfBrand.setText("");
                            jtfColor.setText("");
                            jtfLicensePlate.setText("");
                            jtfMileage.setText("");
                            jtfSeries.setText("");
                            jchAmerican.setSelected(false);
                            jtfModel.setText("");
                            JOptionPane.showMessageDialog(null, "Automovil insertado");
                        }//else

                    } catch (IOException ex) {
                        Logger.getLogger(InternalFrameInsertVehicle.class.getName()).log(Level.SEVERE, null, ex);
                    }//catch

                }//if

                if (this.jcTypeOfVehicle.getSelectedItem().toString().equalsIgnoreCase("Maquinaria Pesada")) {

                    if (this.jcTypeOfMachinary.getSelectedItem().toString().equalsIgnoreCase("Vagoneta")) {
                        Vehicle vehicle = new HeavyMachinary(1, "", this.jtfBrand.getText(), Integer.parseInt(this.jtfModel.getText()), Integer.parseInt(this.jtfLicensePlate.getText()), this.jtfColor.getText());
                        vehicle.insertVehicle(vehicle);
                    }//if
                    if (this.jcTypeOfMachinary.getSelectedItem().toString().equalsIgnoreCase("Grua")) {
                        Vehicle vehicle = new HeavyMachinary(2, "", this.jtfBrand.getText(), Integer.parseInt(this.jtfModel.getText()), Integer.parseInt(this.jtfLicensePlate.getText()), this.jtfColor.getText());
                        vehicle.insertVehicle(vehicle);
                    }//if
                    if (this.jcTypeOfMachinary.getSelectedItem().toString().equalsIgnoreCase("Montacargas")) {
                        Vehicle vehicle = new HeavyMachinary(3, "", this.jtfBrand.getText(), Integer.parseInt(this.jtfModel.getText()), Integer.parseInt(this.jtfLicensePlate.getText()), this.jtfColor.getText());
                        vehicle.insertVehicle(vehicle);
                    }//if
                }//if
            } else {
                JOptionPane.showMessageDialog(null, "No se permite espacios en blanco");
            }//else
        }//if

        if (e.getSource() == this.jbtnRemove) {

            try {
                int serie = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserte el numero de serie"));
                if (vehicleFile.exist(serie)) {
                    vehicleFile.deleteRecord(serie);
                    JOptionPane.showMessageDialog(null, "Automovil eliminado");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontro la serie");
                }//else
            } catch (Exception err) {

            }

        }
        if (e.getSource() == this.jbtnSearch) {
            try {
                int serie = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserte el numero de serie"));
                if (vehicleFile.exist(serie)) {
                    this.jtaInformationCar.setText(vehicleFile.getVehicle(vehicleFile.getPosition(serie)).toString());
                    JOptionPane.showMessageDialog(null, "Automovil encontrado");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontro la serie");
                }//else

            } catch (Exception err) {

            }//catch
        }//if
        if (e.getSource() == this.jbtnSeeAll) {
            try {
                ViewAllVehicles view = new ViewAllVehicles(vehicleFile.getAllVehicles());
                view.setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(InternalFrameInsertVehicle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }//if
        if (e.getSource() == this.jbtnUpdate) {
            try {
                int serie = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserte el numero de serie"));
                if (vehicleFile.exist(serie)) {
                    UpdateCarWindow updateWindow= new UpdateCarWindow(vehicleFile.getVehicle(vehicleFile.getPosition(serie)));
                    updateWindow.setVisible(true); 
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontro la serie");
                }//else
            }catch(Exception err){
                
            }
               
            
        }//if
        
        if (this.jcTypeOfVehicle.getSelectedItem().toString().equalsIgnoreCase("Maquinaria Pesada")) {
            this.jcTypeOfMachinary.setVisible(true);
            this.jlblTypeOfMachinary.setVisible(true);
            this.jtfMileage.setVisible(false);
            this.jlblMileage.setVisible(false);
            this.jtfSeries.setVisible(false);
            this.jlSeries.setVisible(false);
            this.jlAmerican.setVisible(false);
            this.jchAmerican.setVisible(false);
            this.jtaInformationCar.setVisible(false);
            this.jbtnRemove.setVisible(false);
            this.jbtnUpdate.setVisible(false);
            this.jbtnSearch.setVisible(false);
            this.jbtnSeeAll.setVisible(false);
            this.scrollPane.setVisible(false);

        } else {
            this.jcTypeOfMachinary.setVisible(false);
            this.jlblTypeOfMachinary.setVisible(false);
            this.jtfMileage.setVisible(true);
            this.jlblMileage.setVisible(true);
            this.jtfSeries.setVisible(true);
            this.jlSeries.setVisible(true);
            this.jlAmerican.setVisible(true);
            this.jchAmerican.setVisible(true);
            this.jtaInformationCar.setVisible(true);
            this.scrollPane.setVisible(true);
            this.jbtnRemove.setVisible(true);
            this.jbtnUpdate.setVisible(true);
            this.jbtnSearch.setVisible(true);
            this.jbtnSeeAll.setVisible(true);
        }//else

    }//actionPerformed
}
