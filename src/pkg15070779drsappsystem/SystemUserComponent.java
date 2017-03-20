package pkg15070779drsappsystem;

import java.util.*;
public abstract class SystemUserComponent {
//@@@@@@@@@@ class variables  @@@@@@@@@@
    private static Map<String, SystemUserComponent> mapSystemUsers = new HashMap<>();
//@@@@@@@@@@ instance variables  @@@@@@@@@@
        private String strFirstName, strSurname, strTitle, strUserName;
    private int yearOfBirth;

//@@@@@@@@@@ constructors  @@@@@@@@@@
    protected SystemUserComponent(String fname, String sname, String title, int yob){
        setCreateSystemUser(fname, sname, title, yob);//creates a new system user and adds it to the system user list
        //reportAllUsers(); //this code was used to test the report all users method, not needed
    }
    
    private void setCreateSystemUser(String fname, String sname, String title, int yob){
        this.strFirstName = fname;
        this.strSurname = sname;
        this.strTitle = title;
        this.yearOfBirth = yob;
        this.strUserName = setGenerateUsername(this.strFirstName, this.strSurname, this.yearOfBirth);
    }
    
//@@@@@@@@@@ getters  @@@@@@@@@@
    
     //returns a SystemUserComponent object when passed a key
     protected SystemUserComponent getSystemUserComponent(String key){
         return mapSystemUsers.get(key);
     }
     
    
    //getObject() - object details passed back like this
    @Override
    public String toString () {
        return "UserName: " + strUserName + ", Details: " + strTitle + " " + strFirstName + " " + strSurname + ", Year of Birth: " + Integer.toString(yearOfBirth);
    }
    
    protected String getUserName(SystemUserComponent sysUseObj){
        return sysUseObj.strUserName;
    }
    
    protected String getFirstName(SystemUserComponent uName){
        return uName.strFirstName;
    }
    
    protected String getSurname(SystemUserComponent uName){
        return uName.strSurname;
    }
    
     protected String getTitle(SystemUserComponent uName){
        return uName.strTitle;
    }
    
     //see if the login name is in the map, returns true if it is
    public static Boolean getCheckLogin(String userNamePassed) {
        if (mapSystemUsers.containsKey(userNamePassed)){
            return true;
        }
        else {
             return false;
        }
    }
    
//@@@@@@@@@@ SETTERS@@@@@@@@@@
    private String setGenerateUsername(String fname, String sname, int yob){
        String yobAsString = Integer.toString(yob);
        return fname.toLowerCase() + "." + sname.toLowerCase() + "." + yobAsString;
    }
       

    public void setPutInMap(SystemUserComponent passedIn){
        String uname = getUserName(this);
        mapSystemUsers.put(uname,passedIn);
    }
    
        
     
     
   
        
    
     
    //this can be deleted when it isn't needed
     private void reportAllUsers(){
        for (SystemUserComponent sysUser : mapSystemUsers.values ()) {                        // <4>
            System.out.println (sysUser);
        }
     }
    
     
     //need to add all other methods in here for patient, dr, sec, pharm
     
}
