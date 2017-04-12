
package pkg15070779drsappsystem.JPanels;

import pkg15070779drsappsystem.ActionListeners.ActListDispAddDocPan;
import javax.swing.*;
import pkg15070779drsappsystem.ActionListeners.ActListDispAmendAppPan;
import pkg15070779drsappsystem.ActionListeners.ActListDisplayPatientApps;
import pkg15070779drsappsystem.ActionListeners.ActListNewAppointment;

public class JPartPanelPatRecButPanSEC extends JPanel {
    public static JPartPanelPatRecButPanSEC JPanButRecInst;
    
    private JPartPanelPatRecButPanSEC(){
        
        setBorder(BorderFactory.createEmptyBorder(100,0,0,0));
        //default has flow layout, so just add buttons
        JButton btnAllApps = new JButton("View Patient's Appointments");
        btnAllApps.addActionListener(new ActListDisplayPatientApps());
        
        JButton btnAmendApp= new JButton("Amend an appointment");
        btnAllApps.addActionListener(new ActListDispAmendAppPan());
        
        JButton btnNewApp = new JButton("New Appointment");
        btnNewApp.addActionListener(new ActListNewAppointment());
        
        JButton btnAddNewDoctor = new JButton("Add New Doctor");
        btnAddNewDoctor.addActionListener(new ActListDispAddDocPan());
       
                
        add(btnAllApps);
        add(btnNewApp);
        add(btnAddNewDoctor);
    }
    
    //singleton object generation here
    public static JPartPanelPatRecButPanSEC getInstance(){
         if (JPanButRecInst == null){
            JPanButRecInst = new JPartPanelPatRecButPanSEC();
        }
  
        return JPanButRecInst;
    }
    
}
