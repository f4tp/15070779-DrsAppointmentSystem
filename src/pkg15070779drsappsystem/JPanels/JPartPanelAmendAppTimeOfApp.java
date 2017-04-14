
package pkg15070779drsappsystem.JPanels;

import java.time.LocalDateTime;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pkg15070779drsappsystem.ItemListeners.ItemListAmendAppFormChangedDateAffected;
//import static pkg15070779drsappsystem.JPanels.JPartPanelAmendAppDateOfApp.cmbDateDay;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsScheduling;

//plugs into JPane;AppAmendSecView - the amend an appointment JPanel which the secretary sees
// is the time panel part of it
public class JPartPanelAmendAppTimeOfApp extends JPanel {
    private static JPartPanelAmendAppTimeOfApp jpanTimeOfApp;
      JLabel lblTimeOfApp= new JLabel ("Time of appointment:");
    private JComboBox cmbTime= new JComboBox(MainAbsScheduling.getTimesArr());
    //private static JComboBox cmbTimeMin= new JComboBox();
    
    public JPartPanelAmendAppTimeOfApp(){
    
        cmbTime.addItemListener(new ItemListAmendAppFormChangedDateAffected());
        add(lblTimeOfApp);
    add(cmbTime);
    //add(cmbTimeMin);
    }
    
    public static JPartPanelAmendAppTimeOfApp getInstance(){
        if(jpanTimeOfApp == null){
            jpanTimeOfApp = new JPartPanelAmendAppTimeOfApp();
        }
        return jpanTimeOfApp;
    }
    
    //sets the hour and minute to the string version of the appointment's time
    public void updateFormWidgets(LocalDateTime appdatetime){
  
            cmbTime.setSelectedItem(MainAbsScheduling.getConvDateTimeToStringHourAndMin(appdatetime));

        }
    
    public JComboBox getJComboTime(){
        return cmbTime;
    }
    
}
