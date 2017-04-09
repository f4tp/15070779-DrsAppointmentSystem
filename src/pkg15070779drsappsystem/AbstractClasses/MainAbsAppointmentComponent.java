
package pkg15070779drsappsystem.AbstractClasses;
import java.util.*;
import pkg15070779drsappsystem.MainClasses.MainAppointment;
public abstract class MainAbsAppointmentComponent {
    private static Map<String, MainAppointment> mapAppointments = new TreeMap<>(); 
    
    //the array will store the Drs name in here if they have an appointment on a certain day, at a certaintime
    //@@@@@ need to work out how many days the first part of the array is from the first index set of the array - thsi will give the date
        //e.g. above - day 0 will be Jan 1 2017
    //@@@@@ need to work out how many slots the second part array is from 1 as this is the time of teh appointment
        //e.g. above - 1 is 9:00am, 
    //@@@@@need to check Drs name before they are added to the timetable, if they are already in a slot, they can't be in there twice
    private static String [ ][ ] arryStrAppointTimeTable = new String[364][31];

  
    //no constructor as it is an abstract class
    
    //generates a uniqueKey for each appointment created
    public String generateAppUniqueKey(){
        int noExistApps = mapAppointments.size() + 1;
        return "Appointment" + Integer.toString(noExistApps);
    }
    
    
    public void setPutInMap(String uKey, MainAppointment passedIn){
         mapAppointments.put(uKey, passedIn);
    }
    
    public MainAppointment getAppointment(String uniqueKey){
        return mapAppointments.get(uniqueKey);
    }
    
    
    
    
    
}
