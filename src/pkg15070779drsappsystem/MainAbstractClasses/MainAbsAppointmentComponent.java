
package pkg15070779drsappsystem.MainAbstractClasses;
import java.util.*;
import pkg15070779drsappsystem.MainClasses.MainAppointment;
public abstract class MainAbsAppointmentComponent {
    private static Map<String, MainAppointment> mapAppointments = new TreeMap<>(); 
    
    //the array will store the Dr's username in here if they have an appointment on a certain day, at a certaintime
    //@@@@@ need to work out how many days the first part of the array is from the first index set of the array - this will give the date
        //e.g. above - day 0 will be Jan 1 2017
    //@@@@@ need to work out how many slots the second part array is from 1 as this is the time of the appointment
        //e.g. above - 1 is 9:00am, 
    //@@@@@need to check Drs name before they are added to the timetable, if they are already in a slot, they can't be in there twice
   // private static String [ ][ ] arryStrAppointTimeTable = new String[364][31];

  
    //no constructor as it is an abstract class
    
   
    //example spec comment
    /**
   * /instance method, generates a uniqueKey for each appointment created
   * x+yi. 
   * @param x The real part of the complex number. 
   * @param y The imaginary part of the complex number. 
   */
    
    

    /**
   * /instance method; generates a uniqueKey for each appointment created.
   */
    public String generateAppUniqueKey(){
        int noExistApps = mapAppointments.size() + 1;
        return "Appointment" + Integer.toString(noExistApps);
    }
    
   /**
   * /instance method; puts the appointment object  in the map.
   */
    public static void setPutInMap(String uKey, MainAppointment passedIn){
         mapAppointments.put(uKey, passedIn);
    }
     /**
   * /instance method; pass this routine the unique appointment number and it will return the appointment object.
   */
    public  static MainAppointment getAppointment(String uniqueKey){
        return mapAppointments.get(uniqueKey);
    }
    
     
}
