
package pkg15070779drsappsystem.JPanels;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelShowAvailApps extends JPanel {
    public static JPanelShowAvailApps JPanShowAvailAppsSingInst;
    
    JPanelSelDrComboFlow selDrInstHold = JPanelSelDrComboFlow.getInstance();
    JPanelSelDateFlow setDateFrom = new JPanelSelDateFlow("Select the dates FROM     ");
    JPanelSelDateFlow setDateTo = new JPanelSelDateFlow("Select the dates TO:      ");
    JButton btnSubmit = new JButton("Find Available Appointments");
    private JPanelShowAvailApps(){
       setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));
       setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
       add(selDrInstHold);
       add(setDateFrom);
       add(setDateTo);
       add(btnSubmit);
        
        
    }
    
    //singleton DP
    public static JPanelShowAvailApps getInstance(){
        if (JPanShowAvailAppsSingInst == null){
            JPanShowAvailAppsSingInst = new JPanelShowAvailApps();
        }
        
        return JPanShowAvailAppsSingInst;
    }
}
