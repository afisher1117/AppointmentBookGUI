/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appointment;

public class Onetime extends Appointment{
    
    public Onetime(int day, int month, int year, String description){           
        super(day, month, year, description);                                   //Calls the Superclass Appointment 
    }
    
    public String toString(){
        return "Onetime appt: " + super.toString();                             //Adds 'Onetime appt:' tag to Appointment class's
    }                                                                           //toString() method
}
