
package pkg15070779drsappsystem.JPanels;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import pkg15070779drsappsystem.ActionListeners.ActListAddAppointment;

import pkg15070779drsappsystem.ActionListeners.ActListReturnPatientRec;

public class JPanelNewAppButPan extends JPanel {
    public static JPanelNewAppButPan JPanNewAppButSingInst;
    
    private JPanelNewAppButPan(){
        
         setBorder(BorderFactory.createEmptyBorder(100,0,0,0));
        //default has flow layout, so just add buttons
        
        JButton btnCheckDate = new JButton("Cancel");
       //action listener
       btnCheckDate.addActionListener(new ActListReturnPatientRec("Sec"));
       JButton btnaddAppointment = new JButton("Create the appoinment");
       btnaddAppointment.addActionListener(new ActListAddAppointment());
       //JPanelNewAppointment.JTFUserName;
       
       
       add(btnCheckDate);
       add(btnaddAppointment);
        
    }
    
    //singleton design pattern
    public static JPanelNewAppButPan getInstance(){
        if (JPanNewAppButSingInst == null) {
            JPanNewAppButSingInst = new JPanelNewAppButPan();
        }
        
        return JPanNewAppButSingInst;
    }
}
