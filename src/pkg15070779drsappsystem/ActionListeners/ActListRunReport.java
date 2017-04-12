
package pkg15070779drsappsystem.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.List;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsScheduling;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsSystemUserComponent;
import pkg15070779drsappsystem.JPanels.JPanelReportsDrsApps;
import pkg15070779drsappsystem.JPanels.JPartPanelTextAreaMonthReports;
import pkg15070779drsappsystem.MainClasses.MainDoctor;

public class ActListRunReport implements ActionListener {
    private String typeOfReport;
    private String monthFrom;
    private String yearFrom;
    LocalDateTime ldtMonthOnly;
    public ActListRunReport(String typeofreport, String month, String year){
        this.typeOfReport = typeofreport;
        this.monthFrom = month;
        this.yearFrom = year;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
         //generate a full date, set it to the first
          ldtMonthOnly = MainAbsScheduling.getConvStringToDateTime("01"+this.monthFrom+this.yearFrom+"0000");
        
        //the type of report to run is based on the text in the label of the JPanel, this determines which data is to
        //be used... the same place will be populated with the details (the abstract jpanel)
        if (typeOfReport == "Report all Appointments for the month of..."){
            
        }
        
        else if (typeOfReport == "Report Doctor's appointments for the month of..."){
            
             // set the currentdoctor as this doctor - keeping wit the whole platform - will be used to call the method next
             MainDoctor.currentDoctor = (MainDoctor) MainAbsSystemUserComponent.getSystemUserComponent(JPanelReportsDrsApps.getInstance().getSelectedDr());
            
            //call the correct method in the MainDoctor class, which checks a doctor's taken appointments
            //called by passing a doctor and a localdate time to use to see appointments for
            //held in a list
            List<LocalDateTime> tempHolder = MainDoctor.getDocsMonthlySetAppointments(MainDoctor.currentDoctor, ldtMonthOnly);
            String textToDisplay ="";
            for(LocalDateTime temp : tempHolder){
                textToDisplay += temp.toString();
            }
            
            // NTD populate the textarea on the Secretary JFrame (is a JPanel embedded... need to find)
           
          JPartPanelTextAreaMonthReports singInst = JPartPanelTextAreaMonthReports.getInstance();
            singInst.setJtextArea(textToDisplay);
        }
        
        else if (typeOfReport == "Report all prescriptions issued for the month of..."){
            
        }
        
    }
    
}
