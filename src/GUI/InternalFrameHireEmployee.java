package GUI;

import File.EmployeeDataSerializable;
import File.EmployeeManySerializables;
import File.VehicleFile;
import domain.Administrative;
import domain.Car;
import domain.Concierge;
import domain.DriverCar;
import domain.DriverHeavyMachinary;
import domain.Employee;
import domain.Vehicle;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author brend
 */
public class InternalFrameHireEmployee extends JInternalFrame implements ActionListener {

    JLabel jlblName, jlblBrand, jlblSurname, jlblSalary, jlblId, jlblAge, jlblCollegeDegree, jlblTypeOfEmployee,
            jlblTypeOfDriver, jlblTypeOfMachinary, jlblHourOfDrive, jlblDrivingSchedule, jlblExtraHours, jlblState, jlblTypeOfClass, jlblAvability, jlblCar;
    private JTextField jtfName;
    private JTextField jtfSurname;
    private JTextField jtfId;
    private JTextField jtfNumberEmployee;
    private JTextField jtfAge;
    private JComboBox jcCollegeDegree;
    private JComboBox jcTypeOfEmployee;
    private JComboBox jcTypeOfDriver;
    private JComboBox jcHeavyMachinary;
    private JTextField jtfHourOfDrive;
    private JComboBox jcDrivingSchedule;
    private JTextField jtfExtraHours;
    private JComboBox jcState;
    private JComboBox jcTypeOfClass;
    private JComboBox jcAvailabity;
    private JComboBox jcCar;
    private InternalFrameSearchEmployee employeeAndVehicle;
    private InternalFrameInsertVehicle insertVehicle;
    private VehicleFile vehicleFile;
    private EmployeeManySerializables employeeManySerializables;
    private EmployeeDataSerializable employeeDataSerializable;

    private JButton jbtnContract;
    private JButton jbtnInsertVehicle;
    private JButton jbtnRemove;
    private JButton jbtnSearch;

    public InternalFrameHireEmployee() throws IOException {
        super("Contratar");
        this.setBackground(Color.lightGray);
        this.vehicleFile = new VehicleFile(new File("./MyFile/Automoviles"));
        this.setLayout(null);
        this.jlblName = new JLabel("Nombre");
        this.jlblBrand = new JLabel("Apellido");
        this.jlblSalary = new JLabel("Identificacion");
        this.jlblId = new JLabel("N.Empleado");
        this.jlblAge = new JLabel("Edad");
        this.jlblCollegeDegree = new JLabel("Titulo");
        this.jlblTypeOfEmployee = new JLabel("T.Empleado");
        this.jlblExtraHours = new JLabel("Horas E.");
        this.jlblState = new JLabel("Estado");
        this.jlblAvability = new JLabel("Disponibilidad");
        this.jlblTypeOfClass = new JLabel("Categoria");
        this.jlblHourOfDrive = new JLabel("H.Trabajadas");
        this.jlblDrivingSchedule = new JLabel("Horario");
        this.jlblTypeOfDriver = new JLabel("T.Conductor");
        this.jlblTypeOfMachinary = new JLabel("Maquinaria");
        this.jlblCar = new JLabel("Automovil");

        this.jtfName = new JTextField();
        this.jtfSurname = new JTextField();

        this.jtfId = new JTextField();
        this.jtfNumberEmployee = new JTextField();
        this.jtfAge = new JTextField();
        this.jtfExtraHours = new JTextField();
        this.jtfHourOfDrive = new JTextField();

        //JComboBox
        this.jcCar = new JComboBox();
        this.jcCollegeDegree = new JComboBox();
        this.jcTypeOfEmployee = new JComboBox();
        this.jcHeavyMachinary = new JComboBox();
        this.jcTypeOfDriver = new JComboBox();
        this.jcTypeOfClass = new JComboBox();
        this.jcState = new JComboBox();
        this.jcDrivingSchedule = new JComboBox();
        this.jcAvailabity = new JComboBox();
        //

        this.jbtnContract = new JButton("Contratar");
        this.jbtnInsertVehicle = new JButton("R.Vehiculo");
        this.jbtnRemove = new JButton("Eliminar");
        this.jbtnSearch = new JButton("Buscar");

        init();
    }

