package pkg15070779drsappsystem.MainAbstractClasses;

import java.util.*;
import pkg15070779drsappsystem.MainClasses.MainAppointment;


public abstract class MainAbsPrescriptionComponent {
    private static Map<String, MainAppointment> mapPrescription = new TreeMap<>();
    
    protected MainAbsPrescriptionComponent(){
        generatePresUniKey();
        
    }
    
    private String generatePresUniKey(){
        int noExistApps = mapPrescription.size() + 1;
        return "Medicine" + Integer.toString(noExistApps);
    }
    
    
    

    
   
    
    
    
    
    
    
}
