package pkg15070779drsappsystem.MainAbstractClasses;

import java.util.*;
import static jdk.nashorn.internal.objects.NativeArray.map;
public abstract class SystemUserComponent {
//@@@@@@@@@@ static variables  @@@@@@@@@@
    protected static Map<String, SystemUserComponent> mapSystemUsers = new HashMap<>();
    public static SystemUserComponent currentSystemUser; //polymorphism - this will be initialised with an object of its subtype when a user logs in

     
//@@@@@@@@@@ GETTERS @@@@@@@@@@   
   
    //returns a SystemUserComponent object when passed a key
     public static SystemUserComponent getSystemUserComponent(String key){
         return mapSystemUsers.get(key);
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
    
        public static String getGenerateUsername(String fname, String sname, String dob){
        return fname.toLowerCase() + "." + sname.toLowerCase() + "." + dob.toLowerCase();
    }
    
//@@@@@@@@@@ SETTERS@@@@@@@@@@

         public static void setCurrentSystemUser(String key){
         //polymorphism - will have to parse object when it gotten from here
          currentSystemUser = getSystemUserComponent(key);
     }

    public static void setPutInMap(String key, SystemUserComponent passedIn){
         mapSystemUsers.put(key, passedIn);

    }

    
}
