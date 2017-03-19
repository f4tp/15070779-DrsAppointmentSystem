
package pkg15070779drsappsystem;
import java.util.*;
public abstract class AppointmentComponent {
    private static Map<String, Appointment> mapAppointments = new TreeMap<>();
    //private String AppUniqueKey;      
    //no constructor as it is an abstract class
    
    //generates a uniqueKey for each appointment created
    public String generateAppUniqueKey(){
        int noExistApps = mapAppointments.size() + 1;
        return "Appointment" + Integer.toString(noExistApps);
    }
    
    public void setPutInMap(String uKey, Appointment passedIn){
         mapAppointments.put(uKey, passedIn);
    }
    
    
    
}
