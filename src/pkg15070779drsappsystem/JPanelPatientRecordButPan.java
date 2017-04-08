
package pkg15070779drsappsystem;

import javax.swing.*;

public class JPanelPatientRecordButPan extends JPanel {
    public static JPanelPatientRecordButPan JPanButRecInst;
    
    private JPanelPatientRecordButPan(){
        
        setBorder(BorderFactory.createEmptyBorder(100,0,0,0));
        //default has flow layout, so just add buttons
        JButton btnAllApps = new JButton("View All Appointments");
        JButton btnNewApp = new JButton("New Appointment");
        JButton btnAddNewDoctor = new JButton("Add New Doctor");
        btnAddNewDoctor.addActionListener(new ActListDispAddDocPan());
       
                
        add(btnAllApps);
        add(btnNewApp);
        add(btnAddNewDoctor);
    }
    
    //singleton object generation here
    public static JPanelPatientRecordButPan getInstance(){
         if (JPanButRecInst == null){
            JPanButRecInst = new JPanelPatientRecordButPan();
        }
  
        return JPanButRecInst;
    }
    
}