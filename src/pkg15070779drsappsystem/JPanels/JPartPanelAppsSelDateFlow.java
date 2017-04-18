
package pkg15070779drsappsystem.JPanels;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pkg15070779drsappsystem.MainAbstractClasses.SchedulingAbstract;


public class JPartPanelAppsSelDateFlow extends JPanel {
    JLabel lblSeDateFromTo= new JLabel("");
    JComboBox cmbSelDateFromToDay= new JComboBox((SchedulingAbstract.getDaysArr()));
   
    JComboBox cmbSelDateFromToMonth= new JComboBox(SchedulingAbstract.getMonthsArr());
    JComboBox cmbSelDateFromToYear= new JComboBox(SchedulingAbstract.getYearArr());
    
   //JLabel lblSeDateToDay= new JLabel("Select date TO:     ");
  // JComboBox cmbSelDateToDay= new JComboBox(SchedulingAbstract.getDaysArr());
  // JComboBox cmbSelDateToMonth= new JComboBox(SchedulingAbstract.getMonthsArr());
   // JComboBox cmbSelDateToYear= new JComboBox(SchedulingAbstract.getYearArr());
    
    public JPartPanelAppsSelDateFlow(String titleForPanel){
        this.lblSeDateFromTo.setText(titleForPanel);
        this.add(lblSeDateFromTo);
        this.add(cmbSelDateFromToDay);
        this.add(cmbSelDateFromToMonth);
        this.add(cmbSelDateFromToYear);

    }
    
    public String getDateDayString(){
      return  this.cmbSelDateFromToDay.getSelectedItem().toString();
        
    }
    
     public String geDateMonthString(){
      return  this.cmbSelDateFromToMonth.getSelectedItem().toString();
        
    }
     
      public String getDateYearString(){
      return  this.cmbSelDateFromToYear.getSelectedItem().toString();
        
    }
      
  //    public String getToDateDayString(){
   //   return  this.cmbSelDateToDay.getSelectedItem().toString();
        
  //  }
    
    // public String getToDateMonthString(){
   //   return  this.cmbSelDateToMonth.getSelectedItem().toString();
        
    //}
     
  // public String getToDateYearString(){
   //   return  this.cmbSelDateToYear.getSelectedItem().toString();
        
    //}
   
  
    
   
   //old routine calculates all dates for 1 year without saturdays & sundays
    public void setInitialiseWidgetsOld(){
        LocalDateTime currentDate = SchedulingAbstract.getDateToday();
        LocalDateTime PlusOneWeekDate = SchedulingAbstract.getDateToday().plusDays(7);
        List<LocalDateTime> listToPopComboAll = SchedulingAbstract.generateSelectDates();
        List<String> tempList = new ArrayList<>();
        
        for (LocalDateTime temp : listToPopComboAll){
            String tempStr = Integer.toString(temp.getDayOfMonth());   
             tempList.add(tempStr);
         }
        
         this.cmbSelDateFromToDay.setModel(new DefaultComboBoxModel(tempList.toArray()));
         //this.cmbSelDateToDay.setModel(new DefaultComboBoxModel(tempList.toArray()));
        
         for (LocalDateTime temp : listToPopComboAll){
            String tempStr = (temp.getMonth().toString());
             tempList.add(tempStr);
         }
        
         this.cmbSelDateFromToMonth.setModel(new DefaultComboBoxModel(tempList.toArray()));
         //this.cmbSelDateToMonth.setModel(new DefaultComboBoxModel(tempList.toArray()));
         
          for (LocalDateTime temp : listToPopComboAll){
            String tempStr = Integer.toString(temp.getYear());
             tempList.add(tempStr);
         }
        
         this.cmbSelDateFromToYear.setModel(new DefaultComboBoxModel(tempList.toArray()));
         //this.cmbSelDateToYear.setModel(new DefaultComboBoxModel(tempList.toArray()));
 
    }
    
}
