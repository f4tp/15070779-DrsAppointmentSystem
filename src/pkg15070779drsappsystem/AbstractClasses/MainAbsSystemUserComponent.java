package pkg15070779drsappsystem.AbstractClasses;

import java.util.*;
import static jdk.nashorn.internal.objects.NativeArray.map;
public abstract class MainAbsSystemUserComponent {
//@@@@@@@@@@ class variables  @@@@@@@@@@
    protected static Map<String, MainAbsSystemUserComponent> mapSystemUsers = new HashMap<>();
    
    public static MainAbsSystemUserComponent currentSystemUser; //polymorphism - this will be initialised with an object of its subtype
    //public static MainAbsSystemUserComponent foundSystemUser; //polymorphism - this will be initialised with an object of its subtype
    
    
    public static String currentUsername;
//@@@@@@@@@@ instance variables  @@@@@@@@@@
    
    //private String strFirstName, strSurname, strTitle, strUserName;
   // private String dateOfBirth;

//@@@@@@@@@@ constructors  @@@@@@@@@@
    protected MainAbsSystemUserComponent(){
        //setCreateSystemUser(fname, sname, title, dob);//creates a new system user and adds it to the system user list
        //reportAllUsers(); //this code was used to test the report all users method, not needed
    }
    
    //private void setCreateSystemUser(String fname, String sname, String title, String dob){
        //this.strFirstName = fname;
       // this.strSurname = sname;
       // this.strTitle = title;
        //this.dateOfBirth = dob;
       // this.strUserName = setGenerateUsername(this.strFirstName, this.strSurname, this.dateOfBirth);
   // }
    
//@@@@@@@@@@ getters  @@@@@@@@@@
    
    //public String getUserName(MainAbsSystemUserComponent passedin){
       //return this.strUserName;
    //}
    
    //protected String getDOB(){
        //return this.dateOfBirth;
    //}
    
    //public String getFirstName(){
        //return this.strFirstName;
    //}
    
    //public String getSurname(){
        //return this.strSurname;
    //}
    
    // public String getTitle(){
    //    return this.strTitle;
    //}
    
    
    
    
     //returns a MainAbsSystemUserComponent object when passed a key
    //used in adding Doctors to patient objects
    //used in setting the system user preferences
     public static MainAbsSystemUserComponent getSystemUserComponent(String key){
         return mapSystemUsers.get(key);
     }
     
     public static void setCurrentSystemUser(String key){
         //polymorphism - sets object subtype here
          currentSystemUser = getSystemUserComponent(key);
     }
     
     
     //will return a doctor object when passed a value that the doctor will have in it
     //can use to get the key from the Doctor name that will appear in the combo box
     public static Object resolvekeyWithDrName(Object drname){
         
        // if(mapSystemUsers.containsValue(drname)){
           for (Object o : mapSystemUsers.keySet()) {
                if (mapSystemUsers.get(o).equals(drname)) {
                    return o;
                }
            }
                return null;
        // }		

    }
     
     
     //public static void setFoundSystemUser(String key){
         //polymorphism - sets object subtype here
         // foundSystemUser = getSystemUserComponent(key);
     //}
     
    
     

    
     //see if the login name is in the map, returns true if it is
    public static Boolean getCheckLogin(String userNamePassed) {
        if (mapSystemUsers.containsKey(userNamePassed)){
            currentUsername = userNamePassed;
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
    
//@@@@@@@@@@ Other methods @@@@@@@@@@
     //getObject() - object details passed back like this
    
   

     
    //this can be deleted when it isn't needed
     private void reportAllUsers(){
        for (MainAbsSystemUserComponent sysUser : mapSystemUsers.values ()) {                        // <4>
            System.out.println (sysUser);
        }
     }
    
     
     //need to add all other methods in here for patient, dr, sec, pharm
     
}
