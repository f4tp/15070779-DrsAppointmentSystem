//NOTE - this class is set up properly - no static components, use to help sort teh rest of the static components
//classes involved are this one, JPanelAppAmendSecView, ActListAmendAppointment, JPartPanelAmendAppTimeOfApp
//components involved are teh three comboboxes
package pkg15070779drsappsystem.JPanels;

import java.time.LocalDateTime;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pkg15070779drsappsystem.ListenersItem.ItemListAmendAppFormChangedDateAffected;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsScheduling;


//plugs into JPanelAppAmendSecView
//is the date of appointment panel
public class JPartPanelAmendAppDateOfAppSEC extends JPanel {
            public static JPartPanelAmendAppDateOfAppSEC DatePanSingInst;
            JLabel lblDateOfApp= new JLabel ("Date of appointment:");
            private  JComboBox cmbDateDay = new JComboBox(MainAbsScheduling.getDaysArr());
            private  JComboBox cmbDateMonth = new JComboBox(MainAbsScheduling.getMonthsArr());
            private  JComboBox cmbDateYear = new JComboBox(MainAbsScheduling.getYearArr());
        
        public JPartPanelAmendAppDateOfAppSEC() {
            
            //item listeners just set the form changed status to true so the amend routine knows to update and not
            //display a message sayign nothing has changed
            cmbDateDay.addItemListener(new ItemListAmendAppFormChangedDateAffected("Sec"));
            cmbDateMonth.addItemListener(new ItemListAmendAppFormChangedDateAffected("Sec"));
            cmbDateYear.addItemListener(new ItemListAmendAppFormChangedDateAffected("Sec"));
            
            add(lblDateOfApp);
            add(cmbDateDay);
            add(cmbDateMonth);
            add(cmbDateYear);
        }
        
        public static JPartPanelAmendAppDateOfAppSEC getInstance(){
            if (DatePanSingInst == null) {
                DatePanSingInst = new JPartPanelAmendAppDateOfAppSEC();
            }
            
            return DatePanSingInst;
        }
        
        //sets the day, month and year to the string version of the appointment's date
        public void updateFormWidgets(LocalDateTime appdatetime){
  
        
        //cmbDateDay.setSelectedItem(Integer.toString(appdatetime.getDayOfMonth()));
        cmbDateDay.setSelectedItem(MainAbsScheduling.getConvDateTimeToStringDay(appdatetime));
        //editing the month as it comes back for example JANUARY and needs to be Jan
        
        //gets teh first letter
       // String editedMonthfirst = appdatetime.getMonth().toString().substring(0, 1).toUpperCase();
        
        //gets the next twon letters and makes them lower case
       // String editedMonth = appdatetime.getMonth().toString().substring(1, 3).toLowerCase();
        
        //gets the first letter
       // String editedMonthFinal = editedMonthfirst + editedMonth;
        
        //System.out.println(appdatetime.getMonth());
       // System.out.println(editedMonthFinal);
        //cmbDateMonth.setSelectedItem(editedMonthFinal);
        cmbDateMonth.setSelectedItem(MainAbsScheduling.getConvDateTimeToStringMonth(appdatetime));
        
        
        //cmbDateYear.setSelectedItem(Integer.toString(appdatetime.getYear()));
        cmbDateYear.setSelectedItem(MainAbsScheduling.getConvDateTimeToStringYear(appdatetime));
        }
        
        public JComboBox getJComboDay(){
            return cmbDateDay;
        }
        
        public JComboBox getJComboMonth(){
            return cmbDateMonth;
        }
        
        public JComboBox getJComboYear(){
            return cmbDateYear;
        }
    }
    

