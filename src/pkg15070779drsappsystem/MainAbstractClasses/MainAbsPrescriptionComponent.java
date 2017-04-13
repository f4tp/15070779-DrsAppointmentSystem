package pkg15070779drsappsystem.MainAbstractClasses;

import java.util.*;
import pkg15070779drsappsystem.MainClasses.MainAppointment;
import pkg15070779drsappsystem.MainClasses.MainPrescription;


public abstract class MainAbsPrescriptionComponent {
    private static Map<String, MainPrescription> mapPrescriptions = new TreeMap<>();
    
    protected MainAbsPrescriptionComponent(){
        generatePresUniKey();
        
    }
    
    public String generatePresUniKey(){
        int noExistApps = mapPrescriptions.size() + 1;
        return "Medicine" + Integer.toString(noExistApps);
    }
    
 public static MainPrescription getMainPrescription(String keyforscript){
     return mapPrescriptions.get(keyforscript);
 }
    
    
}
