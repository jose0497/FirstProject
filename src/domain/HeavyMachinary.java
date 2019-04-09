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
public class HeavyMachinary extends Vehicle  {

    private int type;

    public HeavyMachinary() {
        super();
        this.type = -1;
    }

    public HeavyMachinary(int type) {
        super();
        this.type = type;
    }

    public HeavyMachinary(int type, String name, String brand, int model, int licensePlate, String color) {
        super(name, brand, model, licensePlate, color);
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
//metodo encargado de insertar vehiculo de maquinaria pesada

    @Override
    public boolean insertVehicle(Vehicle vehicle) {
        HeavyMachinary heavyMachinary = (HeavyMachinary) vehicle;
//si la maquinaria pesada es una vagoneta
        if (heavyMachinary.getType() == 1) {
            heavyMachinary.setName("Vagoneta");
            //le ponemos el nombre
            for (int i = 0; i < MainWindow.vectorVehicle.length; i++) {
                //ifque controla que vectorVehicle no este vacio o que el vehiculo no haya sido registrado
                if (MainWindow.vectorVehicle[i] == null || heavyMachinary.getLicensePlate() != MainWindow.vectorVehicle[i].getLicensePlate()) {
                    if (MainWindow.vectorVehicle[i] == null && i != 31) {
                        //es insertado en el vetorVehicle
                        MainWindow.vectorVehicle[i] = heavyMachinary;
                        JOptionPane.showMessageDialog(null, "El vehiculo registrado");
                        return true;
                    }//if
                } else {
                    //no se inserta nada
                    JOptionPane.showMessageDialog(null, "El Vehiculo ya existe");
                    return false;
                }//else 
            }//for
        }//if
        //lo mismo de vagoneta solo que con grua
        if (heavyMachinary.getType() == 2) {

            heavyMachinary.setName("Grua");
            for (int i = 0; i < MainWindow.vectorVehicle.length; i++) {
                if (MainWindow.vectorVehicle[i] == null || heavyMachinary.getLicensePlate() != MainWindow.vectorVehicle[i].getLicensePlate()) {
                    if (MainWindow.vectorVehicle[i] == null && i != 31) {
                        MainWindow.vectorVehicle[i] = heavyMachinary;
                        JOptionPane.showMessageDialog(null, "El vehiculo registrado");
                        return true;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El Vehiculo ya existe");
                    return false;
                }//else 
            }//for 
        }//if
        //lo mismo de vagoneta solo que con Montacargas
        if (heavyMachinary.getType() == 3) {
            heavyMachinary.setName("Montacargas");
            for (int i = 0; i < MainWindow.vectorVehicle.length; i++) {
                if (MainWindow.vectorVehicle[i] == null || heavyMachinary.getLicensePlate() != MainWindow.vectorVehicle[i].getLicensePlate()) {
                    if (MainWindow.vectorVehicle[i] == null && i != 31) {
                        MainWindow.vectorVehicle[i] = heavyMachinary;
                        JOptionPane.showMessageDialog(null, "El vehiculo registrado");
                        return true;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El Vehiculo ya existe");
                    return false;
                }//else 
            }//for
        }//if

        return false;
    }//insertVehicle

    @Override
    public String toString() {
        return super.toString() + "Maquinaria Pesada " + "Tipo: " + type + "\n";
    }

}
