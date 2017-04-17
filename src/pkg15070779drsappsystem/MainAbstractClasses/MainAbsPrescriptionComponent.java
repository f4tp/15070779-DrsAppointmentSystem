package pkg15070779drsappsystem.MainAbstractClasses;

import java.util.*;

public abstract class MainAbsPrescriptionComponent {
    private static Map<String, MainAbsPrescriptionComponent> mapPrescriptions = new TreeMap<>();
    
    protected MainAbsPrescriptionComponent(){
        generatePresUniKey();
    }
    
    public String generatePresUniKey(){
        int noExistApps = mapPrescriptions.size() + 1;
        return "Prescription" + Integer.toString(noExistApps);
    }
    
 public static MainAbsPrescriptionComponent getMainPrescription(String keyforscript){
     return mapPrescriptions.get(keyforscript);
 }
 
  public static void setPutInMap(String key, MainAbsPrescriptionComponent passedIn){
         mapPrescriptions.put(key, passedIn);

    }
    
    
}
