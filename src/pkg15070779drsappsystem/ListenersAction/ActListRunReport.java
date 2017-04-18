
package pkg15070779drsappsystem.ListenersAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.JComboBox;
import pkg15070779drsappsystem.MainAbstractClasses.SchedulingAbstract;
import pkg15070779drsappsystem.MainAbstractClasses.SystemUserComponent;
import pkg15070779drsappsystem.JPanels.JPanelReportsDrsApps;
import pkg15070779drsappsystem.JPanels.JPartPanelTextAreaMonthReports;
import pkg15070779drsappsystem.MainAbstractClasses.AppointmentComponent;
import pkg15070779drsappsystem.MainAbstractClasses.PrescriptionComponent;
import pkg15070779drsappsystem.MainClasses.Appointment;
import pkg15070779drsappsystem.MainClasses.SysUserDoctor;
import pkg15070779drsappsystem.MainClasses.Prescription;

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
         
        //will hold an appointment, resolved by the appointment ID, currently worked on appointment
        //object composition
         Appointment currentAppInst; 
         Prescription currentPresInst;
         
         //generate a full date, set it to the first of the month at 00:00, use this to see all appointments from the first of the month to the last
         ldtFirstOfMonthToSearch = SchedulingAbstract.getConvStringToDateTime("01"+this.cmbMonth.getSelectedItem().toString()+this.cmbYear.getSelectedItem().toString()+"0000");
     
        //the type of report to run is based on the text in the label of the JPanel, this determines which data is to
        //be used... the same place will be populated with the details (the abstract jpanel)
        if (typeOfReport == "Report all Appointments for the month of..."){
            
             
              //generate a full date, set it to the first
              
              if (cmbReportType.getSelectedItem().toString() == "All Appointments"){
                   String textToDisplay ="";
                 for(String temp: Appointment.getAppKeyList()){
                     currentAppInst = (Appointment) AppointmentComponent.getAppointment(temp);
                        if(currentAppInst.getAPPDateAndTime().getMonth() == ldtFirstOfMonthToSearch.getMonth() )
                         textToDisplay += currentAppInst.toString() +currentAppInst.getAllPresDetailsForAppAsString();
                  }
                 
                  // populate the textarea on the Secretary JFrame
                    JPartPanelTextAreaMonthReports singInst = JPartPanelTextAreaMonthReports.getInstance();
                    singInst.setJtextArea(textToDisplay);
              }
              
               if (cmbReportType.getSelectedItem().toString() == "Attended"){
                   String textToDisplay ="";
                 for(String temp: Appointment.getAppKeyList()){
                     currentAppInst = (Appointment) AppointmentComponent.getAppointment(temp);
                        if(currentAppInst.getAPPDateAndTime().getMonth() == ldtFirstOfMonthToSearch.getMonth() ){
                            if(currentAppInst.getAttended() == true){
                                textToDisplay += currentAppInst.toString() + currentAppInst.getAllPresDetailsForAppAsString();
                            }
                            
                        }
                         
                  }
                 
                  // populate the textarea on the Secretary JFrame
                    JPartPanelTextAreaMonthReports singInst = JPartPanelTextAreaMonthReports.getInstance();
                    singInst.setJtextArea(textToDisplay);
              }
               
                if (cmbReportType.getSelectedItem().toString() == "Cancelled"){
                    String textToDisplay ="";
                 for(String temp: Appointment.getAppKeyList()){
                     currentAppInst = (Appointment) AppointmentComponent.getAppointment(temp);
                        if(currentAppInst.getAPPDateAndTime().getMonth() == ldtFirstOfMonthToSearch.getMonth() ){
                            if(currentAppInst.getCancelled() == true){
                                textToDisplay += currentAppInst.toString() + currentAppInst.getAllPresDetailsForAppAsString();
                            }
                            
                        }
                         
                  }
                 
                  // populate the textarea on the Secretary JFrame
                    JPartPanelTextAreaMonthReports singInst = JPartPanelTextAreaMonthReports.getInstance();
                    singInst.setJtextArea(textToDisplay);
              }
                
                 if (cmbReportType.getSelectedItem().toString() == "Missed"){
                     
                       String textToDisplay ="";
                 for(String temp: Appointment.getAppKeyList()){
                     currentAppInst = (Appointment) AppointmentComponent.getAppointment(temp);
                        if(currentAppInst.getAPPDateAndTime().getMonth() == ldtFirstOfMonthToSearch.getMonth() ){
                            if(currentAppInst.getMissed() == true){
                                textToDisplay += currentAppInst.toString() + currentAppInst.getAllPresDetailsForAppAsString();
                            }
                            
                        }
                         
                  }
                 
                  // populate the textarea on the Secretary JFrame
                    JPartPanelTextAreaMonthReports singInst = JPartPanelTextAreaMonthReports.getInstance();
                    singInst.setJtextArea(textToDisplay);
                  
              }
         
            
        }
        
        
        //report for SysUserDoctor's monthly appointments
        else if (typeOfReport == "Report Doctor's appointments for the month of..."){
            
 
            
             // set the currentdoctor as this doctor - keeping wit the whole platform - will be used to call the method next
             
             //NOT NEEDED IN THIS CLASS NOW - OBJECT COMP DONE INSTEAD
           SysUserDoctor.currentDoctor = (SysUserDoctor) SystemUserComponent.getSystemUserComponent(JPanelReportsDrsApps.getInstance().getSelectedDr());
            
           
           SysUserDoctor currentDoctorInst = (SysUserDoctor) SystemUserComponent.getSystemUserComponent(JPanelReportsDrsApps.getInstance().getSelectedDr());
   
            //call the correct method in the SysUserDoctor class, which checks a doctor's taken appointments
            //called by passing a doctor and a localdate time to use to see appointments for
            //held in a list
           // List<LocalDateTime> tempHolder = SysUserDoctor.getDocsMonthlySetAppointments(SysUserDoctor.currentDoctor, ldtFirstOfMonthToSearch);
            //String textToDisplay ="";
           // for(LocalDateTime temp : tempHolder){
               // textToDisplay += temp.toString();
           // }
            String textToDisplay ="";
            for(String temp: currentDoctorInst.getAppKeyList()){
                currentAppInst = (Appointment) AppointmentComponent.getAppointment(temp);
                
                if(currentAppInst.getAPPDateAndTime().getMonth() == ldtFirstOfMonthToSearch.getMonth() )
                textToDisplay += currentAppInst.toString() +  currentAppInst.getAllPresDetailsForAppAsString();
                
            }
            
            
            
          // populate the textarea on the Secretary JFrame
          JPartPanelTextAreaMonthReports singInst = JPartPanelTextAreaMonthReports.getInstance();
            singInst.setJtextArea(textToDisplay);
        }
        
        else if (typeOfReport == "Report all prescriptions issued for the month of..."){
            
            String textToDisplay ="";
            
            //looks at all appointments there has been
            for(String temp: Appointment.getAppKeyList()){
                //look at the first appointment
               currentAppInst = (Appointment) AppointmentComponent.getAppointment(temp);
               
               
                //currentPresInst = (Prescription) PrescriptionComponent.getMainPrescription(temp);
                
                if(currentAppInst.getAPPDateAndTime().getMonth() == ldtFirstOfMonthToSearch.getMonth() )
                    
                    //tests whether the prescription for the appointment returns this particular string, because if it
                    //does, it means the appointment doesn;t have a prescription yet, therefore it won;t add it to
                    //the report
                    if (currentAppInst.getPrescriptionIDsAsString() != "There is no prescription for this appointment yet"){
                        textToDisplay += currentAppInst.toString() +  currentAppInst.getAllPresDetailsForAppAsString();
                    }
                
                
            }
               // populate the textarea on the Secretary JFrame
          JPartPanelTextAreaMonthReports singInst = JPartPanelTextAreaMonthReports.getInstance();
            singInst.setJtextArea(textToDisplay);
            
            
            
        }
        
    }
    
}
