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
public class Concierge extends Employee implements Serializable {

    private int extraHours;
    private boolean state;

    //constructores
    public Concierge() {
        super();
        this.extraHours = -1;
        this.state = false;
    }

    public Concierge(int extraHours, boolean state) {
        super();
        this.extraHours = extraHours;
        this.state = state;
    }

    public Concierge(int extraHours, boolean state, String name, String surName, int age, double salary, int id, int employeeNumber, boolean collegeDegree) {
        super(name, surName, age, salary, id, employeeNumber, collegeDegree);
        this.extraHours = extraHours;
        this.state = state;
    }

    //getters y setters
    public int getExtraHours() {
        return extraHours;
    }

    public void setExtraHours(int extraHours) {
        this.extraHours = extraHours;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return super.toString() + "Conserje " + "\n" + "Horas Extra: " + extraHours + "\n" + "Estado: " + state + "\n";
    }

}
