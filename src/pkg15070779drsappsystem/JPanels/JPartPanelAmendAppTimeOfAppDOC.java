
package pkg15070779drsappsystem.JPanels;

import java.time.LocalDateTime;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pkg15070779drsappsystem.ListenersItem.ItemListAmendAppFormChangedDateAffected;
import pkg15070779drsappsystem.MainAbstractClasses.SchedulingAbstract;

public class JPartPanelAmendAppTimeOfAppDOC extends JPanel {
    
      private static JPartPanelAmendAppTimeOfAppDOC jpanTimeOfApp;
      JLabel lblTimeOfApp= new JLabel ("Time of appointment:");
    private JComboBox cmbTime= new JComboBox(SchedulingAbstract.getTimesArr());
    //private static JComboBox cmbTimeMin= new JComboBox();
    
    public JPartPanelAmendAppTimeOfAppDOC(){
        cmbTime.addItemListener(new ItemListAmendAppFormChangedDateAffected("Sec"));
    add(lblTimeOfApp);
    add(cmbTime);
    //add(cmbTimeMin);
    }
    
    public static JPartPanelAmendAppTimeOfAppDOC getInstance(){
        if(jpanTimeOfApp == null){
            jpanTimeOfApp = new JPartPanelAmendAppTimeOfAppDOC();
        }
        return jpanTimeOfApp;
    }
    
      //sets the hour and minute to the string version of the appointment's time
    public void updateFormWidgets(LocalDateTime appdatetime){
  
            cmbTime.setSelectedItem(SchedulingAbstract.getConvDateTimeToStringHourAndMin(appdatetime));

        }
    
    public JComboBox getJComboTime(){
        return cmbTime;
    }
    
}
