
package pkg15070779drsappsystem.JPanels;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pkg15070779drsappsystem.AbstractClasses.MainAppointmentSchedule;


public class JPanelSelDataFlow extends JPanel {
    JLabel lblSeDateFrom= new JLabel("Select date FROM:     ");
    JComboBox cmbSelDateFromDay= new JComboBox();
    JComboBox cmbSelDateFromMonth= new JComboBox();
    JComboBox cmbSelDateFromYear= new JComboBox();
    
    JLabel lblSeDateToDay= new JLabel("Select date TO:     ");
    JComboBox cmbSelDateToDay= new JComboBox();
    JComboBox cmbSelDateToMonth= new JComboBox();
    JComboBox cmbSelDateToYear= new JComboBox();
    
    public JPanelSelDataFlow(){
         //setInitialiseWidgets();
         this.add(cmbSelDateToDay);
    }
    
    public String getFromDateDayString(){
      return  this.cmbSelDateFromDay.getSelectedItem().toString();
        
    }
    
     public String getFromDateMonthString(){
      return  this.cmbSelDateFromMonth.getSelectedItem().toString();
        
    }
     
      public String getFromDateYearString(){
      return  this.cmbSelDateFromYear.getSelectedItem().toString();
        
    }
      
      public String getToDateDayString(){
      return  this.cmbSelDateToDay.getSelectedItem().toString();
        
    }
    
     public String getToDateMonthString(){
      return  this.cmbSelDateToMonth.getSelectedItem().toString();
        
    }
     
   public String getToDateYearString(){
      return  this.cmbSelDateToYear.getSelectedItem().toString();
        
    }
    
    public void setInitialiseWidgets(){
        LocalDateTime currentDate = MainAppointmentSchedule.getDateToday();
        LocalDateTime PlusOneWeekDate = MainAppointmentSchedule.getDateToday().plusDays(7);
        List<LocalDateTime> listToPopComboAll = MainAppointmentSchedule.generateSelectDates();
        List<String> tempList = new ArrayList<>();
        
        for (LocalDateTime temp : listToPopComboAll){
            String tempStr = Integer.toString(temp.getDayOfMonth());   
             tempList.add(tempStr);
         }
        
         this.cmbSelDateFromDay.setModel(new DefaultComboBoxModel(tempList.toArray()));
         this.cmbSelDateToDay.setModel(new DefaultComboBoxModel(tempList.toArray()));
        
         for (LocalDateTime temp : listToPopComboAll){
            String tempStr = (temp.getMonth().toString());
             tempList.add(tempStr);
         }
        
         this.cmbSelDateFromMonth.setModel(new DefaultComboBoxModel(tempList.toArray()));
         this.cmbSelDateToMonth.setModel(new DefaultComboBoxModel(tempList.toArray()));
         
          for (LocalDateTime temp : listToPopComboAll){
            String tempStr = Integer.toString(temp.getYear());
             tempList.add(tempStr);
         }
        
         this.cmbSelDateFromYear.setModel(new DefaultComboBoxModel(tempList.toArray()));
         this.cmbSelDateToYear.setModel(new DefaultComboBoxModel(tempList.toArray()));
 
    }
    
}
