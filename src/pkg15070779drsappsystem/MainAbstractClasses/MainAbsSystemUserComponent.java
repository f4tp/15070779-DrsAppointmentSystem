package pkg15070779drsappsystem.MainAbstractClasses;

import java.util.*;
import static jdk.nashorn.internal.objects.NativeArray.map;
public abstract class MainAbsSystemUserComponent {
//@@@@@@@@@@ static variables  @@@@@@@@@@
    protected static Map<String, MainAbsSystemUserComponent> mapSystemUsers = new HashMap<>();
    public static MainAbsSystemUserComponent currentSystemUser; //polymorphism - this will be initialised with an object of its subtype when a user logs in

 //returns a MainAbsSystemUserComponent object when passed a key
     public static MainAbsSystemUserComponent getSystemUserComponent(String key){
         return mapSystemUsers.get(key);
     }
     
     public static void setCurrentSystemUser(String key){
         //polymorphism - will have to parse object when it gotten from here
          currentSystemUser = getSystemUserComponent(key);
     }
     
//see if the login name is in the map, returns true if it is
    public static Boolean getLoginCheckUserExists(String userNamePassed) {
        if (mapSystemUsers.containsKey(userNamePassed)){
            currentSystemUser = getSystemUserComponent(userNamePassed);
            return true;
        }
        else {;
             return false;
        }
    }
    
//@@@@@@@@@@ SETTERS@@@@@@@@@@
    public static String setGenerateUsername(String fname, String sname, String dob){
        return fname.toLowerCase() + "." + sname.toLowerCase() + "." + dob.toLowerCase();
    }
       

    public static void setPutInMap(String key, MainAbsSystemUserComponent passedIn){
         mapSystemUsers.put(key, passedIn);

    }

    
}
