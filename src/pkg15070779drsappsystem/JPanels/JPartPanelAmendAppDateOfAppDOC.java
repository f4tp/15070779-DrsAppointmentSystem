
package pkg15070779drsappsystem.JPanels;

import java.time.LocalDateTime;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pkg15070779drsappsystem.ItemListeners.ItemListAmendAppFormChangedDateAffected;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsScheduling;

public class JPartPanelAmendAppDateOfAppDOC extends JPanel {
      public static JPartPanelAmendAppDateOfAppDOC DatePanSingInst;
            JLabel lblDateOfApp= new JLabel ("Date of appointment:");
            private  JComboBox cmbDateDay = new JComboBox(MainAbsScheduling.getDaysArr());
            private  JComboBox cmbDateMonth = new JComboBox(MainAbsScheduling.getMonthsArr());
            private  JComboBox cmbDateYear = new JComboBox(MainAbsScheduling.getYearArr());
            
            public JPartPanelAmendAppDateOfAppDOC(){
                  //item listeners just set the form changed status to true so the amend routine knows to update and not
            //display a message sayign nothing has changed
            cmbDateDay.addItemListener(new ItemListAmendAppFormChangedDateAffected("Doc"));
            cmbDateMonth.addItemListener(new ItemListAmendAppFormChangedDateAffected("Doc"));
            cmbDateYear.addItemListener(new ItemListAmendAppFormChangedDateAffected("Doc"));
            
            add(lblDateOfApp);
            add(cmbDateDay);
            add(cmbDateMonth);
            add(cmbDateYear);
            }
            
             public static JPartPanelAmendAppDateOfAppDOC getInstance(){
            if (DatePanSingInst == null) {
                DatePanSingInst = new JPartPanelAmendAppDateOfAppDOC();
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
