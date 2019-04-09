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
public class DriverCar extends Employee implements Serializable {

    private int hoursOfDriver;
    private boolean drivingSchedule;
    private Vehicle car;

    public DriverCar() {
        super();
        this.hoursOfDriver = -1;
        this.drivingSchedule = false;
        this.car = new Vehicle() {
            @Override
            public boolean insertVehicle(Vehicle vehicle) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };

    }

    public DriverCar(int hoursOfDriver, boolean drivingSchedule, Vehicle car) {
        super();
        this.hoursOfDriver = hoursOfDriver;
        this.drivingSchedule = drivingSchedule;
        this.car = car;
    }

    public DriverCar(int hoursOfDriver, boolean drivingSchedule, Vehicle car, String name, String surName, int age, double salary, int id, int employeeNumber, boolean collegeDegree) {
        super(name, surName, age, salary, id, employeeNumber, collegeDegree);
        this.hoursOfDriver = hoursOfDriver;
        this.drivingSchedule = drivingSchedule;
        this.car = car;
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

    public Vehicle getCar() {
        return car;
    }

    public void setCar(Vehicle car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return super.toString() + "Horas manejadas:" + hoursOfDriver +"\n"+ "Horario: " + drivingSchedule +"\n"+ car + "\n";
    }

}
