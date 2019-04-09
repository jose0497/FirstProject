/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package File;


import Utilities.Path;
import domain.Employee;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class EmployeeDataSerializable {


    public EmployeeDataSerializable() {
        super();
        
        //ruta del archivo
        
    }

    
    public void serialize(Employee employee) throws IOException, ClassNotFoundException{
        
        File myFile = new File(Path.my_concierge_list_path);

        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
        output.writeUnshared(employee);
        output.close();
        
    }
    
    public Employee getEmployee() throws IOException, ClassNotFoundException {
        
        File myFile = new File(Path.my_concierge_list_path);
        
        Employee myPerson = new Employee();
        
        if(myFile.exists()){
            ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInput.readObject();
            myPerson = (Employee)aux;
            objectInput.close();  
        }
        
        return myPerson;
       
    }
}
