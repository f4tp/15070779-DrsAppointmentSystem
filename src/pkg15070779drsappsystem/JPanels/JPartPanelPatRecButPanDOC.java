
package pkg15070779drsappsystem.JPanels;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import pkg15070779drsappsystem.ListenersAction.ActListDisplayJPanAddDocSec;
import pkg15070779drsappsystem.ListenersAction.ActListDisplayJPanPatientApps;
import pkg15070779drsappsystem.ListenersAction.ActListNewAppointment;

public class JPartPanelPatRecButPanDOC extends JPanel {
    public static JPartPanelPatRecButPanDOC JPanButDocInst;
    
    private JPartPanelPatRecButPanDOC(){
        setBorder(BorderFactory.createEmptyBorder(100,0,0,0));
        //default has flow layout, so just add buttons
        JButton btnAllApps = new JButton("View Patient's Appointments");
        btnAllApps.addActionListener(new ActListDisplayJPanPatientApps("Doc"));
        
        JButton btnAmendApp= new JButton("Amend an appointment");
        btnAmendApp.addActionListener(new ActListDisplayJPanPatientApps("Doc"));
     
        add(btnAllApps);
        add(btnAmendApp);

    }
    
      //singleton object generation here
    public static JPartPanelPatRecButPanDOC getInstance(){
         if (JPanButDocInst == null){
            JPanButDocInst = new JPartPanelPatRecButPanDOC();
        }
  
        return JPanButDocInst;
    }
    
}
