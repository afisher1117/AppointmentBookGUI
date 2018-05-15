/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appointment;


public class Daily {
    
    private String description;                                                 //and would not require date info
    
    public Daily(String description){                                           //Constructs a new Daily object with just a 
        this.description = description;                                         //description since it happens everyday. This 
    }                                                                           //uncomplicated adding Monthly and Onetime 
                                                                                //appointments.
    public String toString(){
        return "Daily: " + description + "\n";                                  //Adds 'Daily:' tag before description
    }
}
