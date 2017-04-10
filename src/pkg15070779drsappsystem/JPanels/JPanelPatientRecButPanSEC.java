
package pkg15070779drsappsystem.JPanels;

import pkg15070779drsappsystem.ActionListeners.ActListDispAddDocPan;
import javax.swing.*;
import pkg15070779drsappsystem.ActionListeners.ActListDisplayPatientApps;
import pkg15070779drsappsystem.ActionListeners.ActListNewAppointment;

public class JPanelPatientRecButPanSEC extends JPanel {
    public static JPanelPatientRecButPanSEC JPanButRecInst;
    
    private JPanelPatientRecButPanSEC(){
        
        setBorder(BorderFactory.createEmptyBorder(100,0,0,0));
        //default has flow layout, so just add buttons
        JButton btnAllApps = new JButton("View All Appointments");
        btnAllApps.addActionListener(new ActListDisplayPatientApps());
        
        
        
        JButton btnNewApp = new JButton("New Appointment");
        btnNewApp.addActionListener(new ActListNewAppointment());
        
        JButton btnAddNewDoctor = new JButton("Add New Doctor");
        btnAddNewDoctor.addActionListener(new ActListDispAddDocPan());
       
                
        add(btnAllApps);
        add(btnNewApp);
        add(btnAddNewDoctor);
    }
    
    //singleton object generation here
    public static JPanelPatientRecButPanSEC getInstance(){
         if (JPanButRecInst == null){
            JPanButRecInst = new JPanelPatientRecButPanSEC();
        }
  
        return JPanButRecInst;
    }
    
}
