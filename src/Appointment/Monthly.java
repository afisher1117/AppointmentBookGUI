/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appointment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Monthly extends Appointment{
    
    public Monthly(int day, int month, int year, String description){
        super(day, month, year, description);                                   //Initializes constructor with Superclass
    }                                                                           //Appointment variables
    
    public boolean occursOn(ArrayList<String> appts, String day) {              //returns true if the ArrayList has an appointment 
        File file = new File("./Appointments.txt");
        Scanner in = null;
        for(String line : appts){                                               //on that day. Loop searches every line of ArrayList
            if(line.contains(day)){                                             //and iterates through each String inside the list
                return true;                                                    //return true if date is already booked
            }
        }
        try {
            in = new Scanner(file);                                             
            while(in.hasNext()){                                                
                String line = in.nextLine();
                if(line.contains(day))
                    return true;
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            System.err.println(e + "Most likely because there hasn't been other appointments made yet.");
        }
        return false;                                                           //return false if that date is open
    }
    
    public String toString(){                                                   //Adds 'Monthly:' tag and description and day
        return "Monthly: " + description + " on every " + day + " of the month\n";
    }
}
