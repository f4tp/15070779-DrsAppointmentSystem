
package pkg15070779drsappsystem.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.JComboBox;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsScheduling;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsSystemUserComponent;
import pkg15070779drsappsystem.JPanels.JPanelReportsDrsApps;
import pkg15070779drsappsystem.JPanels.JPartPanelTextAreaMonthReports;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsAppointmentComponent;
import pkg15070779drsappsystem.MainClasses.MainAppointment;
import pkg15070779drsappsystem.MainClasses.MainDoctor;

public class ActListRunReport implements ActionListener {
    private String typeOfReport;
    private String monthFrom;
    private String yearFrom;
    private JComboBox cmbMonth;
    private JComboBox cmbYear;
    private JComboBox cmbDrIn;
    private JComboBox cmbReportType;
    LocalDateTime ldtFirstOfMonthToSearch;
    public ActListRunReport(String typeofreport, JComboBox month, JComboBox year){
        this.typeOfReport = typeofreport;
        this.cmbMonth = month;
        this.cmbYear = year;
    }
    
    public ActListRunReport(String typeofreport, JComboBox month, JComboBox year, JComboBox reporttype){
        this.typeOfReport = typeofreport;
        this.cmbMonth = month;
        this.cmbYear = year;
        this.cmbReportType = reporttype;
        
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println(cmbMonth.getSelectedItem().toString());
        
        //will hold an appointment, resolved by the appointment ID, currently worked on appointment
        //object composition
         MainAppointment currentAppInst; 
         
         //generate a full date, set it to the first of the month at 00:00, use this to see all appointments from the first of the month to the last
         ldtFirstOfMonthToSearch = MainAbsScheduling.getConvStringToDateTime("01"+this.cmbMonth.getSelectedItem().toString()+this.cmbYear.getSelectedItem().toString()+"0000");
     
        //the type of report to run is based on the text in the label of the JPanel, this determines which data is to
        //be used... the same place will be populated with the details (the abstract jpanel)
        if (typeOfReport == "Report all Appointments for the month of..."){
            
             
              //generate a full date, set it to the first
              
              if (cmbReportType.getSelectedItem().toString() == "All Appointments"){
                   String textToDisplay ="";
                 for(String temp: MainAppointment.getAppKeyList()){
                     currentAppInst = (MainAppointment) MainAbsAppointmentComponent.getAppointment(temp);
                        if(currentAppInst.getAPPDateAndTime().getMonth() == ldtFirstOfMonthToSearch.getMonth() )
                         textToDisplay += currentAppInst.toString() + " | ";
                  }
                 
                  // populate the textarea on the Secretary JFrame
                    JPartPanelTextAreaMonthReports singInst = JPartPanelTextAreaMonthReports.getInstance();
                    singInst.setJtextArea(textToDisplay);
              }
              
               if (cmbReportType.getSelectedItem().toString() == "Attended"){
                   String textToDisplay ="";
                 for(String temp: MainAppointment.getAppKeyList()){
                     currentAppInst = (MainAppointment) MainAbsAppointmentComponent.getAppointment(temp);
                        if(currentAppInst.getAPPDateAndTime().getMonth() == ldtFirstOfMonthToSearch.getMonth() ){
                            if(currentAppInst.getAttended() == true){
                                textToDisplay += currentAppInst.toString() + " | ";
                            }
                            
                        }
                         
                  }
                 
                  // populate the textarea on the Secretary JFrame
                    JPartPanelTextAreaMonthReports singInst = JPartPanelTextAreaMonthReports.getInstance();
                    singInst.setJtextArea(textToDisplay);
              }
               
                if (cmbReportType.getSelectedItem().toString() == "Cancelled"){
                    String textToDisplay ="";
                 for(String temp: MainAppointment.getAppKeyList()){
                     currentAppInst = (MainAppointment) MainAbsAppointmentComponent.getAppointment(temp);
                        if(currentAppInst.getAPPDateAndTime().getMonth() == ldtFirstOfMonthToSearch.getMonth() ){
                            if(currentAppInst.getCancelled() == true){
                                textToDisplay += currentAppInst.toString() + " | ";
                            }
                            
                        }
                         
                  }
                 
                  // populate the textarea on the Secretary JFrame
                    JPartPanelTextAreaMonthReports singInst = JPartPanelTextAreaMonthReports.getInstance();
                    singInst.setJtextArea(textToDisplay);
              }
                
                 if (cmbReportType.getSelectedItem().toString() == "Missed"){
                     
                       String textToDisplay ="";
                 for(String temp: MainAppointment.getAppKeyList()){
                     currentAppInst = (MainAppointment) MainAbsAppointmentComponent.getAppointment(temp);
                        if(currentAppInst.getAPPDateAndTime().getMonth() == ldtFirstOfMonthToSearch.getMonth() ){
                            if(currentAppInst.getMissed() == true){
                                textToDisplay += currentAppInst.toString() + " | ";
                            }
                            
                        }
                         
                  }
                 
                  // populate the textarea on the Secretary JFrame
                    JPartPanelTextAreaMonthReports singInst = JPartPanelTextAreaMonthReports.getInstance();
                    singInst.setJtextArea(textToDisplay);
                  
              }
         
            
        }
        
        
        //report for Doctor's monthly appointments
        else if (typeOfReport == "Report Doctor's appointments for the month of..."){
            
 
            
             // set the currentdoctor as this doctor - keeping wit the whole platform - will be used to call the method next
             
             //NOT NEEDED IN THIS CLASS NOW - OBJECT COMP DONE INSTEAD
           MainDoctor.currentDoctor = (MainDoctor) MainAbsSystemUserComponent.getSystemUserComponent(JPanelReportsDrsApps.getInstance().getSelectedDr());
            
           
           MainDoctor currentDoctorInst = (MainDoctor) MainAbsSystemUserComponent.getSystemUserComponent(JPanelReportsDrsApps.getInstance().getSelectedDr());
           
            
           // System.out.println(MainDoctor.currentDoctor.getUserName());
            //call the correct method in the MainDoctor class, which checks a doctor's taken appointments
            //called by passing a doctor and a localdate time to use to see appointments for
            //held in a list
           // List<LocalDateTime> tempHolder = MainDoctor.getDocsMonthlySetAppointments(MainDoctor.currentDoctor, ldtFirstOfMonthToSearch);
            //String textToDisplay ="";
           // for(LocalDateTime temp : tempHolder){
               // textToDisplay += temp.toString();
           // }
            String textToDisplay ="";
            for(String temp: currentDoctorInst.getAppKeyList()){
                currentAppInst = (MainAppointment) MainAbsAppointmentComponent.getAppointment(temp);
                
                if(currentAppInst.getAPPDateAndTime().getMonth() == ldtFirstOfMonthToSearch.getMonth() )
                textToDisplay += currentAppInst.toString() + " | ";
                
            }
            
            
            
          // populate the textarea on the Secretary JFrame
          JPartPanelTextAreaMonthReports singInst = JPartPanelTextAreaMonthReports.getInstance();
            singInst.setJtextArea(textToDisplay);
        }
        
        else if (typeOfReport == "Report all prescriptions issued for the month of..."){
            
        }
        
    }
    
}
