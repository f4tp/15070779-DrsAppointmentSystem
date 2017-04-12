
package pkg15070779drsappsystem.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsScheduling;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsSystemUserComponent;
import pkg15070779drsappsystem.JPanels.JPanelReportsDrsApps;
import pkg15070779drsappsystem.MainClasses.MainDoctor;

public class ActListRunReport implements ActionListener {
    private String typeOfReport;
    private String monthFrom;
    private String yearFrom;
    public ActListRunReport(String typeofreport, String month, String year){
        this.typeOfReport = typeofreport;
        this.monthFrom = month;
        this.yearFrom = year;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        //the type of report to run is based on the text in the label of the JPanel, this determines which data is to
        //be used... the same place will be populated with the details (the abstract jpanel)
        if (typeOfReport == "Report all Appointments for the month of..."){
            
        }
        
        else if (typeOfReport == "Report Doctor's appointments for the month of..."){
            
            //generate a full date, set it to the first
           LocalDateTime temp = MainAbsScheduling.getConvStringToDateTime("01"+this.monthFrom+this.yearFrom+"0000");
         
             // set the currentdoctor as this doctor - keeping wit the whole platform - will be used to call the method next
                 MainDoctor.currentDoctor = (MainDoctor) MainAbsSystemUserComponent.getSystemUserComponent(JPanelReportsDrsApps.getInstance().getSelectedDr());
            
            //call the correct method in the MainDoctor class, which checks a doctor's taken appointments
            //called by passing a doctor and a localdate time to use to see appointments for
            MainDoctor.getDocsMonthlySetAppointments(MainDoctor.currentDoctor, temp);

                    
        }
        
        else if (typeOfReport == "Report all prescriptions issued for the month of..."){
            
        }
        
    }
    
}
