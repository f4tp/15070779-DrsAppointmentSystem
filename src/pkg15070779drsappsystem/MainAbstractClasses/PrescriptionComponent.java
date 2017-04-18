package pkg15070779drsappsystem.MainAbstractClasses;

import java.util.*;

public abstract class PrescriptionComponent {
    private static Map<String, PrescriptionComponent> mapPrescriptions = new TreeMap<>();
    
    //protected PrescriptionComponent(){
       // generatePresUniKey();
  // }
    
    public String generatePresUniKey(){
        int noExistApps = mapPrescriptions.size() + 1;
        return "Prescription" + Integer.toString(noExistApps);
    }
    
 public static PrescriptionComponent getMainPrescription(String keyforscript){
     return mapPrescriptions.get(keyforscript);
 }
 
  public static void setPutInMap(String key, PrescriptionComponent passedIn){
         mapPrescriptions.put(key, passedIn);

    }
    
    
}
