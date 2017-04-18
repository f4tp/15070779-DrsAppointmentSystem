
package pkg15070779drsappsystem.JPanels;

import java.time.LocalDateTime;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import static pkg15070779drsappsystem.JPanels.JPanelAppsShowAvaialble.JPanShowAvailAppsSingInst;
import pkg15070779drsappsystem.ListenersAction.ActListMarkAsDispatched;
import pkg15070779drsappsystem.ListenersAction.ActListPerfSearchAllAvailAppointments;
import pkg15070779drsappsystem.ListenersAction.ActListSearchPresPHARM;
import pkg15070779drsappsystem.ListenersItem.ItemListenerPresSelectedChanged;
import pkg15070779drsappsystem.MainAbstractClasses.SchedulingAbstract;

public class JPanelPresDisplayFromTo extends JPanel {
    public static JPanelPresDisplayFromTo JPanShowPresSingInst;
    
    String[] presStatus = { "Dispatched", "Not Yet Dispatched" };
    JComboBox selPresStatus = new JComboBox(presStatus);
    
    JPartPanelAppsSelDateFlow setDateFrom = new JPartPanelAppsSelDateFlow("Select the dates FROM     ");
    JPartPanelAppsSelDateFlow setDateTo = new JPartPanelAppsSelDateFlow("Select the dates TO:      ");
    
    JButton btnSubmit = new JButton("Find Available Appointments");
    JComboBox cmbFoundPrescriptions = new JComboBox();
    JButton btnMarkAsDisp= new JButton("Mark Selected prescription as DISPATCHED");


    public JPanelPresDisplayFromTo(){
        
    
            
      setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));
       setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
       
       //btnSubmit.addActionListener(new ActListPerfSearchAllAvailAppointments(setDateFrom, setDateTo ));
       
       //called with the JPanel instances - 2 of them (1 for from, 1 for to dates), and teh combobox from here to check the status
        btnSubmit.addActionListener(new ActListSearchPresPHARM(setDateFrom, setDateTo, selPresStatus ));
      cmbFoundPrescriptions.addItemListener(new ItemListenerPresSelectedChanged(cmbFoundPrescriptions));
        btnMarkAsDisp.addActionListener(new ActListMarkAsDispatched(cmbFoundPrescriptions, btnSubmit));
        
       //adds the components
      add(selPresStatus);
       add(setDateFrom);
       add(setDateTo);
       add(btnSubmit);
   
      add(btnSubmit);
         add(cmbFoundPrescriptions);
         add(btnMarkAsDisp);
       
    }
 //singleton DP
    public static JPanelPresDisplayFromTo getInstance(){
        if (JPanShowPresSingInst == null){
            JPanShowPresSingInst = new JPanelPresDisplayFromTo();
        }
        
        return JPanShowPresSingInst;
    }
    
    
    //in MainPrescription, a list of prescription IDs is generated via the actionlistener, - usually ones that haven't
    //been makrked as dispatched this list populates the combobox
    
    public static void updateFoundPrescriptions(List<String> foundappsin){
        JPanShowPresSingInst.cmbFoundPrescriptions.removeAllItems();
        
        
        for(String temp : foundappsin ){
            JPanShowPresSingInst.cmbFoundPrescriptions.addItem(temp);
        }
     }
}