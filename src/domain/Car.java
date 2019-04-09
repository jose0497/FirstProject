/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import GUI.MainWindow;
import javax.swing.JOptionPane;

/**
 *
 * @author brend
 */
public class Car extends Vehicle {

    private float mileage;
    private boolean american;
    private int series;

    public Car() {
        super();
        this.mileage = -1;
        this.american = false;
        this.series = 0;
    }

    public Car(float mileage, boolean american, int series, String brand, int model, int licensePlate, String color) {
        super("Automovil", brand, model, licensePlate, color);
        this.mileage = mileage;
        this.american = american;
        this.series = series;
    }

    public float getMileage() {
        return mileage;
    }

    public void setMileage(float mileage) {
        this.mileage = mileage;
    }

    public boolean isAmerican() {
        return american;
    }

    public void setAmerican(boolean american) {
        this.american = american;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    //metodo para insertar vehiculos
    @Override
    public boolean insertVehicle(Vehicle vehicle) {
        Car car = (Car) vehicle;
        //instanciamos la clase Car
        for (int i = 0; i < MainWindow.vectorVehicle.length; i++) {
            //utilizamos un que itera el segun el tamano del vectorVehicle
            if (MainWindow.vectorVehicle[i] == null || car.getLicensePlate() != MainWindow.vectorVehicle[i].getLicensePlate()) {
                //controlamos que el Vector no este vacio o que no se permita entrar si el numero de placa ya se encuentra en el vector
                car.setName("Carro");
                //le damos el nombre carro
                if (MainWindow.vectorVehicle[i] == null && i != 31) {
                    //si cumple la condicion se inserta el vehiculo al arreglo vectorVehicle y retorna true
                    MainWindow.vectorVehicle[i] = car;
                    JOptionPane.showMessageDialog(null, "El Vehiculo se registro");
                    return true;
                }//if
            } else {
                //si existe el vehiculo no se inserta
                JOptionPane.showMessageDialog(null, "El Vehiculo ya existe");
                return false;
            }//else
        }//for

        return false;
    }//insertVehicle

    @Override
    public String toString() {
       
        return super.toString() + "Kilometraje: " + mileage+"\n"+"Americano: "+american+"\n"+"Serie: "+series;
    }

    
    
    
    public int size() {
        //tamanno de las variables en bytes
        //LONG: necesita dos bytes
        //String: cada caracter necesita dos bytes de espacio,
        //esto si se utiliza UTF

        return 4 + 1 + 4 + super.getName().length() * 2 + super.getBrand().length() * 2 + super.getColor().length() * 2 + 4 + 4;
    }

}//Car
