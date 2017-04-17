
package pkg15070779drsappsystem.JPanels;

import java.time.LocalDateTime;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsScheduling;
import pkg15070779drsappsystem.ListenersAction.ActListPerfSearchAllAvailAppointments;


public class JPanelAppsShowAvaialble extends JPanel {
    public static JPanelAppsShowAvaialble JPanShowAvailAppsSingInst;
    
    JPartPanelSelDrComboFlow selDrInstHold = JPartPanelSelDrComboFlow.getInstance();
    JPartPanelAppsSelDateFlow setDateFrom = new JPartPanelAppsSelDateFlow("Select the dates FROM     ");
    JPartPanelAppsSelDateFlow setDateTo = new JPartPanelAppsSelDateFlow("Select the dates TO:      ");
    JButton btnSubmit = new JButton("Find Available Appointments");
    JComboBox cmbFoundAppointments = new JComboBox();
    
    private JPanelAppsShowAvaialble(){
       setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));
       setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
       
       btnSubmit.addActionListener(new ActListPerfSearchAllAvailAppointments(setDateFrom, setDateTo ));
     
      
       //adds the components
       add(selDrInstHold);
       add(setDateFrom);
       add(setDateTo);
       add(btnSubmit);
       add(cmbFoundAppointments);
        
       //@@@@' NTD not working, need to solve getting the instance of this Jcombo
         //sets the selected item in the FROM combo box at today's date
       setDateFrom.cmbSelDateFromToDay.setSelectedItem(MainAbsScheduling.getDateToday().getDayOfMonth());
       setDateFrom.cmbSelDateFromToMonth.setSelectedItem(MainAbsScheduling.getDateToday().getMonth());
        
    }
    
    //singleton DP
    public static JPanelAppsShowAvaialble getInstance(){
        if (JPanShowAvailAppsSingInst == null){
            JPanShowAvailAppsSingInst = new JPanelAppsShowAvaialble();
        }
        
        return JPanShowAvailAppsSingInst;
    }
    
    
    //
    public static void updateFoundAppointments(List<LocalDateTime> foundappsin){
        JPanShowAvailAppsSingInst.cmbFoundAppointments.removeAllItems();
        
        
        for(LocalDateTime temp : foundappsin ){
            JPanShowAvailAppsSingInst.cmbFoundAppointments.addItem(temp);
        }
 
    }
}
