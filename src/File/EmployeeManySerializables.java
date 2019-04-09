/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import Utilities.Path;
import domain.Administrative;
import domain.Concierge;
import domain.DriverCar;
import domain.DriverHeavyMachinary;
import domain.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class EmployeeManySerializables {

    private String path;
    File myFile;

    /**
     *
     * @param path_
     */
    public EmployeeManySerializables() {
        super();
        path = Path.my_concierge_list_path;

    }

    /**
     * Guarda en archivo un objeto de tipo Employee
     *
     * @param employee
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void serialize(Employee employee) throws IOException, ClassNotFoundException {

        //instancia de file
        if (employee instanceof Concierge) {
            myFile = new File(Path.my_concierge_list_path);
        }
        if (employee instanceof Administrative) {
            myFile = new File(Path.my_administrative_list_path);
        }
        if (employee instanceof DriverCar) {
            myFile = new File(Path.my_driverCar_list_path);
        }
        if (employee instanceof DriverHeavyMachinary) {
            myFile = new File(Path.my_driverMachinary_list_path);
        }
        //lista que se obtiene y se guarda en archivo
        List<Employee> employeeList = new ArrayList<Employee>();

        //si el archivo existe, recupero la lista
        if (myFile.exists()) {
            ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInput.readObject();

            //casting a lista
            employeeList = (List<Employee>) aux;
            objectInput.close();
        }

        //agrego la persona a la lista
        employeeList.add(employee);

        //escribo el objeto lista (que contiene objetos de tipo Person) en archivo
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
        output.writeUnshared(employeeList);

        //cierro el archivo
        output.close();
    }

    /**
     * Busca en el archivo la persona y la retorna como Objeto Person
     *
     * @param name_ nombre de la persona que se busca en el archivo
     * @return objeto de tipo Person, con los datos de la persona que se busca
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Employee getPerson(String name) throws IOException, ClassNotFoundException {

        //instancia de file
        File myFile = new File(Path.my_concierge_list_path);

        //lista que voy a recorrer para buscar a una persona
        List<Employee> employeeList = new ArrayList<Employee>();

        //si el archivo existe entonces recupero a la persona
        if (myFile.exists()) {
            //llevo a cabo una lectura de la lista
            ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInput.readObject();

            //casting del objeto
            employeeList = (List<Employee>) aux;
            objectInput.close();
        }

        //mi instancia a retornar
        Employee myPerson = new Employee();

        //recorro la lista en busca de la persona que me interesa
        for (int i = 0; i < employeeList.size(); i++) {

            //pregunta si es la persona
            if (employeeList.get(i).getName().equalsIgnoreCase(name)) {
                //
                myPerson = employeeList.get(i);

                //esta linea me hace salir del ciclo
                break;
            }
        }

        //retorna la persona ya sea con datos nulos o con la persona buscada
        return myPerson;
    }

    public ArrayList<Employee> getAll() throws FileNotFoundException, IOException, ClassNotFoundException {

        ArrayList<Employee> employeAllList = new ArrayList<Employee>();
        if (!getConcierge().isEmpty() || !getAdministrative().isEmpty() || !getDriverCar().isEmpty() || !getDriverHeavyMachinary().isEmpty()) {
            for (int i = 0; i < getConcierge().size(); i++) {
                employeAllList.add(getConcierge().get(i));
            }

            for (int i = 0; i < getAdministrative().size(); i++) {
                employeAllList.add(getAdministrative().get(i));
            }
            for (int i = 0; i < getDriverCar().size(); i++) {
                employeAllList.add(getDriverCar().get(i));
            }
            for (int i = 0; i < getDriverHeavyMachinary().size(); i++) {
                employeAllList.add(getDriverHeavyMachinary().get(i));
            }
        }
        return employeAllList;
    }

    public ArrayList<Employee> getConcierge() throws FileNotFoundException, IOException, ClassNotFoundException {

        myFile = new File(Path.my_concierge_list_path);

        //lista que voy a recorrer para buscar a una persona
        ArrayList<Employee> employeeList = new ArrayList<Employee>();

        //si el archivo existe entonces recupero a la persona
        if (myFile.exists()) {
            //llevo a cabo una lectura de la lista
            ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInput.readObject();

            //casting del objeto
            employeeList = (ArrayList<Employee>) aux;
            objectInput.close();
        }

        return employeeList;
    }

    public ArrayList<Employee> getAdministrative() throws FileNotFoundException, IOException, ClassNotFoundException {

        myFile = new File(Path.my_administrative_list_path);

        //lista que voy a recorrer para buscar a una persona
        ArrayList<Employee> employeeList = new ArrayList<Employee>();

        //si el archivo existe entonces recupero a la persona
        if (myFile.exists()) {
            //llevo a cabo una lectura de la lista
            ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInput.readObject();

            //casting del objeto
            employeeList = (ArrayList<Employee>) aux;
            objectInput.close();
        }

        return employeeList;
    }

    public ArrayList<Employee> getDriverCar() throws FileNotFoundException, IOException, ClassNotFoundException {

        myFile = new File(Path.my_driverCar_list_path);

        //lista que voy a recorrer para buscar a una persona
        ArrayList<Employee> employeeList = new ArrayList<Employee>();

        //si el archivo existe entonces recupero a la persona
        if (myFile.exists()) {
            //llevo a cabo una lectura de la lista
            ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInput.readObject();

            //casting del objeto
            employeeList = (ArrayList<Employee>) aux;
            objectInput.close();
        }

        return employeeList;
    }

    public ArrayList<Employee> getDriverHeavyMachinary() throws FileNotFoundException, IOException, ClassNotFoundException {

        myFile = new File(Path.my_driverMachinary_list_path);

        //lista que voy a recorrer para buscar a una persona
        ArrayList<Employee> employeeList = new ArrayList<Employee>();

        //si el archivo existe entonces recupero a la persona
        if (myFile.exists()) {
            //llevo a cabo una lectura de la lista
            ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInput.readObject();

            //casting del objeto
            employeeList = (ArrayList<Employee>) aux;
            objectInput.close();
        }

        return employeeList;
    }

    private void writeConcierges(ArrayList<Employee> empleados) throws FileNotFoundException, IOException {
        myFile = new File(Path.my_concierge_list_path);
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
        output.writeUnshared(empleados);
        //cierro el archivo
        output.close();
    }

    private void writeAdministratives(ArrayList<Employee> empleados) throws FileNotFoundException, IOException {
        myFile = new File(Path.my_administrative_list_path);
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
        output.writeUnshared(empleados);
        //cierro el archivo
        output.close();
    }

    private void writeDriversCar(ArrayList<Employee> empleados) throws FileNotFoundException, IOException {
        myFile = new File(Path.my_driverCar_list_path);
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
        output.writeUnshared(empleados);
        //cierro el archivo
        output.close();
    }

    private void writeDriversHeavyMachinary(ArrayList<Employee> empleados) throws FileNotFoundException, IOException {
        myFile = new File(Path.my_driverMachinary_list_path);
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
        output.writeUnshared(empleados);
        //cierro el archivo
        output.close();
    }

    public boolean existEmployee(int id) throws IOException, FileNotFoundException, ClassNotFoundException {
        ArrayList<Employee> employeeList = new ArrayList<>();
        for (int i = 0; i < getAll().size(); i++) {
            employeeList.add(getAll().get(i));
        }
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == id) {
                return true;
            }
        }
        return false;
    }

    public Employee getEmployee(int id) throws IOException, FileNotFoundException, ClassNotFoundException {
        ArrayList<Employee> employeeList = new ArrayList<>();
        for (int i = 0; i < getAll().size(); i++) {
            employeeList.add(getAll().get(i));
        }
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == id) {
                return employeeList.get(i);
            }
        }
        return null;
    }

    public void removeEmployee(int id) throws IOException, FileNotFoundException, ClassNotFoundException {
        Employee employee = getEmployee(id);

        if (employee != null) {
            if (employee instanceof Concierge) {
                ArrayList<Employee> concierges = getConcierge();
                for (int i = 0; i < concierges.size(); i++) {
                    if (concierges.get(i).getId() == employee.getId()) {
                        concierges.remove(i);

                    }
                    //llamo al metodo de writeConcierges para sobreescribir el archivo sin el empledo borrado
                    writeConcierges(concierges);
                }
            }
            if (employee instanceof Administrative) {
                ArrayList<Employee> administratives = getAdministrative();
                for (int i = 0; i < administratives.size(); i++) {
                    if (administratives.get(i).getId() == employee.getId()) {
                        administratives.remove(i);

                    }
                    //llamo al metodo de writeAdministratives para sobreescribir el archivo sin el empledo borrado
                    writeAdministratives(administratives);
                }
            }
            if (employee instanceof DriverCar) {
                ArrayList<Employee> driversCar = getDriverCar();
                for (int i = 0; i < driversCar.size(); i++) {
                    if (driversCar.get(i).getId() == employee.getId()) {
                        driversCar.remove(i);

                    }
                    //llamo al metodo de writeDriversCar para sobreescribir el archivo sin el empledo borrado
                    writeDriversCar(driversCar);
                }
            }
            if (employee instanceof DriverHeavyMachinary) {
                ArrayList<Employee> driversHeavyMachinary = getDriverHeavyMachinary();
                for (int i = 0; i < driversHeavyMachinary.size(); i++) {
                    if (driversHeavyMachinary.get(i).getId() == employee.getId()) {
                        driversHeavyMachinary.remove(i);

                    }
                    //llamo al metodo de writeDriversHeavyMachinary para sobreescribir el archivo sin el empledo borrado
                    writeDriversHeavyMachinary(driversHeavyMachinary);
                }
            }

            
        }
    }

}
