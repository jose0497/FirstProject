/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author brend
 */
public class Employee implements Serializable {

    private String name;
    private String surName;
    private int age;
    private double salary;
    private int id;
    private int employeeNumber;
    private boolean collegeDegree;

    //contructores
    public Employee() {
        this.name = "";
        this.surName = "";
        this.age = -1;
        this.salary = -1;
        this.id = -1;
        this.employeeNumber = -1;
        this.collegeDegree = false;

    }

    public Employee(String name, String surName, int age, double salary, int id, int employeeNumber, boolean collegeDegree) {
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.salary = salary;
        this.id = id;
        this.employeeNumber = employeeNumber;
        this.collegeDegree = collegeDegree;

    }
    //get's and set's

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public boolean isCollegeDegree() {
        return collegeDegree;
    }

    public void setCollegeDegree(boolean collegeDegree) {
        this.collegeDegree = collegeDegree;
    }

    //metodo para calcular el salario de los empleados
    public double calculateSalary(Employee employee) {
        //esta logica calcula el el salario del conserje siempre y cuando el parametro employee 
        //sea instancia de la clase Concierge
        if (employee instanceof Concierge) {

            //Para poder acceder a los atributos de la clase Concierge
            //es necesario castear el empleado recibido por parametro
            Concierge concierge = (Concierge) employee;
            double auxSalary = concierge.getSalary();
            //verifaca que el conserje posea horas extras sino retorna el salario sin modificar
            if (concierge.getExtraHours() > 0) {
                //obtengo un cuarto del salario y utilizo un for que suma un cuarto del
                //salario dependiendo del numero de horas extras
                double div = concierge.getSalary() * 1 / 4;
                for (int i = 0; i < concierge.getExtraHours(); i++) {
                    concierge.setSalary(auxSalary += div);
                }//for
            }//if 
            //se suma un %3,95 al salario si cuenta con titulo universitariio
            if (concierge.isCollegeDegree()) {
                concierge.setSalary(auxSalary += auxSalary * 0.0395);
                return concierge.getSalary();
            }//if

        }//if
//calcula el salario de administrativo
        if (employee instanceof Administrative) {
            //casteo para acceder a los metodos de administrative
            Administrative administrative = (Administrative) employee;
            //variable auxiliar pque utilizaremos para calcular el salario
            double auxSalary = administrative.getSalary();

            if (administrative.getTypeOfClass() == 2) {
                //si el administrativo es de categoria 2 se le suma un 1/5mas a su salario
                auxSalary += auxSalary * 1 / 5;
            }//if

            //suma si esta calificado para el trabajo
            if (administrative.isCollegeDegree()) {
                auxSalary += auxSalary * 0.0395;
                administrative.setSalary(auxSalary);
                return administrative.getSalary();

            } else {
                administrative.setSalary(auxSalary);
                return administrative.getSalary();
            }

        }//if    
//para calcular salario de DriverCar
        if (employee instanceof DriverCar) {
            DriverCar driverCar = (DriverCar) employee;
            driverCar.setSalary(10);
            //se le otorga un valor de 10 dolares a cada hora trabajada
            double auxSalary = driverCar.getSalary();
            //variable auxiliar para calcular el salario
            auxSalary = driverCar.getHoursOfDriver() * auxSalary;
            if (driverCar.isDrivingSchedule()) {
                //si el horario del conductor es de noche
                auxSalary = auxSalary * 2;
                //se ledobla el salario
            }//if
            if (driverCar.isCollegeDegree()) {
                auxSalary += auxSalary * 0.0395;
                driverCar.setSalary(auxSalary);
                return driverCar.getSalary();

            } else {
                driverCar.setSalary(auxSalary);
                return driverCar.getSalary();
            }//else

        }//if
        //calcula el salario de DriverHeavyMachinary es lo mismo que el de DriverCar pero con la
        //diferencia de que dependiendo del tipo de maquinaria se e suma un extra
        //1=Vagoneta, 2=Grua, 3=Montacargas
        if (employee instanceof DriverHeavyMachinary) {
            
            DriverHeavyMachinary driverHeavyMachinary = (DriverHeavyMachinary) employee;
            double auxSalary = 10;

            auxSalary = driverHeavyMachinary.getHoursOfDriver() * auxSalary;

            if (driverHeavyMachinary.isDrivingSchedule()) {
                auxSalary = auxSalary * 2;
            }//if

            if (driverHeavyMachinary.getTypeOfMachinary() == 1) {
                auxSalary += 6;

            }//if
            if (driverHeavyMachinary.getTypeOfMachinary() == 2) {
                auxSalary += 8;

            }//if
            if (driverHeavyMachinary.getTypeOfMachinary() == 3) {
                auxSalary += 14;
            }//if 
            
                if (driverHeavyMachinary.isCollegeDegree()) {
                    auxSalary += auxSalary * 0.0395;
                    driverHeavyMachinary.setSalary(auxSalary);
                    return driverHeavyMachinary.getSalary();
                } else {
                    driverHeavyMachinary.setSalary(auxSalary);
                    return driverHeavyMachinary.getSalary();
                }//else
            

        }//drivers

        return employee.getSalary();
    }//calcular salario

    @Override
    public String toString() {
        return "Empleado: " + name + "\n"
                + "Apellido: " + surName + "\n"
                + "Edad: " + age + "\n"
                + "Salario: " + salary + "\n"
                + "Identificacion: " + id + "\n"
                + "Numero de Empleado: " + employeeNumber + "\n"
                + "Titulo Universitrio: " + collegeDegree + "\n";
    }

}