    public void init() {
        this.jcCollegeDegree.addItem("Si");
        this.jcCollegeDegree.addItem("No");

        this.jcTypeOfEmployee.addItem("Conserje");
        this.jcTypeOfEmployee.addItem("Administrativo");
        this.jcTypeOfEmployee.addItem("Conductor");

        this.jcAvailabity.addItem("Disponible");
        this.jcAvailabity.addItem("No Disponible");

        this.jcDrivingSchedule.addItem("Dia");
        this.jcDrivingSchedule.addItem("Noche");

        this.jcState.addItem("Libre");
        this.jcState.addItem("Ocupado");

        this.jcTypeOfClass.addItem("1");
        this.jcTypeOfClass.addItem("2");

        this.jcTypeOfDriver.addItem("Automovil");
        this.jcTypeOfDriver.addItem("Maquinaria Pesada");

        this.jlblName.setBounds(10, 30, 100, 20);
        this.add(this.jlblName);

        this.jlblBrand.setBounds(10, 100, 100, 20);
        this.add(this.jlblBrand);

        this.jlblSalary.setBounds(10, 240, 100, 20);
        this.add(this.jlblSalary);

        this.jlblId.setBounds(10, 310, 100, 20);
        this.add(this.jlblId);

        this.jtfName.setBounds(110, 30, 150, 20);
        this.add(this.jtfName);

        this.jtfSurname.setBounds(110, 100, 150, 20);
        this.add(this.jtfSurname);

        this.jtfId.setBounds(110, 240, 150, 20);
        this.add(this.jtfId);

        this.jtfNumberEmployee.setBounds(110, 310, 150, 20);
        this.add(this.jtfNumberEmployee);

        this.jtfAge.setBounds(360, 30, 150, 20);
        this.add(this.jtfAge);

        this.jcCollegeDegree.setBounds(110, 170, 150, 20);
        this.add(this.jcCollegeDegree);

        this.jcTypeOfEmployee.setBounds(360, 100, 150, 20);
        this.add(this.jcTypeOfEmployee);

        this.jcCar.setBounds(610, 30, 700, 20);
        this.add(this.jcCar);
        this.jcCar.setVisible(false);

        //llllllllllllllllllllllllllllllllllllll
        this.jtfExtraHours.setBounds(360, 175, 150, 20);
        this.add(this.jtfExtraHours);

        this.jcState.setBounds(360, 240, 150, 20);
        this.add(this.jcState);

        this.jcTypeOfClass.setBounds(360, 170, 150, 20);
        this.add(this.jcTypeOfClass);
        this.jcTypeOfClass.setVisible(false);

        this.jcAvailabity.setBounds(360, 240, 150, 20);
        this.add(this.jcAvailabity);
        this.jcAvailabity.setVisible(false);

        this.jcTypeOfDriver.setBounds(360, 240, 150, 20);
        this.add(this.jcTypeOfDriver);
        this.jcTypeOfDriver.setVisible(false);

        this.jcDrivingSchedule.setBounds(360, 310, 150, 20);
        this.add(this.jcDrivingSchedule);
        this.jcDrivingSchedule.setVisible(false);

        this.jtfHourOfDrive.setBounds(360, 170, 150, 20);
        this.add(this.jtfHourOfDrive);
        this.jtfHourOfDrive.setVisible(false);

        this.jcHeavyMachinary.setBounds(610, 30, 700, 20);
        this.add(this.jcHeavyMachinary);
        this.jcHeavyMachinary.setVisible(false);

        //llllllllllllllllllllllllllllllllllllll
        this.jlblAge.setBounds(280, 30, 100, 20);
        this.add(this.jlblAge);

        this.jlblHourOfDrive.setBounds(280, 170, 100, 20);
        this.add(this.jlblHourOfDrive);
        this.jlblHourOfDrive.setVisible(false);

        this.jlblTypeOfMachinary.setBounds(525, 30, 100, 20);
        this.add(this.jlblTypeOfMachinary);
        this.jlblTypeOfMachinary.setVisible(false);

        this.jlblCar.setBounds(525, 30, 100, 20);
        this.add(this.jlblCar);
        this.jlblCar.setVisible(false);

        this.jlblCollegeDegree.setBounds(10, 170, 100, 20);
        this.add(this.jlblCollegeDegree);

        this.jlblTypeOfEmployee.setBounds(280, 100, 100, 20);
        this.add(this.jlblTypeOfEmployee);

        this.jlblExtraHours.setBounds(280, 170, 100, 20);
        this.add(this.jlblExtraHours);

        this.jlblState.setBounds(280, 240, 100, 20);
        this.add(this.jlblState);

        this.jlblAvability.setBounds(280, 240, 100, 20);
        this.add(this.jlblAvability);
        this.jlblAvability.setVisible(false);

        this.jlblTypeOfClass.setBounds(280, 170, 100, 20);
        this.add(this.jlblTypeOfClass);
        this.jlblTypeOfClass.setVisible(false);

        this.jlblTypeOfDriver.setBounds(280, 240, 100, 20);
        this.add(this.jlblTypeOfDriver);
        this.jlblTypeOfDriver.setVisible(false);

        this.jlblDrivingSchedule.setBounds(280, 310, 100, 20);
        this.add(this.jlblDrivingSchedule);
        this.jlblDrivingSchedule.setVisible(false);

        this.jbtnContract.setBounds(650, 320, 100, 30);
        this.add(this.jbtnContract);
        this.jbtnContract.addActionListener(this);

        this.jbtnInsertVehicle.setBounds(650, 270, 100, 30);
        this.add(this.jbtnInsertVehicle);
        this.jbtnInsertVehicle.addActionListener(this);

        this.jbtnSearch.setBounds(650, 220, 100, 30);
        this.add(this.jbtnSearch);
        this.jbtnSearch.addActionListener(this);

        this.jbtnRemove.setBounds(650, 170, 100, 30);
//        this.add(this.jbtnRemove);
        this.jbtnRemove.addActionListener(this);

        this.jcCollegeDegree.addActionListener(this);
        this.jcTypeOfEmployee.addActionListener(this);
        this.jcAvailabity.addActionListener(this);
        this.jcDrivingSchedule.addActionListener(this);
        this.jcState.addActionListener(this);
        this.jcTypeOfClass.addActionListener(this);
        this.jcTypeOfDriver.addActionListener(this);
        this.jcHeavyMachinary.addActionListener(this);
        this.jcTypeOfDriver.addActionListener((ae) -> {
            if (jcTypeOfDriver.getSelectedIndex() == 1) {
                fillJcHeavyMachinary();
            }
        });
//        jbtnContract.setForeground(Color.white);
//        jbtnContract.setBackground(Color.green);
//        Border line = new LineBorder(Color.black);
//        Border margin = new EmptyBorder(5, 15, 5, 15);
//        Border compound = new CompoundBorder(line, margin);
        //embellecer la ventana

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.jbtnContract) {
            //se valida que ningun espacio este en blanco
            //variables para validad que se ingresen los datos del tipo correcto en los campos de texto
            Pattern patNumbers = Pattern.compile("[0-9]");
            Pattern patLetters = Pattern.compile("[aA-zZ]");
            Matcher matNumbers0 = patNumbers.matcher(jtfName.getText());
            Matcher matNumbers1 = patNumbers.matcher(jtfSurname.getText());

            Matcher matLetters0 = patLetters.matcher(jtfAge.getText());
            Matcher matLetters1 = patLetters.matcher(jtfExtraHours.getText());
            Matcher matLetters2 = patLetters.matcher(jtfHourOfDrive.getText());
            Matcher matLetters3 = patLetters.matcher(jtfId.getText());
            Matcher matLetters4 = patLetters.matcher(jtfNumberEmployee.getText());

            if (!matNumbers0.find() && !matNumbers1.find() && !matLetters0.find() && !matLetters3.find() && !matLetters4.find()) {

                if (!this.jtfName.getText().equalsIgnoreCase("") && !this.jtfId.getText().equalsIgnoreCase("")
                        && !this.jtfAge.getText().equalsIgnoreCase("")
                        && !this.jtfNumberEmployee.getText().equalsIgnoreCase("") && !this.jtfSurname.getText().equalsIgnoreCase("")) {
                    //si se a escogido conserje
                    //variables utilizadas para evitar que se ingresen identificaciones
                    // y numeros de empleado repetidos
                    boolean flag1 = true;
                    boolean flag2 = true;

                    employeeManySerializables = new EmployeeManySerializables();
                    try {
                        //con el metodo getAll se obtienen todas las identificaciones y los N.Empleado ingresados
                        //anteriormente
                        for (int i = 0; i < employeeManySerializables.getAll().size(); i++) {
                            if (employeeManySerializables.getAll().get(i).getId() == Integer.parseInt(jtfId.getText())) {
                                flag1 = false;
                                break;
                            }
                            if (employeeManySerializables.getAll().get(i).getEmployeeNumber() == Integer.parseInt(jtfNumberEmployee.getText())) {
                                flag1 = false;
                                break;
                            }
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(InternalFrameHireEmployee.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(InternalFrameHireEmployee.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    if (flag1 == true && flag2 == true) {

                        if (this.jcTypeOfEmployee.getSelectedItem().toString().equalsIgnoreCase("Conserje")) {
                            //se toman todos los datos de los campos de texto y combobox

                            boolean collegeDegree;
                            boolean state;

                            if (jcCollegeDegree.getSelectedItem().toString().equalsIgnoreCase("Si")) {
                                collegeDegree = true;
                            } else {
                                collegeDegree = false;
                            }//else

                            if (jcState.getSelectedItem().toString().equalsIgnoreCase("Libre")) {
                                state = true;
                            } else {
                                state = false;
                            }//else
                            //validadque las horas extras no esten vacias
                            if (!this.jtfExtraHours.getText().equalsIgnoreCase("") || !matLetters1.find()) {
//                        HireEmployee hireEmployee = new HireEmployee();
                                try {
                                    Employee concierge;
                                    Employee employee = new Employee();
                                    //se envian todos los datos al metodo insertConcierge
                                    concierge = new Concierge(Integer.parseInt(jtfExtraHours.getText()), state, jtfName.getText(), jtfSurname.getText(), Integer.parseInt(jtfAge.getText()), 120, Integer.parseInt(jtfId.getText()), Integer.parseInt(jtfNumberEmployee.getText()), collegeDegree);
                                    concierge.setSalary(concierge.calculateSalary(concierge));
                                    //metodo para ingresar el objeto a un archivo esto se hace con todos los tipos de empleado
                                    //y se guardan en archivos diferentes segun su tipo
                                    employeeManySerializables.serialize(concierge);
                                    JOptionPane.showMessageDialog(null, "Se inserto el empleado");
                                } catch (IOException ex) {
                                    Logger.getLogger(InternalFrameHireEmployee.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (ClassNotFoundException ex) {
                                    Logger.getLogger(InternalFrameHireEmployee.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "No se permiten espacios en blanco");
                            }//else

                        }//if

                        //lo mismo que con conserje excepto sin validar las horas extras
                        if (this.jcTypeOfEmployee.getSelectedItem().toString().equalsIgnoreCase("Administrativo")) {
                            boolean collegeDegree;
                            boolean avability;
                            if (jcCollegeDegree.getSelectedItem().toString().equalsIgnoreCase("Si")) {
                                collegeDegree = true;
                            } else {
                                collegeDegree = false;
                            }//else

                            if (jcAvailabity.getSelectedItem().toString().equalsIgnoreCase("Disponible")) {
                                avability = true;
                            } else {
                                avability = false;
                            }//else
                            Employee administrative = new Administrative(Integer.parseInt(jcTypeOfClass.getSelectedItem().toString()), avability, jtfName.getText(), jtfSurname.getText(), Integer.parseInt(jtfAge.getText()), 250, Integer.parseInt(jtfId.getText()), Integer.parseInt(jtfNumberEmployee.getText()), collegeDegree);
                            Employee employee = new Employee();
                            administrative.setSalary(employee.calculateSalary(administrative));
                            try {
                                employeeManySerializables.serialize(administrative);
                                JOptionPane.showMessageDialog(null, "Se inserto el empleado");
                            } catch (IOException ex) {
                                Logger.getLogger(InternalFrameHireEmployee.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(InternalFrameHireEmployee.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }//if

                        //lo mismo que con el conserje excepto sin validadr horas extras
                        if (this.jcTypeOfEmployee.getSelectedItem().toString().equalsIgnoreCase("Conductor")) {
                            boolean collegeDegree;
                            boolean drivingSchedule;
                            if (jcCollegeDegree.getSelectedItem().toString().equalsIgnoreCase("Si")) {
                                collegeDegree = true;
                            } else {
                                collegeDegree = false;
                            }//else
                            if (jcDrivingSchedule.getSelectedItem().toString().equalsIgnoreCase("Noche")) {
                                drivingSchedule = true;
                            } else {
                                drivingSchedule = false;
                            }//else
                            //si se escoje auutomovil
                            if (this.jcTypeOfDriver.getSelectedItem().toString().equalsIgnoreCase("Automovil")) {
                                try {
                                    if (!this.jtfHourOfDrive.getText().equalsIgnoreCase("")) {
                                        if (!matLetters2.find()) {
                                            Employee driverCar = new DriverCar(Integer.parseInt(this.jtfHourOfDrive.getText()), drivingSchedule, (Vehicle) this.jcCar.getSelectedItem(), this.jtfName.getText(), this.jtfSurname.getText(), Integer.parseInt(this.jtfAge.getText()), 10, Integer.parseInt(this.jtfId.getText()), Integer.parseInt(this.jtfNumberEmployee.getText()), collegeDegree);
                                            Employee employee = new Employee();
                                            driverCar.setSalary(employee.calculateSalary(driverCar));

                                            employeeManySerializables.serialize(driverCar);
                                            JOptionPane.showMessageDialog(null, "Se inserto el empleado");
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Caracteres inavlidos");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "No se permiten espacios en blanco");
                                    }

                                } //if
                                catch (IOException ex) {
                                    Logger.getLogger(InternalFrameHireEmployee.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (ClassNotFoundException ex) {
                                    Logger.getLogger(InternalFrameHireEmployee.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            //si se escoje maquinaria pesada
                            if (this.jcTypeOfDriver.getSelectedItem().toString().equalsIgnoreCase("Maquinaria Pesada")) {

                                Vehicle vehicle = (Vehicle) this.jcHeavyMachinary.getSelectedItem();

                                //se validan las horas trabajas que no esten vacias
                                if (!this.jtfHourOfDrive.getText().equalsIgnoreCase("")) {
                                    if (!matLetters2.find()) {
                                        if (vehicle.getName().equalsIgnoreCase("Vagoneta")) {
                                            try {

                                                Employee driverHeavyMachine = new DriverHeavyMachinary(
                                                        Integer.parseInt(this.jtfHourOfDrive.getText()),
                                                        drivingSchedule,
                                                        1,
                                                        vehicle,
                                                        this.jtfName.getText(),
                                                        this.jtfSurname.getText(),
                                                        Integer.parseInt(this.jtfAge.getText()),
                                                        10,
                                                        Integer.parseInt(this.jtfId.getText()),
                                                        Integer.parseInt(this.jtfNumberEmployee.getText()),
                                                        collegeDegree);
                                                Employee employee = new Employee();
                                                driverHeavyMachine.setSalary(employee.calculateSalary(driverHeavyMachine));

                                                employeeManySerializables = new EmployeeManySerializables();
                                                employeeManySerializables.serialize(driverHeavyMachine);
                                                JOptionPane.showMessageDialog(null, "Se inserto el empleado");
                                            } //if
                                            catch (IOException ex) {
                                                Logger.getLogger(InternalFrameHireEmployee.class.getName()).log(Level.SEVERE, null, ex);
                                            } catch (ClassNotFoundException ex) {
                                                Logger.getLogger(InternalFrameHireEmployee.class.getName()).log(Level.SEVERE, null, ex);
                                            }

                                        }
                                        if (vehicle.getName().equalsIgnoreCase("Grua")) {

                                            Employee driverHeavyMachine = new DriverHeavyMachinary(
                                                    Integer.parseInt(this.jtfHourOfDrive.getText()),
                                                    drivingSchedule,
                                                    2,
                                                    (Vehicle) this.jcHeavyMachinary.getSelectedItem(),
                                                    this.jtfName.getText(),
                                                    this.jtfSurname.getText(),
                                                    Integer.parseInt(this.jtfAge.getText()),
                                                    10,
                                                    Integer.parseInt(this.jtfId.getText()),
                                                    Integer.parseInt(this.jtfNumberEmployee.getText()),
                                                    collegeDegree);
                                            Employee employee = new Employee();
                                            driverHeavyMachine.setSalary(employee.calculateSalary(driverHeavyMachine));
                                            employeeManySerializables = new EmployeeManySerializables();
                                            try {
                                                employeeManySerializables.serialize(driverHeavyMachine);
                                            } catch (IOException ex) {
                                                Logger.getLogger(InternalFrameHireEmployee.class.getName()).log(Level.SEVERE, null, ex);
                                            } catch (ClassNotFoundException ex) {
                                                Logger.getLogger(InternalFrameHireEmployee.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                            JOptionPane.showMessageDialog(null, "Se inserto el empleado");

                                        }//if
                                        if (vehicle.getName().equalsIgnoreCase("Montacargas")) {
                                            try {

                                                Employee driverHeavyMachine = new DriverHeavyMachinary(
                                                        Integer.parseInt(this.jtfHourOfDrive.getText()),
                                                        drivingSchedule,
                                                        3,
                                                        (Vehicle) this.jcHeavyMachinary.getSelectedItem(),
                                                        this.jtfName.getText(),
                                                        this.jtfSurname.getText(),
                                                        Integer.parseInt(this.jtfAge.getText()),
                                                        10,
                                                        Integer.parseInt(this.jtfId.getText()),
                                                        Integer.parseInt(this.jtfNumberEmployee.getText()),
                                                        collegeDegree);
                                                Employee employee = new Employee();
                                                driverHeavyMachine.setSalary(employee.calculateSalary(driverHeavyMachine));
                                                employeeManySerializables = new EmployeeManySerializables();
                                                employeeManySerializables.serialize(driverHeavyMachine);
                                                JOptionPane.showMessageDialog(null, "Se inserto el empleado");

                                            } //if
                                            catch (IOException ex) {
                                                Logger.getLogger(InternalFrameHireEmployee.class.getName()).log(Level.SEVERE, null, ex);
                                            } catch (ClassNotFoundException ex) {
                                                Logger.getLogger(InternalFrameHireEmployee.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Caracteres invalidos");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "No se permiten espacios en blanco o caracteres inavalidos");
                                }//else
                            }//if

                        }//if
                    } else {
                        JOptionPane.showMessageDialog(null, "Cambie la identificación, el numero de empleado o ambos");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se permiten espacios en blanco");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Caracteres invalidos");
            }
        }//contratar

        if (e.getSource() == this.jbtnInsertVehicle) {
            this.setVisible(false);
            try {
                insertVehicle = new InternalFrameInsertVehicle();
            } catch (IOException ex) {
                Logger.getLogger(InternalFrameHireEmployee.class.getName()).log(Level.SEVERE, null, ex);
            }
            insertVehicle.setVisible(true);
            insertVehicle.setSize(780, 400);
            insertVehicle.setClosable(true);
            MainWindow.desktopPane.add(insertVehicle);

        }
        if (e.getSource() == this.jbtnRemove) {

        }
        if (e.getSource() == this.jbtnSearch) {
            this.setVisible(false);
            try {
                employeeAndVehicle = new InternalFrameSearchEmployee();
            } catch (IOException ex) {
                Logger.getLogger(InternalFrameHireEmployee.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(InternalFrameHireEmployee.class.getName()).log(Level.SEVERE, null, ex);
            }
            employeeAndVehicle.setVisible(true);
            employeeAndVehicle.setSize(780, 400);
            employeeAndVehicle.setClosable(true);
            MainWindow.desktopPane.add(employeeAndVehicle);

        }//if

        if (e.getSource() == this.jcTypeOfEmployee && this.jcTypeOfEmployee.getSelectedItem().toString().equalsIgnoreCase("Conserje")) {
            this.jcState.setVisible(true);
            this.jtfExtraHours.setVisible(true);
            this.jlblExtraHours.setVisible(true);
            this.jlblState.setVisible(true);
            this.jcTypeOfClass.setVisible(false);
            this.jcAvailabity.setVisible(false);
            this.jlblAvability.setVisible(false);
            this.jlblTypeOfClass.setVisible(false);
            this.jlblTypeOfDriver.setVisible(false);
            this.jlblDrivingSchedule.setVisible(false);
            this.jlblTypeOfDriver.setVisible(false);
            this.jlblDrivingSchedule.setVisible(false);
            this.jcTypeOfDriver.setVisible(false);
            this.jcDrivingSchedule.setVisible(false);
            this.jcHeavyMachinary.setVisible(false);
            this.jtfHourOfDrive.setVisible(false);
            this.jlblTypeOfMachinary.setVisible(false);
            this.jlblHourOfDrive.setVisible(false);
        }

        if (e.getSource() == this.jcTypeOfEmployee
                && this.jcTypeOfEmployee.getSelectedItem().toString().equalsIgnoreCase("Administrativo")) {
            this.jcState.setVisible(false);
            this.jtfExtraHours.setVisible(false);
            this.jlblExtraHours.setVisible(false);
            this.jlblState.setVisible(false);
            this.jcTypeOfClass.setVisible(true);
            this.jcAvailabity.setVisible(true);
            this.jlblAvability.setVisible(true);
            this.jlblTypeOfClass.setVisible(true);
            this.jlblTypeOfDriver.setVisible(false);
            this.jlblDrivingSchedule.setVisible(false);
            this.jlblTypeOfDriver.setVisible(false);
            this.jlblDrivingSchedule.setVisible(false);
            this.jcTypeOfDriver.setVisible(false);
            this.jcDrivingSchedule.setVisible(false);
            this.jcHeavyMachinary.setVisible(false);
            this.jtfHourOfDrive.setVisible(false);
            this.jlblTypeOfMachinary.setVisible(false);
            this.jlblHourOfDrive.setVisible(false);

        }

        if (e.getSource() == this.jcTypeOfEmployee
                && this.jcTypeOfEmployee.getSelectedItem().toString().equalsIgnoreCase("Conductor")) {
            this.jcState.setVisible(false);
            this.jtfExtraHours.setVisible(false);
            this.jlblExtraHours.setVisible(false);
            this.jlblState.setVisible(false);
            this.jcTypeOfClass.setVisible(false);
            this.jcAvailabity.setVisible(false);
            this.jlblAvability.setVisible(false);
            this.jlblTypeOfClass.setVisible(false);
            this.jlblTypeOfDriver.setVisible(true);
            this.jlblDrivingSchedule.setVisible(true);
            this.jcTypeOfDriver.setVisible(true);
            this.jcDrivingSchedule.setVisible(true);
            this.jtfHourOfDrive.setVisible(true);
            this.jlblHourOfDrive.setVisible(true);
        }
        if (this.jcTypeOfDriver.getSelectedItem().toString().equalsIgnoreCase("Maquinaria Pesada") && this.jcTypeOfEmployee.getSelectedItem().toString().equalsIgnoreCase("Conductor")) {
            if (MainWindow.vectorVehicle[1] != null) {
                this.jcHeavyMachinary.setVisible(true);
                this.jlblTypeOfMachinary.setVisible(true);

            }//if
        } else {
            this.jcHeavyMachinary.setVisible(false);
            this.jlblTypeOfMachinary.setVisible(false);
        }//else

        if (this.jcTypeOfDriver.getSelectedItem().toString().equalsIgnoreCase("Automovil") && this.jcTypeOfEmployee.getSelectedItem().toString().equalsIgnoreCase("Conductor")) {
            if (MainWindow.vectorVehicle[0] != null) {
                this.jcCar.setVisible(true);
                this.jlblCar.setVisible(true);
                try {
                    fillJcCar();
                } catch (IOException ex) {
                    Logger.getLogger(InternalFrameHireEmployee.class.getName()).log(Level.SEVERE, null, ex);
                }
            }//else
        } else {
            this.jcCar.setVisible(false);
            this.jlblCar.setVisible(false);
        }//else

    }//actionPerformed
//para llenar el jcVomboBox de autos
//metodo para llenar con objetos de tipo Car el jcCar
    public void fillJcCar() throws IOException {
        jcCar.removeAllItems();
        Car car;
        int contador = 0;
        VehicleFile vehicleFile = new VehicleFile(new File("./MyFile/Automoviles"));
        
        for (int i = 0; i < vehicleFile.getAllVehicles().size(); i++) {
            //para validar no agregar autos iguales
            if (!vehicleFile.getAllVehicles().isEmpty()) {
                car = vehicleFile.getAllVehicles().get(i);
                while (contador < vehicleFile.getAllVehicles().size()) {
                    if (car.equals(jcCar.getItemAt(contador))) {
                        contador++;
                    } else {
                        if (vehicleFile.getAllVehicles().get(contador).getSeries() < 0) {

                        } else {
                            jcCar.addItem(vehicleFile.getAllVehicles().get(contador));

                        }
                        contador++;

                    }//else
                }//while

            }//if
        }//for

    }//end
//para llenar el JComboBox de maquinaria pesada

    public void fillJcHeavyMachinary() {

        if (MainWindow.vectorVehicle != null) {
            for (int i = 0; i < MainWindow.vectorVehicle.length; i++) {
                if (MainWindow.vectorVehicle[i] != null && this.jcHeavyMachinary.getItemAt(i) != MainWindow.vectorVehicle[i]) {
                    //se verifica el tipo de maquinaria pesada para no agregarle autos
                    if (MainWindow.vectorVehicle[i].getName().equalsIgnoreCase("Vagoneta")
                            || MainWindow.vectorVehicle[i].getName().equalsIgnoreCase("Grua")
                            || MainWindow.vectorVehicle[i].getName().equalsIgnoreCase("Montacargas")) {

                        this.jcHeavyMachinary.addItem(MainWindow.vectorVehicle[i]);

                    }//if
                }//if

            }//for
            this.jcHeavyMachinary.setVisible(true);
            this.jlblTypeOfMachinary.setVisible(true);
        }//if
    }//end
}
