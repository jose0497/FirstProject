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
public class Administrative extends Employee implements Serializable{

    private int typeOfClass;
    private boolean avability;
//constructores

    public Administrative() {
        super();
        this.typeOfClass = -1;
        this.avability = false;
    }

    public Administrative(int typeOfClass, boolean avability) {
        super();
        this.typeOfClass = typeOfClass;
        this.avability = avability;
    }

    public Administrative(int typeOfClass, boolean avability, String name, String surName, int age, double salary, int id, int employeeNumber, boolean collegeDegree) {
        super(name, surName, age, salary, id, employeeNumber, collegeDegree);
        this.typeOfClass = typeOfClass;
        this.avability = avability;
    }
//getters y setters

    public int getTypeOfClass() {
        return typeOfClass;
    }

    public void setTypeOfClass(int typeOfClass) {
        this.typeOfClass = typeOfClass;
    }

    public boolean isAvability() {
        return avability;
    }

    public void setAvability(boolean avability) {
        this.avability = avability;
    }

    @Override
    public String toString() {
        return super.toString() + "Administrativo" + "\n" + "Categoria: " + typeOfClass + "\n" + "Disponibilidad: " + avability + "\n";
    }

}
