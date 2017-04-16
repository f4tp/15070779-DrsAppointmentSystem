
package pkg15070779drsappsystem.ListenersAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsScheduling;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsSystemUserComponent;
import pkg15070779drsappsystem.JPanels.JPanelAppsShowAllForDoctor;
import pkg15070779drsappsystem.JPanels.JPartPanelAppsSelDateFlow;
import pkg15070779drsappsystem.JPanels.JPartPanelSelDrComboFlow;
import pkg15070779drsappsystem.MainClasses.MainDoctor;

public class ActListPerfSearchAllAvailAppointments implements ActionListener{
    
    //private JPartPanelSelDrComboFlow drJPan;
    private JPartPanelAppsSelDateFlow dateFromJPan;
    private JPartPanelAppsSelDateFlow dateToJPan;
    public static List <LocalDateTime> lstFoundAvailableApps = new ArrayList<>();
    
    
    //don;t have to pass the Dr JPan in as this is a single instance, can get it statically when needeed 
    public ActListPerfSearchAllAvailAppointments(JPartPanelAppsSelDateFlow datefromjpan, JPartPanelAppsSelDateFlow datetojpan ){

        this.dateFromJPan = datefromjpan;
        this.dateToJPan = datetojpan;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       
        //get the from date selected by the user and construct it into a LocalDateTime object
        //time had to be set at 17:15 as this date is set the day before so this particular date can be included in 
        //the search, but it needs to search from the day before at a time when appointments 
        //are not available otherwise it will include these also
        LocalDateTime ldtFrom = MainAbsScheduling.getConvStringToDateTime(this.dateFromJPan.getDateDayString() + this.dateFromJPan.geDateMonthString() + this.dateFromJPan.getDateYearString() + "1715");
        
        //get the to date selected by the user and construct it into a LocalDateTime object - time set at 0000
        LocalDateTime ldtTo = MainAbsScheduling.getConvStringToDateTime(this.dateToJPan.getDateDayString() + this.dateToJPan.geDateMonthString() + this.dateToJPan.getDateYearString() + "0000");
  
        
         //sets the main doctor to the selected Dr in the combo box - this is a static variable used to hold any
           //doctor that is searched for
           MainDoctor.currentDoctor = (MainDoctor) MainAbsSystemUserComponent.getSystemUserComponent(JPartPanelSelDrComboFlow.getInstance().getDoctorString());
        
        
        //   public static list is cleared each time a search is done, then populated with found available appointments
        //for the given Dr
        if (lstFoundAvailableApps.isEmpty()){
            
            //run method to generate available appointments
            lstFoundAvailableApps = MainDoctor.getDocsAvailableAppointments(MainDoctor.currentDoctor, ldtFrom, ldtTo);
        }
        else{
        lstFoundAvailableApps.clear();
        //run method to generate available appointments
        lstFoundAvailableApps = MainDoctor.getDocsAvailableAppointments(MainDoctor.currentDoctor, ldtFrom, ldtTo);
        }
        
        JPanelAppsShowAllForDoctor.updateFoundAppointments(lstFoundAvailableApps);
  
    }
    
    

    
}
