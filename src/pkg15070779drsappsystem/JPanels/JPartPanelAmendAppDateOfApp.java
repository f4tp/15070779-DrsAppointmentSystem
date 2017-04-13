
package pkg15070779drsappsystem.JPanels;

import java.time.LocalDateTime;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsScheduling;


//plugs into JPanelAppAmendSecView
//is teh date of appointment panel
public class JPartPanelAmendAppDateOfApp extends JPanel {
            public static JPartPanelAmendAppDateOfApp DatePanSingInst;
            JLabel lblDateOfApp= new JLabel ("Date of appointment:");
            public static JComboBox cmbDateDay = new JComboBox(MainAbsScheduling.getDaysArr());
            public static JComboBox cmbDateMonth = new JComboBox(MainAbsScheduling.getMonthsArr());
            public static JComboBox cmbDateYear = new JComboBox(MainAbsScheduling.getYearArr());
        
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
  
        
        cmbDateDay.setSelectedItem(Integer.toString(appdatetime.getDayOfMonth()));
        
        //editing teh month as it comes back for example JANUARY and needs to be Jan
        
        //gets teh first letter
        String editedMonthfirst = appdatetime.getMonth().toString().substring(0, 1).toUpperCase();
        
        //gets the next twon letters and makes them lower case
        String editedMonth = appdatetime.getMonth().toString().substring(1, 3).toLowerCase();
        
        //gets the first letter
        String editedMonthFinal = editedMonthfirst + editedMonth;
        
        System.out.println(appdatetime.getMonth());
        System.out.println(editedMonthFinal);
        cmbDateMonth.setSelectedItem(editedMonthFinal);
        
        
        
        cmbDateYear.setSelectedItem(Integer.toString(appdatetime.getYear()));
        }
    }
    

