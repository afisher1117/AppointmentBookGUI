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

public class Appointment {
    protected String description;                                               //Declared variables as protected so that 
    protected int day;                                                          //subclasses Monthly and Onetime can use them
    protected int month;
    protected int year;

    public Appointment(int day, int month, int year, String description){       //Initialize constructor with date info and a 
        this.description = description;                                         //description
        this.day = day; 
        this.month = month; 
        this.year = year; 
    }
    
    public boolean occursOn(ArrayList<String> appts, String day, String month, String year){//returns true if the ArrayList has 
        File file = new File("./Appointments.txt");
        Scanner in = null;
        for(String line : appts){                                               //an appointment that matches the mm/dd/yyyy format. 
            if(line.contains(month + "/" + day + "/" + year)){                  //Loop searches every line of ArrayList and iterates
                return true;                                                    //over every String in the ArrayList for the specific
            }                                                                   //mm/dd/yyyy passed. Returns true if the date is
        }                                                                       //booked and false if it is open.
        try {
            in = new Scanner(file);                                             
            while(in.hasNext()){                                                
                String line = in.nextLine();
                if(line.contains(month + "/" + day + "/" + year))
                    return true;
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            System.err.println(e + "Most likely because there hasn't been other appointments made yet.");
        }
        return false;
    }
    
    public String toString(){                                                   //Allows Appointment object to print its information
        return description + " on: " + month + "/" + day + "/" + year + "\n";
    }
}
