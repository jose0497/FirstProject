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
public class DriverHeavyMachinary extends Employee implements Serializable{

    private int hoursOfDriver;
    private boolean drivingSchedule;
    private int typeOfMachinary;
    private Vehicle vehicle;

    public DriverHeavyMachinary() {
        super();
        this.hoursOfDriver = -1;
        this.drivingSchedule = false;
        this.typeOfMachinary = -1;
        this.vehicle = new Vehicle() {
            @Override
            public boolean insertVehicle(Vehicle vehicle) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }

    public DriverHeavyMachinary(int hoursOfDriver, boolean drivingSchedule, int typeOfMachinary, Vehicle vehicle) {
        super();
        this.hoursOfDriver = hoursOfDriver;
        this.drivingSchedule = drivingSchedule;
        this.typeOfMachinary = typeOfMachinary;
        this.vehicle = vehicle;
    }

    public DriverHeavyMachinary(int hoursOfDriver, boolean drivingSchedule, int typeOfMachinary, Vehicle vehicle, String name, String surName, int age, double salary, int id, int employeeNumber, boolean collegeDegree) {
        super(name, surName, age, salary, id, employeeNumber, collegeDegree);
        this.hoursOfDriver = hoursOfDriver;
        this.drivingSchedule = drivingSchedule;
        this.typeOfMachinary = typeOfMachinary;
        this.vehicle = vehicle;
    }

    public int getHoursOfDriver() {
        return hoursOfDriver;
    }

    public void setHoursOfDriver(int hoursOfDriver) {
        this.hoursOfDriver = hoursOfDriver;
    }
    

    public boolean isDrivingSchedule() {
        return drivingSchedule;
    }

    public void setDrivingSchedule(boolean drivingSchedule) {
        this.drivingSchedule = drivingSchedule;
    }

    public int getTypeOfMachinary() {
        return typeOfMachinary;
    }

    public void setTypeOfMachinary(int typeOfMachinary) {
        this.typeOfMachinary = typeOfMachinary;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return super.toString() + "Horas manejadas: " + hoursOfDriver + "\n" + "Horario: " + drivingSchedule + "\n" + "Tipo: " + typeOfMachinary + "\n" + vehicle + "\n";
    }

}
