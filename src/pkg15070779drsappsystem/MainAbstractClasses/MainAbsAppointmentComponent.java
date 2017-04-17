
package pkg15070779drsappsystem.MainAbstractClasses;
import java.util.*;
import pkg15070779drsappsystem.MainClasses.MainAppointment;
public abstract class MainAbsAppointmentComponent {
    private static Map<String, MainAppointment> mapAppointments = new TreeMap<>(); 

  
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
