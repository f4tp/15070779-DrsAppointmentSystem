package pkg15070779drsappsystem;

import java.util.*;
public abstract class MainAbsSystemUserComponent {
//@@@@@@@@@@ class variables  @@@@@@@@@@
    protected static Map<String, MainAbsSystemUserComponent> mapSystemUsers = new HashMap<>();
    public static String currentUsername;
    public static MainAbsSystemUserComponent currentSystemUser; //polymorphism - this will be initialised with an object of its subtype
//@@@@@@@@@@ instance variables  @@@@@@@@@@
    
    private String strFirstName, strSurname, strTitle, strUserName;
    private String dateOfBirth;

//@@@@@@@@@@ constructors  @@@@@@@@@@
    protected MainAbsSystemUserComponent(String fname, String sname, String title, String dob){
        setCreateSystemUser(fname, sname, title, dob);//creates a new system user and adds it to the system user list
        //reportAllUsers(); //this code was used to test the report all users method, not needed
    }
    
    private void setCreateSystemUser(String fname, String sname, String title, String dob){
        this.strFirstName = fname;
        this.strSurname = sname;
        this.strTitle = title;
        this.dateOfBirth = dob;
        this.strUserName = setGenerateUsername(this.strFirstName, this.strSurname, this.dateOfBirth);
    }
    
//@@@@@@@@@@ getters  @@@@@@@@@@
    
     //returns a MainAbsSystemUserComponent object when passed a key
     public static MainAbsSystemUserComponent getSystemUserComponent(String key){
         return mapSystemUsers.get(key);
     }
     
            
    protected String getUserName(MainAbsSystemUserComponent sysUseObj){
        return sysUseObj.strUserName;
    }
    
    protected String getDOB(MainAbsSystemUserComponent sysUseObj){
        return sysUseObj.dateOfBirth;
    }
    
    protected String getFirstName(MainAbsSystemUserComponent uName){
        return uName.strFirstName;
    }
    
    protected String getSurname(MainAbsSystemUserComponent uName){
        return uName.strSurname;
    }
    
     protected String getTitle(MainAbsSystemUserComponent uName){
        return uName.strTitle;
    }
    
     //see if the login name is in the map, returns true if it is
    public static Boolean getCheckLogin(String userNamePassed) {
        if (mapSystemUsers.containsKey(userNamePassed)){
            currentUsername = userNamePassed;
            currentSystemUser = getSystemUserComponent(userNamePassed);
            System.out.println(currentSystemUser);
            return true;
        }
        else {;
             return false;
        }
    }
    
//@@@@@@@@@@ SETTERS@@@@@@@@@@
    private String setGenerateUsername(String fname, String sname, String dob){
        return fname.toLowerCase() + "." + sname.toLowerCase() + "." + dob.toLowerCase();
    }
       

    public void setPutInMap(MainAbsSystemUserComponent passedIn){
        String uname = getUserName(this);
        mapSystemUsers.put(uname,passedIn);
    }
    
//@@@@@@@@@@ Other methods @@@@@@@@@@
     //getObject() - object details passed back like this
    @Override
    public String toString () {
        return "UserName: " + strUserName + ", Details: " + strTitle + " " + strFirstName + " " + strSurname + ", Year of Birth: " + dateOfBirth + " Object Type: " + super.toString();
    }
     
    //this can be deleted when it isn't needed
     private void reportAllUsers(){
        for (MainAbsSystemUserComponent sysUser : mapSystemUsers.values ()) {                        // <4>
            System.out.println (sysUser);
        }
     }
    
     
     //need to add all other methods in here for patient, dr, sec, pharm
     
}
