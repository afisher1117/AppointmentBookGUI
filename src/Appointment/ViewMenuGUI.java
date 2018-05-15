/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appointment;

import java.awt.Font;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class ViewMenuGUI extends javax.swing.JFrame {

    BufferedWriter writer = null;
    
    public void menuPrint(JTextArea menuText){
        String one = "\n\n                                Welcome to the appointment viewer.\n";
        String two = "                                From here, you may:\n";
        String three = "                                1) View your Daily appointments\n";
        String four = "                                2) View your Monthly appointments\n";
        String five = "                                3) View your Onetime appointments\n";
        String six = "                                4) View all appointments\n";
        String seven = "                                5) Return to Main Menu\n";
        String eight = "                                6) Exit program";
        
        menuText.setText(one + two + three + four + five + six + seven + eight);
        menuText.setFont(new Font("Arial",Font.PLAIN, 28));
    }
    
    public void dailyPrint() throws FileNotFoundException{                      //Prints all Daily appointments only
        File file = new File("./Appointments.txt");
        Scanner in = null;
        String daily = "Your Daily Appointments are: \n";
        menuText.setText(daily);
        try {
            in = new Scanner(file);
            while(in.hasNext()){                                                //Checking every line
                String line = in.nextLine();
                if(line.contains("Daily:")){                                     //If file contains line with 'Daily:' tag
                    daily += ("\n" + line);
                    menuText.setText("\n" + daily);
                }
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(ViewMenuGUI.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void monthlyPrint() throws FileNotFoundException{                    //Prints all Monthly appointments only
        File file = new File("./Appointments.txt");
        Scanner in = null;
        String monthly = "Your Monthly Appointments are: \n";
        try {
            in = new Scanner(file);
            while(in.hasNext()){                                                //Checking every line
                String line = in.nextLine();
                if(line.contains("Monthly:")){                                   //If file contains line with 'Monthly:' tag
                    monthly += ("\n" + line);
                    menuText.setText(monthly);
                }
            }
            System.out.println();
        } catch (IOException e) {
            Logger.getLogger(ViewMenuGUI.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void onetimePrint() throws FileNotFoundException{                    //Prints all Onetime Appointments only
        File file = new File("./Appointments.txt");                             //Same as dailyPrint and monthlyPrint
        Scanner in = null;
        String oneTime = "Your Onetime Appointments are: \n";
        try {
            in = new Scanner(file);                                         
            while(in.hasNext()){
                String line = in.nextLine();
                if(line.contains("Onetime appt:")){
                    oneTime += ("\n" + line);
                    menuText.setText(oneTime);
                }
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(ViewMenuGUI.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void allPrint() throws IOException{                                  //Prints entire Appointments file
        try {
            BufferedReader br = new BufferedReader(new FileReader("./Appointments.txt"));
            String line = null;
            String all = "Your appointments are: ";
            while ((line = br.readLine()) != null) {
                all += ("\n" + line);
                menuText.setText(all);
            }
        } catch (IOException e) {
            Logger.getLogger(ViewMenuGUI.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public ViewMenuGUI() {
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
        viewDailyButton = new javax.swing.JButton();
        viewMonthlyButton = new javax.swing.JButton();
        viewOnetimeButton = new javax.swing.JButton();
        viewAllButton = new javax.swing.JButton();
        mainMenuButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuText.setColumns(20);
        menuText.setRows(5);
        jScrollPane1.setViewportView(menuText);
        menuText.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );

        jPanel2.setLayout(new java.awt.GridLayout(2, 3, 1, 1));

        viewDailyButton.setText("<html>\n<h2 style=\"text-align: center\">View Daily Appointments</h2>\n</html>");
        viewDailyButton.setActionCommand("<html>\n<h2 style=\"text-align: center\">View Daily Appointments</h2>\n</html>");
        viewDailyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewDailyButtonActionPerformed(evt);
            }
        });
        jPanel2.add(viewDailyButton);

        viewMonthlyButton.setText("<html>\n<h2 style=\"text-align: center\">View Monthly Appointments</h2>\n</html>");
        viewMonthlyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewMonthlyButtonActionPerformed(evt);
            }
        });
        jPanel2.add(viewMonthlyButton);

        viewOnetimeButton.setText("<html>\n<h2 style=\"text-align: center\">View Onetime Appointments</h2>\n</html>");
        viewOnetimeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewOnetimeButtonActionPerformed(evt);
            }
        });
        jPanel2.add(viewOnetimeButton);

        viewAllButton.setText("<html>\n<h2 style=\"text-align: center\">View All Appointments</h2>\n</html>");
        viewAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAllButtonActionPerformed(evt);
            }
        });
        jPanel2.add(viewAllButton);

        mainMenuButton.setText("<html>\n<h2 style=\"text-align: center\">Return to Main Menu</h2>\n</html>");
        mainMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenuButtonActionPerformed(evt);
            }
        });
        jPanel2.add(mainMenuButton);

        exitButton.setText("<html>\n<h2 style=\"text-align: center\">Exit Program</h2>\n</html>");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        jPanel2.add(exitButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.processWindowEvent(
                new WindowEvent(
                      this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_exitButtonActionPerformed

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

    private void viewDailyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDailyButtonActionPerformed
        try {
            dailyPrint();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ViewMenuGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_viewDailyButtonActionPerformed

    private void viewMonthlyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewMonthlyButtonActionPerformed
        try {
            monthlyPrint();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ViewMenuGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_viewMonthlyButtonActionPerformed

    private void viewOnetimeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewOnetimeButtonActionPerformed
        try {
            onetimePrint();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ViewMenuGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_viewOnetimeButtonActionPerformed

    private void viewAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAllButtonActionPerformed
        try {
            allPrint();
        } catch (IOException ex) {
            Logger.getLogger(ViewMenuGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_viewAllButtonActionPerformed

    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewMenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewMenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewMenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewMenuGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton mainMenuButton;
    private javax.swing.JTextArea menuText;
    private javax.swing.JButton viewAllButton;
    private javax.swing.JButton viewDailyButton;
    private javax.swing.JButton viewMonthlyButton;
    private javax.swing.JButton viewOnetimeButton;
    // End of variables declaration//GEN-END:variables
}
