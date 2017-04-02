package pkg15070779drsappsystem;

import java.util.*;


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
