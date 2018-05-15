package Appointment;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriteAppointment {
    
    BufferedWriter writer = null;
    String dayMonthFormat = "\\d{2}";
    String yearFormat = "\\d{4}";
    
    public void writeDailyAppointment(ArrayList<String> appts){                 //Writes contents of ArrayList to Appointment file
        try {
            writer = new BufferedWriter(new FileWriter("./Appointments.txt", true));
            for(String str: appts) {                                            //loops through contents of ArrayList
                writer.write(str);                                              //Writes each iteration to file
            }
        } catch (IOException e) {
            Logger.getLogger(ViewMenuGUI.class.getName()).log(Level.SEVERE, null, e);
        } finally {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                Logger.getLogger(ViewMenuGUI.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        }
    }
    
    public void writeMonthlyAppointment(ArrayList<String> appts){               //Same as writeDailyAppointment
        try {
            writer = new BufferedWriter(new FileWriter("./Appointments.txt", true));
            for(String str: appts) {
                writer.write(str);
            }
        } catch (IOException e) {
                Logger.getLogger(ViewMenuGUI.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    Logger.getLogger(ViewMenuGUI.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }
    
    public void writeOnetimeAppointment(ArrayList<String> appts){               //Same as writeMonthlyAppointment
        try {
            writer = new BufferedWriter(new FileWriter("./Appointments.txt", true));
            for(String str: appts) {
                writer.write(str);
            }
        } catch (IOException e) {
                Logger.getLogger(ViewMenuGUI.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    Logger.getLogger(ViewMenuGUI.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }    
    }
}
