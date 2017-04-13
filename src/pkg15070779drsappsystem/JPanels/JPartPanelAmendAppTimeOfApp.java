
package pkg15070779drsappsystem.JPanels;

import java.time.LocalDateTime;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static pkg15070779drsappsystem.JPanels.JPartPanelAmendAppDateOfApp.cmbDateDay;

//plugs into JPane;AppAmendSecView - the amend an appointment JPanel which the secretary sees
// is the time panel part of it
public class JPartPanelAmendAppTimeOfApp extends JPanel {
    private static JPartPanelAmendAppTimeOfApp jpanTimeOfApp;
      JLabel lblTimeOfApp= new JLabel ("Time of appointment:");
    private static JComboBox cmbTimeHour= new JComboBox();
    private static JComboBox cmbTimeMin= new JComboBox();
    
    public JPartPanelAmendAppTimeOfApp(){
    add(lblTimeOfApp);
    add(cmbTimeHour);
    add(cmbTimeMin);
    }
    
    public static JPartPanelAmendAppTimeOfApp getInstance(){
        if(jpanTimeOfApp == null){
            jpanTimeOfApp = new JPartPanelAmendAppTimeOfApp();
        }
        return jpanTimeOfApp;
    }
    
    //sets the hour and minute to the string version of the appointment's time
    public static void updateFormWidgets(LocalDateTime appdatetime){
            cmbTimeHour.addItem(Integer.toString(appdatetime.getHour()));
            cmbTimeMin.addItem(Integer.toString(appdatetime.getMinute()));
        }
    
}