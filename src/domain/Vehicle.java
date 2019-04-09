/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import GUI.MainWindow;
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author brend
 */
public abstract class Vehicle implements Serializable{

    private String name;
    private String brand;
    private int model;
    private int licensePlate;
    private String color;
   

    public Vehicle() {
        this.name = "";
        this.brand = "";
        this.model = -1;
        this.licensePlate = -1;
        this.color = "";
        
    }

    public Vehicle(String name, String brand, int model, int licensePlate, String color ) {
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.color = color;
       
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public int getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(int licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

   
//metodo abstacto para insertar vehiculos
    public abstract boolean insertVehicle(Vehicle vehicle);
    //metodo para visiualizar la informacion del vehiculo
     public Vehicle seeVechicle(int licencePlate) {
         
        for (int i = 0; i < MainWindow.vectorVehicle.length; i++) {
            //verifica que no este vacio y que no este registrado el vehiculo
            if (MainWindow.vectorVehicle[i] != null && MainWindow.vectorVehicle[i].getLicensePlate()==licencePlate) {
                JOptionPane.showMessageDialog(null, "Vehiculo encontrado");
                //retorna el vehiculo
                return MainWindow.vectorVehicle[i];
            }//if

        }//for
        return null;
    }//

    @Override
    public String toString() {
        return "Vehiculo: " + name +" \n"+ "Marca: " + brand + "\n"+"Año: " + model +" \n"+ "Placa: " + licensePlate +"\n"+ "Color: " + color + "\n";
    }
    
    
    
}
