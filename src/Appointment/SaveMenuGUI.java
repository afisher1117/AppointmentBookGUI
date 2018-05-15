/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appointment;

import java.awt.Font;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class SaveMenuGUI extends javax.swing.JFrame {

    Scanner in = new Scanner(System.in);
    String dayMonthFormat = "\\d{2}";
    String yearFormat = "\\d{4}";
    
    public void saveDailyAppointment(){
        ArrayList<String> appts = new ArrayList<>();                      //Initializes new ArrayList<String>. This will be 
        int choice;                                                     //a temporary instance for storing new Daily 
        String dailyAppt = "";
        do{                                                                     //appointments. 
            dailyAppt = JOptionPane.showInputDialog(this,
                "Enter your new Daily appointment: ",
                "New Daily",
                JOptionPane.INFORMATION_MESSAGE);
            if(dailyAppt == null){
                break;
            }
            Daily d = new Daily(dailyAppt);
            String newD = d.toString();
            appts.add(newD);
            choice = JOptionPane.showConfirmDialog(this,
                    "Appointment saved.\n" + "Add another Daily appointment? (y/n): ",
                    "New Daily", 
                    JOptionPane.YES_NO_OPTION);
        }while(choice == JOptionPane.YES_OPTION);
        WriteAppointment daily = new WriteAppointment();
        daily.writeDailyAppointment(appts);                                     //The ArrayList is sent to be written to file
    }
    
    public void saveMonthlyAppointment(){                                       //Same concept as saveDailyAppointment
        ArrayList<String> appts = new ArrayList<>();
        int choice;
        do{
            String description = JOptionPane.showInputDialog(this,
                "Enter your new Monthly appointment description: ",
                "New Monthly: Description",
                JOptionPane.INFORMATION_MESSAGE);
            if(description == null){
                break;
            }
            String dayString = JOptionPane.showInputDialog(this,
                "Enter what day of the month this new appointment will fall on (dd): ",
                "New Monthly: Day",
                JOptionPane.INFORMATION_MESSAGE);
            if(dayString == null){
                break;
            }
            while(!dayString.matches(dayMonthFormat)){
                dayString = JOptionPane.showInputDialog(this,
                "Day value entered incorrectly. Please us 'dd' format: ",
                "Day Value Error",
                JOptionPane.INFORMATION_MESSAGE);
            }
            int day = Integer.parseInt(dayString);                              //Changes String to int to pass into new 
            Monthly m = new Monthly(day, 1, 1, description);                    //Monthly object
            String newM = m.toString();                                         //Creating string to use in occursOn method
            if((m.occursOn(appts, dayString))){                                 //See Monthly.java for comments
                JOptionPane.showMessageDialog(this,
                        "You have an appointment that day, please select another date.",
                        "Date Already Booked",
                        JOptionPane.INFORMATION_MESSAGE);
                newM = "";
                saveMonthlyAppointment();
            }
            appts.add(newM);                                                    //adds new String to ArrayList
            choice = JOptionPane.showConfirmDialog(this,
                    "Appointment saved.\n" + "Add another Monthly appointment? (y/n): ",
                    "New Monthly", 
                    JOptionPane.YES_NO_OPTION);
        }while(choice == JOptionPane.YES_OPTION);
        WriteAppointment monthly = new WriteAppointment();
        monthly.writeMonthlyAppointment(appts);                                         //Sends ArrayList to be written to file
    }
    
    public void saveOnetimeAppointment(){                                       //Same as saveMonthlyAppointment
        ArrayList<String> appts = new ArrayList<>();
        int choice;
        do{
            String dayString = JOptionPane.showInputDialog(this,
                "Enter what day of the month this new appointment will fall on (dd): ",
                "New Onetime: Day",
                JOptionPane.INFORMATION_MESSAGE);
            if(dayString == null){
                break;
            }
            while(!dayString.matches(dayMonthFormat)){                                                                 //Searches dayString for dd format
                dayString = JOptionPane.showInputDialog(this,
                "Day value entered incorrectly. Please us 'dd' format: ",
                "Day Value Error",
                JOptionPane.INFORMATION_MESSAGE);
            }
            int day = Integer.parseInt(dayString);                              //Changes String to int
            String monthString = JOptionPane.showInputDialog(this,
                "Enter what month this new appointment will fall on (mm): ",
                "New Onetime: Month",
                JOptionPane.INFORMATION_MESSAGE);
            if(monthString == null){
                break;
            }
            while(!monthString.matches(dayMonthFormat)){
                monthString = JOptionPane.showInputDialog(this,
                "Month value entered incorrectly. Please us 'mm' format: ",
                "Month Value Error",
                JOptionPane.INFORMATION_MESSAGE);
            }
            int month = Integer.parseInt(monthString);                          //Changes String to int
            String yearString = JOptionPane.showInputDialog(this,
                "Enter what year this new appointment will fall on (yyyy): ",
                "New Onetime: Year",
                JOptionPane.INFORMATION_MESSAGE);
            if(yearString == null){
                break;
            }
            while(!yearString.matches(yearFormat)){                                                                 //Searches yearString for yyyy format
                yearString = JOptionPane.showInputDialog(this,
                "Year value entered incorrectly. Please us 'yyyy' format: ",
                "Year Value Error",
                JOptionPane.INFORMATION_MESSAGE);
            }
            int year = Integer.parseInt(yearString);
            String description = JOptionPane.showInputDialog(this,
                "Finally, enter a description of this new appointment: ",
                "New Onetime: Description",
                JOptionPane.INFORMATION_MESSAGE);
            if(description == null){
                break;
            }
            Onetime o = new Onetime(day, month, year, description);
            String newO = o.toString();                                         //Creating String for occursOn method
            if((o.occursOn(appts, dayString, monthString, yearString))){        //See Appointment.java for method comments
                JOptionPane.showMessageDialog(this,
                        "You have an appointment that day, please select another date.",
                        "Date Already Booked",
                        JOptionPane.INFORMATION_MESSAGE);
                newO = "";
                saveOnetimeAppointment();
            }
            appts.add(newO);                                                    //Adding appointment info to ArrayList
            choice = JOptionPane.showConfirmDialog(this,
                    "Appointment saved.\n" + "Add another Onetime appointment? (y/n): ",
                    "New Onetime", 
                    JOptionPane.YES_NO_OPTION);
        }while(choice == JOptionPane.YES_OPTION);
        WriteAppointment oneTime = new WriteAppointment();
        oneTime.writeOnetimeAppointment(appts);                                         //Passes ArrayList to be written to file
    }
    
    public SaveMenuGUI() {
        initComponents();
        setSize(962, 625);
        setLocationRelativeTo(this);
        menuPrint(menuText);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menuText = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        dailyButton = new javax.swing.JButton();
        monthlyButton = new javax.swing.JButton();
        onetimeButton = new javax.swing.JButton();
        mainMenuButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuText.setColumns(20);
        menuText.setRows(5);
        jScrollPane1.setViewportView(menuText);
        menuText.setEditable(false);

        jPanel2.setLayout(new java.awt.GridLayout(3, 2));

        dailyButton.setText("<html>\n<h2 style=\"text-align: center\">New Daily Appointment</h2>");
        dailyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dailyButtonActionPerformed(evt);
            }
        });
        jPanel2.add(dailyButton);

        monthlyButton.setText("<html>\n<h2 style=\"text-align: center\">New Monthly Appointment</h2>");
        monthlyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthlyButtonActionPerformed(evt);
            }
        });
        jPanel2.add(monthlyButton);

        onetimeButton.setText("<html>\n<h2 style=\"text-align: center\">New Onetime Appointment</h2>");
        onetimeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onetimeButtonActionPerformed(evt);
            }
        });
        jPanel2.add(onetimeButton);

        mainMenuButton.setText("<html>\n<h2 style=\"text-align: center\">Return to Main Menu</h2>");
        mainMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenuButtonActionPerformed(evt);
            }
        });
        jPanel2.add(mainMenuButton);

        exitButton.setText("<html>\n<h2 style=\"text-align: center\">Exit Program</h2>");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        jPanel2.add(exitButton);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        this.processWindowEvent(
                new WindowEvent(
                      this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_exitButtonActionPerformed

    private void dailyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dailyButtonActionPerformed
        saveDailyAppointment();
    }//GEN-LAST:event_dailyButtonActionPerformed

    private void monthlyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthlyButtonActionPerformed
        saveMonthlyAppointment();
    }//GEN-LAST:event_monthlyButtonActionPerformed

    private void onetimeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onetimeButtonActionPerformed
        saveOnetimeAppointment();
    }//GEN-LAST:event_onetimeButtonActionPerformed

    private void mainMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenuButtonActionPerformed
        ApptMenuGUI newGUI = null;
        try {
            newGUI = new ApptMenuGUI();
        } catch (IOException ex) {
            Logger.getLogger(SaveMenuGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.processWindowEvent(
                new WindowEvent(
                      this, WindowEvent.WINDOW_DEACTIVATED));
        this.setVisible(false);
        newGUI.setVisible();
        
    }//GEN-LAST:event_mainMenuButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SaveMenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SaveMenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SaveMenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SaveMenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SaveMenuGUI().setVisible(true);
            }
        });
    }
    
    private void menuPrint(JTextArea menuText){
        String one = "\n\n\n                                    Welcome to the appointment saver.\n";
        String two = "                                    From here, you may: \n";
        String three = "                                    1) Save a new Daily appointment\n";
        String four = "                                    2) Save a new Monthly appointment\n";
        String five = "                                    3) Save a new Onetime appointment\n";
        String six = "                                    4) Return to Main Menu\n";
        String seven = "                                    5) Exit program";
        
        menuText.setText(one + two + three + four + five + six + seven);
        menuText.setFont(new Font("Arial",Font.PLAIN, 26));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dailyButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton mainMenuButton;
    private javax.swing.JTextArea menuText;
    private javax.swing.JButton monthlyButton;
    private javax.swing.JButton onetimeButton;
    // End of variables declaration//GEN-END:variables
}
