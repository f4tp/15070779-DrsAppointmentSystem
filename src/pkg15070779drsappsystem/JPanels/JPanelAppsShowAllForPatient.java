
package pkg15070779drsappsystem.JPanels;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelAppsShowAllForPatient extends JPanel {
    public static JPanelAppsShowAllForPatient JPanShowAvailAppsSingInst;
    
    JPanelSelDrComboFlow selDrInstHold = JPanelSelDrComboFlow.getInstance();
    JPanelAppsSelDateFlow setDateFrom = new JPanelAppsSelDateFlow("Select the dates FROM     ");
    JPanelAppsSelDateFlow setDateTo = new JPanelAppsSelDateFlow("Select the dates TO:      ");
    JButton btnSubmit = new JButton("Find Available Appointments");
    private JPanelAppsShowAllForPatient(){
       setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));
       setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
       add(selDrInstHold);
       add(setDateFrom);
       add(setDateTo);
       add(btnSubmit);
        
        
    }
    
    //singleton DP
    public static JPanelAppsShowAllForPatient getInstance(){
        if (JPanShowAvailAppsSingInst == null){
            JPanShowAvailAppsSingInst = new JPanelAppsShowAllForPatient();
        }
        
        return JPanShowAvailAppsSingInst;
    }
}
