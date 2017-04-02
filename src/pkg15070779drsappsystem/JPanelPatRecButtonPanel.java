
package pkg15070779drsappsystem;

import javax.swing.*;

public class JPanelPatRecButtonPanel extends JPanel {
    public static JPanelPatRecButtonPanel JPanButRecInst;
    
    private JPanelPatRecButtonPanel(){
        
        setBorder(BorderFactory.createEmptyBorder(100,0,0,0));
        //default has flow layout, so just add buttons
        JButton btnAllApps = new JButton("View All Appointments");
        JButton btnNewApp = new JButton("New Appointment");
        JButton btnAddNewDoctor = new JButton("Add New Doctor");
        add(btnAllApps);
        add(btnNewApp);
        add(btnAddNewDoctor);
    }
    
    //singleton object generation here
    public static JPanelPatRecButtonPanel getInstance(){
         if (JPanButRecInst == null){
            JPanButRecInst = new JPanelPatRecButtonPanel();
        }
  
        return JPanButRecInst;
    }
    
}
