
package pkg15070779drsappsystem.JPanels;

import java.time.LocalDateTime;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


//plugs into JPanelAppAmendSecView
//is teh date of appointment panel
public class JPartPanelAmendAppDateOfApp extends JPanel {
            public static JPartPanelAmendAppDateOfApp DatePanSingInst;
            JLabel lblDateOfApp= new JLabel ("Date of appointment:");
            public static JComboBox cmbDateDay = new JComboBox();
            public static JComboBox cmbDateMonth = new JComboBox();
            public static JComboBox cmbDateYear = new JComboBox();
        
        public JPartPanelAmendAppDateOfApp() {
            
            add(lblDateOfApp);
            add(cmbDateDay);
            add(cmbDateMonth);
            add(cmbDateYear);
        }
        
        public static JPartPanelAmendAppDateOfApp getInstance(){
            if (DatePanSingInst == null) {
                DatePanSingInst = new JPartPanelAmendAppDateOfApp();
            }
            
            return DatePanSingInst;
        }
        
        //sets the day, month and year to the string version of the appointment's date
        public static void updateFormWidgets(LocalDateTime appdatetime){
     
        cmbDateDay.addItem(Integer.toString(appdatetime.getDayOfMonth()));
        cmbDateMonth.addItem(appdatetime.getMonth());
        cmbDateYear.addItem(Integer.toString(appdatetime.getYear()));
        }
    }
    

