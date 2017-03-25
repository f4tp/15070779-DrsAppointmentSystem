package pkg15070779drsappsystem;

import java.util.*;


public abstract class PrescriptionComponent {
    private static Map<String, Appointment> mapPrescription = new TreeMap<>();
    
    protected PrescriptionComponent(){
        generatePresUniKey();
        
    }
    
    private String generatePresUniKey(){
        int noExistApps = mapPrescription.size() + 1;
        return "Medicine" + Integer.toString(noExistApps);
    }
    
    
    

    
   
    
    
    
    
    
    
}
